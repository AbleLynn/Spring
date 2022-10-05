package cn.IOC_FactoryBean.Test;

import cn.IOC_FactoryBean.one.Course;
import cn.IOC_FactoryBean.one.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
    @Test
    public void testOne(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_IOC_FactoryBean.xml");
        MyBean mybean = context.getBean("mybean", MyBean.class);
        System.out.println(mybean);
        mybean.test();
    }
    @Test
    public void testOne_(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_IOC_FactoryBean.xml");
        Course Course = context.getBean("mybean_", Course.class);
        System.out.println(Course);
    }
}
