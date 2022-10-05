package cn.IOC_xmlAutoWrite.Test;

import cn.IOC_xmlAutoWrite.one.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
    @Test
    public void testOne(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_IOC_xmlAutoWrite.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
    @Test
    public void testOne_(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_IOC_xmlAutoWrite.xml");
        Emp emp = context.getBean("emp_", Emp.class);
        System.out.println(emp);
    }
    @Test
    public void testOne__(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_IOC_xmlAutoWrite.xml");
        Emp emp = context.getBean("emp__", Emp.class);
        System.out.println(emp);
    }
}
