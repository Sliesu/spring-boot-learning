package com.rbc.boot.socket.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mqxu
 * @date 2024/5/13
 * @description WebSocketServer
 **/
@Component
@ServerEndpoint("/server/{uid}")
@Slf4j
public class WebSocketServer {
    /**
     * 记录当前在线连接数
     */
    private static int onlineCount = 0;

    /**
     * 使用线程安全的ConcurrentHashMap来存放每个客户端对应的WebSocket对象
     */
    private static final ConcurrentHashMap<String, WebSocketServer> WEB_SOCKET_MAP = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 接收客户端消息的uid
     */
    private String uid = "";

    /**
     * 连接建立成功调用的方法
     *
     * @param session session
     * @param uid     用户id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) {
        this.session = session;
        this.uid = uid;
        if (WEB_SOCKET_MAP.containsKey(uid)) {
            WEB_SOCKET_MAP.remove(uid);
            //加入到set中
            WEB_SOCKET_MAP.put(uid, this);
        } else {
            //加入set中
            WEB_SOCKET_MAP.put(uid, this);
            //在线数加1
            addOnlineCount();
        }

        log.info("用户{}连接成功，当前在线人数为:{}", uid, getOnlineCount());
        try {
            sendMsg("连接成功");
        } catch (IOException e) {
            log.error("用户{}网络异常!", uid, e);
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (WEB_SOCKET_MAP.containsKey(uid)) {
            WEB_SOCKET_MAP.remove(uid);
            //从set中删除
            subOnlineCount();
        }
        log.info("用户{}退出，当前在线人数为:{}", uid, getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户{}发送报文:{}", uid, message);
        //群发消息
        if (StringUtils.isNotBlank(message)) {
            try {
                //解析发送的报文
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, String> map = objectMapper.readValue(message, new TypeReference<>() {
                });
                //追加发送人(防止串改)
                map.put("fromUID", this.uid);
                String toUID = map.get("toUID");
                //传送给对应的toUserId用户的WebSocket
                if (StringUtils.isNotBlank(toUID) && WEB_SOCKET_MAP.containsKey(toUID)) {
                    WEB_SOCKET_MAP.get(toUID).sendMsg(objectMapper.writeValueAsString(map));
                } else {
                    //若果不在这个服务器上，可以考虑发送到mysql或者redis
                    log.error("请求目标用户{}不在该服务器上", toUID);
                }
            } catch (Exception e) {
                log.error("用户{}发送消息异常！", uid, e);
            }
        }
    }

    /**
     * 处理错误
     *
     * @param session session
     * @param error   error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户{}处理消息错误，原因:{}", this.uid, error.getMessage());
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     *
     * @param msg 消息
     */
    private void sendMsg(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }


    /**
     * 发送自定义消息
     *
     * @param message 消息
     * @param uid     用户id
     */
    public static void sendInfo(String message, @PathParam("uid") String uid) throws IOException {
        log.info("发送消息到用户{}发送的报文:{}", uid, message);
        if (!StringUtils.isEmpty(uid) && WEB_SOCKET_MAP.containsKey(uid)) {
            WEB_SOCKET_MAP.get(uid).sendMsg(message);
        } else {
            log.error("用户{}不在线！", uid);
        }
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}