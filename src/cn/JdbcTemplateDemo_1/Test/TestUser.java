package cn.JdbcTemplateDemo_1.Test;

import cn.JdbcTemplateDemo_1.domain.User;
import cn.JdbcTemplateDemo_1.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestUser {
    @Test
    public void add() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_JdbcTemplate_1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setUserId("1");
        user.setUserName("张三");
        user.setuStatus("yes");
        userService.addUser(user);
    }

    @Test
    public void update() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_JdbcTemplate_1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setUserId("1");
        user.setUserName("李四");
        user.setuStatus("yes");
        userService.updateUser(user);
    }

    @Test
    public void delete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_JdbcTemplate_1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.deleteUser("1");
    }

    @Test
    public void findCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_JdbcTemplate_1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        int count = userService.selectUserCount();
        System.out.println(count);
    }

    @Test
    public void findUserById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_JdbcTemplate_1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = userService.findUserById("1");
        System.out.println(user.getUserId() + ":" + user.getUserName() + ":" + user.getuStatus());
    }
    @Test
    public void findAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_JdbcTemplate_1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<User> allUser = userService.findALL();
        for (User user : allUser){
            System.out.println(user.getUserId() + ":" + user.getUserName() + ":" + user.getuStatus());
        }
    }
    @Test
    public void addBatch() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_JdbcTemplate_1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user1 = new User();
        user1.setUserId("4");
        user1.setUserName("李白");
        user1.setuStatus("yes");
        User user2 = new User();
        user2.setUserId("5");
        user2.setUserName("后裔");
        user2.setuStatus("yes");
        User user3 = new User();
        user3.setUserId("6");
        user3.setUserName("孙悟空");
        user3.setuStatus("yes");
        List<Object[]> list = new ArrayList<>();
        Object[] o1 = {user1.getUserId(),user1.getUserName(),user1.getuStatus()};
        Object[] o2 = {user2.getUserId(),user2.getUserName(),user2.getuStatus()};
        Object[] o3 = {user3.getUserId(),user3.getUserName(),user3.getuStatus()};
        list.add(o1);
        list.add(o2);
        list.add(o3);
        userService.addBatch(list);
    }
    @Test
    public void updateBatch() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_JdbcTemplate_1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user1 = new User();
        user1.setUserId("4");
        user1.setUserName("苏轼");
        user1.setuStatus("yes");
        User user2 = new User();
        user2.setUserId("5");
        user2.setUserName("女娲");
        user2.setuStatus("yes");
        User user3 = new User();
        user3.setUserId("6");
        user3.setUserName("猪八戒");
        user3.setuStatus("yes");
        List<Object[]> list = new ArrayList<>();
        Object[] o1 = {user1.getUserName(),user1.getuStatus(),user1.getUserId()};
        Object[] o2 = {user2.getUserName(),user2.getuStatus(),user2.getUserId()};
        Object[] o3 = {user3.getUserName(),user3.getuStatus(),user3.getUserId()};
        list.add(o1);
        list.add(o2);
        list.add(o3);
        userService.updateBatch(list);
    }
    @Test
    public void deleteBatch() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_JdbcTemplate_1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user1 = new User();
        user1.setUserId("4");
        User user2 = new User();
        user2.setUserId("5");
        User user3 = new User();
        user3.setUserId("6");
        List<Object[]> list = new ArrayList<>();
        Object[] o1 = {user1.getUserId()};
        Object[] o2 = {user2.getUserId()};
        Object[] o3 = {user3.getUserId()};
        list.add(o1);
        list.add(o2);
        list.add(o3);
        userService.deleteBatch(list);
    }
}

