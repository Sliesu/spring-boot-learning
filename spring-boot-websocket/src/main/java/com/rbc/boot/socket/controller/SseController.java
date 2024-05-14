package com.rbc.boot.socket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class SseController {

    @RequestMapping(value = "/server/info", method = {RequestMethod.GET}, produces = "text/event-stream;charset=UTF-8")
    public ResponseBodyEmitter pushMsg() {
        final SseEmitter emitter = new SseEmitter(0L);
        log.info("emitter push message .....");
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        try {
            emitter.send(list.toString(), MediaType.TEXT_EVENT_STREAM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emitter;
    }

    @RequestMapping(value = "/server/data", method = {RequestMethod.GET}, produces = "text/event-stream;charset=UTF-8")
    public ResponseBodyEmitter push() {
        final SseEmitter emitter = new SseEmitter(0L);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        double money = Math.random() * 10;
        DecimalFormat df = new DecimalFormat(".00");
        String param = df.format(money);
        try {
            emitter.send("白菜价格行情:" + param + "元" + "\n\n", MediaType.TEXT_EVENT_STREAM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emitter;
    }

    @GetMapping("/page")
    public String getPage() {
        return "webSocket";
    }


}