package cn.JdbcTemplateDemo_2.Test;

import cn.JdbcTemplateDemo_2.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {
    @Test
    public void testAccount() {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean_JdbcTemplate_2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
