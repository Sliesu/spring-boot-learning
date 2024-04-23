<img src="doc/img/rbc-logo.png" style="width: 40%;margin-bottom: -50px" alt="RBC Logo"/>

# Spring Boot 学习项目
![Spring Boot 3.2.3](https://img.shields.io/badge/Spring%20Boot-3.2.3-brightgreen.svg)
![Mysql 8.0.32](https://img.shields.io/badge/Mysql-8.0.32-blue.svg)
![JDK 17](https://img.shields.io/badge/JDK-17-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-3.9.6-yellowgreen.svg)
![license](https://img.shields.io/badge/license-MulanPSL2.0-blue.svg)

@RainbowCloud_CrispShark

**1. Spring Boot起步练习**

模块名称：`spring-boot-quickstart`

模块描述：
本模块学习搭建Spring Boot框架，通过简单的示例演示如何创建一个Spring Boot项目，学习Spring Boot的快速搭建和接口编写，使用Restful实现接口的测试，还有导入Maven依赖。

------

**2. Spring Boot配置管理**

模块名称：`spring-boot-config`

模块描述：
本模块学习Spring Boot的配置管理功能。学习1、编写配置文件（如application.properties或application.yml）；2、如何通过配置文件管理应用的各种属性；3、如何利用Spring Boot提供的Profile功能实现不同环境下的配置切换。

------

**3. Spring Boot整合静态资源与模板引擎**

模块名称：`spring-boot-template`

模块描述：
本模块示Spring Boot如何整合静态资源和模板引擎编写一个门户网站。学习如何将静态资源放置在正确的位置，以便Spring Boot能够自动识别和加载。学习如何使用模板引擎来构建静态页面，使用bootstrap框架仿制简书的推荐用户界面。

<img src="doc/img/jianshu-page.png" style="width: 40%;" alt="仿简书页面"/>

------

**4. Spring Boot整合数据库框架**

模块名称：`spring-boot-database`

模块描述：
本模块学习如何使用Spring Boot整合数据库框架，如MyBatis、JPA等。学习如何编写实体类，如何编写Mapper接口，如何编写Service接口，如何编写Controller接口。

------

**5. Spring Boot整合Mybatis综合练习**

模块名称：`spring-boot-mybatis`

模块描述：
本模块学习如何使用Spring Boot整合mybatis。实现MyBatis的关联查询，如一对一，一对多，多对一，模糊查询，多表查询等，并编写测试类测试Mapper执行的结果。

------

**5.5. Spring Boot整合Mybatis-plus综合练习**

模块名称：`spring-boot-mybatis-plus`和`spring-boot-mp`

模块描述：
本模块学习如何使用Spring Boot整合Mybatis-plus。学习如何使用Mybatis-plus的注解方式实现CRUD操作，如何使用Mybatis-plus的条件构造器，如何使用Mybatis-plus的分页插件等，如何使用Mybatis-plus的BaseMapper简化Mapper书写。

------

**6. Spring Boot日志框架与日志管理**

模块名称：`spring-boot-log`

模块描述：
本模块学习如何在Spring Boot中配置和管理日志,包括:使用Spring Boot默认的Logback日志框架、使用log4j2日志框架、配置log4j2的日志级别、配置log4j2的日志格式、配置log4j2的日志路径(控制台,文件,滚动文件等)、使用Spring Boot提供的Logging系统。

------

**7. 全局统一异常处理**

模块名称：`spring-boot-exception`

模块描述：
本模块学习如何在Spring Boot中实现通用全局异常处理逻辑,自定义异常和相关数据结构,以及使用Spring Validation进行数据校验。包括以下内容:自定义异常类 ，使用Spring Validation进行数据校验，在业务层方法参数上使用@Valid注解进行数据校验 自定义校验规则

<img src="doc/img/add-user-page.png" style="width: 40%;" alt="统一异常处理前后端联调起前端页面"/>

------

**8. 整合分布式文件系统**

模块名称：`spring-boot-file`

模块描述：
该模块介绍了如何在Spring Boot项目中整合分布式文件系统，包括本地文件上传与访问服务，以及集成MinIO和阿里云OSS两种方案。具体内容包括：

- 实现文件的本地上传，并提供访问服务。
- 实现简介MinIO对象存储服务，以及如何在Spring Boot项目中使用MinIO实现文件存储与访问。
- 实现阿里云对象存储OSS服务，以及如何在Spring Boot项目中使用阿里云OSS实现文件存储与访问。

------

**9、Spring Boot整合Redis缓存数据库**

模块名称：`spring-boot-cache`和`spring-boot-reids-example`

模块描述：
本模块学习如何使用Spring Boot整合Redis缓存数据库。学习使用Spring Boot整合Redis，如何使用RedisTemplate操作Redis，如何使用Redis缓存数据，提高系统性能。并且集成容联云短信服务，实现短信验证码功能。