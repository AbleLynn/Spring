package cn.IOC_xml.four.service;

import cn.IOC_xml.four.dao.UserDao;

public class UserService {

    //创建userDao类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void test() {
        System.out.println("UserService add...");
        /*//原始方式：创建userDao对象
        UserDao userDao = new UserDaoImpl();
        userDao.update();*/
        userDao.update();
    }
}
