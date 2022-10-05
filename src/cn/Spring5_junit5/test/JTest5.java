package cn.Spring5_junit5.test;

import cn.Spring5_junit5.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:bean_Spring5_Junit5.xml")*/
@SpringJUnitConfig(locations = "classpath:bean_Spring5_Junit5.xml")//简化上面两个注解
public class JTest5 {
    @Autowired
    private UserService userService;
    @Test
    public void test(){
        userService.accountMoney();
    }
}
