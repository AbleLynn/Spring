package cn.AOP_AspectJ_annotation.Test;

import cn.AOP_AspectJ_annotation.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
    @Test
    public void testAopAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_AOP_AspectJAnnotation.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
