package cn.IOC_annotation.Test;

import cn.IOC_annotation.Three.config.SpringConfig;
import cn.IOC_annotation.one.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpring5 {
    @Test
    public void testOne(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_IOC_annotation.xml");
        UserService userService = context.getBean("userService_one", UserService.class);
        userService.test();
    }
    @Test
    public void testTwo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_IOC_annotation.xml");
        cn.IOC_annotation.two.service.UserService userService = context.getBean("userService_two", cn.IOC_annotation.two.service.UserService.class);
        userService.test1();
        userService.test2();
        userService.test3();
        userService.testName();
    }
    @Test
    public void testThree(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        cn.IOC_annotation.Three.service.UserService userService = context.getBean("userService_three", cn.IOC_annotation.Three.service.UserService.class);
        userService.test1();
        userService.test2();
        userService.test3();
        userService.testName();
    }
}
