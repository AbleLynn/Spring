package cn.IOC_LifeCycle.Test;

import cn.IOC_LifeCycle.one.Orders;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
    @Test
    public void testOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_IOC_LifeCycle.xml");
        Object orders = context.getBean("orders", Orders.class);
        System.out.println("第六步，获取创建bean实例对象");
        System.out.println(orders);
        //手动让bean销毁
        ((ClassPathXmlApplicationContext) context).close();
    }
}
