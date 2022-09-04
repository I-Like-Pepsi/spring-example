package com.buydeem.container.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zengchao
 * @email zengchaowork@foxmail.com
 * @date 2022/9/4 11:41
 */
@Component
@Aspect
@Slf4j
public class TokenAspect {

    @Pointcut("execution (public * com.buydeem.container.controller..*.*(..))")
    //@Pointcut("execution (public * com.buydeem.container.service..*.*(..))")
    public void point(){

    }

    @Before("point()")
    public void before(){
      log.info("before");
    }

}
