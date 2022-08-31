package com.buydeem.container.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author zengchao
 * @email zengchaowork@foxmail.com
 * @date 2022-08-30 10:44:23
 */
@Component
public class HelloService {

    @Autowired
    private ApplicationContext context;

    public String sayHello(){
        return "Hello World";
    }

    public ApplicationContext getContext(){
        return context;
    }

}
