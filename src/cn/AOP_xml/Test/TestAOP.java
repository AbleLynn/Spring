package cn.AOP_xml.Test;

import cn.AOP_xml.One.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
    @Test
    public void testXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_AOP_xml.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
