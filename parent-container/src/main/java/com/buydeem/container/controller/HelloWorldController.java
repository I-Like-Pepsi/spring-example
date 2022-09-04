package com.buydeem.container.controller;

import com.buydeem.container.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author zengchao
 * @email zengchaowork@foxmail.com
 * @date 2022-08-30 10:28:51
 */
@RestController
@Slf4j
public class HelloWorldController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private ApplicationContext context;


    @GetMapping("hello")
    public String helloWorld(){
        //获取Service中的容器
        ApplicationContext parentContext = helloService.getContext();
        //service中的容器并不等于controller中的容器
        log.info("parentContext == context ? {}",parentContext == context);
        //controller中的容器的父容器就是service中的容器
        log.info("{}",parentContext == context.getParent());
        return helloService.sayHello();
    }
}
