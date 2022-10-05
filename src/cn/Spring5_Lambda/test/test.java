package cn.Spring5_Lambda.test;

import cn.Spring5_Lambda.User;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

public class test {
    //lambda函数式风格创建对象，交给spring管理
    @Test
    public void testGenericApplicationContext() {
        //创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //调用context的方法对象注册
        context.refresh();
//        context.registerBean(User.class, () -> new User());//不设置bean的id
        context.registerBean("user",User.class, () -> new User());//设置bean的id
        //获取在Spring注册的对象
//        User user = (User) context.getBean("cn.Spring5_Lambda.User");//不设置bean的id时获取
        User user = (User) context.getBean("user");//设置bean的id时获取
        System.out.println(user);
    }
}
