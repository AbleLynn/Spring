package cn.IOC_annotation.Three.dao.Impl;

import cn.IOC_annotation.Three.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository(value = "UserDaoImpl5")
public class UserDaoImpl5 implements UserDao {

    @Override
    public void test() {
        System.out.println("userDao 属性注入...UserDaoImpl5");
    }
}
