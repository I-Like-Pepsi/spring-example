package com.buydeem.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 父子容器示例代码
 *
 * @author zengchao
 * @email zengchaowork@foxmail.com
 * @date 2022-08-30 17:03:52
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        //父容器
        ApplicationContext parentContainer = new AnnotationConfigApplicationContext(ParentContainerConfig.class);
        //子容器
        ConfigurableApplicationContext childContainer = new AnnotationConfigApplicationContext(ChildContainerConfig.class);
        childContainer.setParent(parentContainer);
        //从子容器中获取父容器中的Bean
        ParentService parentService = childContainer.getBean(ParentService.class);
        log.info("{}",parentService);
        //getBeansOfType无法获取到父容器中的Bean
        Map<String, ParentService> map = childContainer.getBeansOfType(ParentService.class);
        map.forEach((k,v) -> log.info("{} => {}",k,v));

        try {
            ChildService childService = parentContainer.getBean(ChildService.class);
            log.info("{}",childService);
        }catch (NoSuchBeanDefinitionException e){
            log.error(e.getMessage());
        }
    }
}
