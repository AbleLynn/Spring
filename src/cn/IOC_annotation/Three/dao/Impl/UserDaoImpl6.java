package cn.IOC_annotation.Three.dao.Impl;

import cn.IOC_annotation.Three.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository(value = "UserDaoImpl6")
public class UserDaoImpl6 implements UserDao {

    @Override
    public void test() {
        System.out.println("userDao 属性注入...UserDaoImpl6");
    }
}
