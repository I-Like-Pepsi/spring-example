package com.buydeem.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 父容器配置
 *
 * @author zengchao
 * @email zengchaowork@foxmail.com
 * @date 2022-08-30 17:21:13
 */
@Configuration
public class ChildContainerConfig {

    @Bean
    public ChildService childService(){
        return new ChildService();
    }

}
