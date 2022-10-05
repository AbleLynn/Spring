package cn.IOC_annotation.two.dao.Impl;

import cn.IOC_annotation.two.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository(value = "UserDaoImpl3")
public class UserDaoImpl3 implements UserDao {

    @Override
    public void test() {
        System.out.println("userDao 属性注入...UserDaoImpl3");
    }
}
