package com.buydeem.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        //从子容器获取父容器中的ParentService实例
        ParentService parentService1 = childContainer.getBean(ParentService.class);
        //从父容器中获取ParentService实例
        ParentService parentService2 = parentContainer.getBean(ParentService.class);
        //对象是相同的
        log.info("parentService1 == parentService2 ? {}",parentService1 == parentService2);

        //无法从父容器获取子容器ChildService实例
        boolean contains = parentContainer.containsBean("childService");
        log.info("parent container contains childService {} ",contains);
        try {
            //会报错因为获取不到子容器中的ChildService实例
            ChildService temp = parentContainer.getBean(ChildService.class);
        }catch (NoSuchBeanDefinitionException e){
            log.error(e.getMessage());
        }


    }
}
