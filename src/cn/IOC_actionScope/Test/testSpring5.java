package cn.IOC_actionScope.Test;

import cn.IOC_actionScope.one.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring5 {
    @Test
    public void testOne(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_IOC_actionScope.xml");
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        System.out.println(book1);
        System.out.println(book2);
        //输出地址相同，所以默认情况下，bean为单实例对象
    }
    @Test
    public void testOne_(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_IOC_actionScope.xml");
        Book book1 = context.getBean("book_", Book.class);
        Book book2 = context.getBean("book_", Book.class);
        System.out.println(book1);
        System.out.println(book2);
        //输出地址不同，设置scope为prototype时，bean为多实例对象
    }
}
