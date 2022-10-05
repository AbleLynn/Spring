package cn.Spring5_junit4.test;

import cn.Spring5_junit4.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//指定单元测试的框架
@ContextConfiguration("classpath:bean_Spring5_Junit4.xml")//加载配置文件---相当于创建context对象和context.getbean方法的整合
public class JTest4 {
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        userService.accountMoney();
    }
}
