package cn.IOC_xml.Test;

import cn.IOC_xml.five_six.Emp;
import cn.IOC_xml.seven_eight.Stu;
import cn.IOC_xml.two.Book;
import cn.IOC_xml.three.Orders;
import cn.IOC_xml.one.User;
import cn.IOC_xml.four.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
    @Test
    public void testOne(){
        //加载Spring 配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//ApplicationContext接口，获取xml文件，在获取、使用对象时创建对象
/*        BeanFactory context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//beanFactory接口，获取xml文件，在获取、使用对象时创建对象*/
        //获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.test();
    }
    @Test
    public void testTwo(){
        //加载Spring 配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//ApplicationContext接口，获取xml文件，在获取、使用对象时创建对象
/*        BeanFactory context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//beanFactory接口，获取xml文件，在获取、使用对象时创建对象*/
        //获取配置创建的对象
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.test();
    }
    @Test
    public void testThree_(){
        //加载Spring 配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//ApplicationContext接口，获取xml文件，在获取、使用对象时创建对象
/*        BeanFactory context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//beanFactory接口，获取xml文件，在获取、使用对象时创建对象*/
        //获取配置创建的对象
        Book book = context.getBean("book_p", Book.class);
        System.out.println(book);
        book.test();
    }
    @Test
    public void testFour(){
        //加载Spring 配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//ApplicationContext接口，获取xml文件，在获取、使用对象时创建对象
/*        BeanFactory context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//beanFactory接口，获取xml文件，在获取、使用对象时创建对象*/
        //获取配置创建的对象
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        orders.test();
    }
    @Test
    public void testFive(){
        //加载Spring 配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//ApplicationContext接口，获取xml文件，在获取、使用对象时创建对象
/*        BeanFactory context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//beanFactory接口，获取xml文件，在获取、使用对象时创建对象*/
        //获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.test();
    }
    @Test
    public void testSix(){
        //加载Spring 配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//ApplicationContext接口，获取xml文件，在获取、使用对象时创建对象
/*        BeanFactory context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//beanFactory接口，获取xml文件，在获取、使用对象时创建对象*/
        //获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.test();
    }
    @Test
    public void testSix_(){
        //加载Spring 配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//ApplicationContext接口，获取xml文件，在获取、使用对象时创建对象
/*        BeanFactory context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//beanFactory接口，获取xml文件，在获取、使用对象时创建对象*/
        //获取配置创建的对象
        Emp emp = context.getBean("emp_1", Emp.class);
        System.out.println(emp);
        emp.test();
    }
    @Test
    public void testSeven_eight(){
        //加载Spring 配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//ApplicationContext接口，获取xml文件，在获取、使用对象时创建对象
/*        BeanFactory context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//beanFactory接口，获取xml文件，在获取、使用对象时创建对象*/
        //获取配置创建的对象
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);
        stu.test();
    }
    @Test
    public void testNine(){
        //加载Spring 配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//ApplicationContext接口，获取xml文件，在获取、使用对象时创建对象
/*        BeanFactory context =
                new ClassPathXmlApplicationContext("bean_IOC_xml.xml");//beanFactory接口，获取xml文件，在获取、使用对象时创建对象*/
        //获取配置创建的对象
        cn.IOC_xml.nine.Book book_list = context.getBean("book_list", cn.IOC_xml.nine.Book.class);
        System.out.println(book_list);
        book_list.test();
    }
}
