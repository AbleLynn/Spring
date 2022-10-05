package cn.JdbcTemplateDemo_1.service;

import cn.JdbcTemplateDemo_1.dao.UserDao;
import cn.JdbcTemplateDemo_1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //注入dao
    @Autowired
    private UserDao userDao;
    //添加的方法
    public void addUser(User user){
        userDao.add(user);
    }
    //修改方法
    public void updateUser(User user){
        userDao.update(user);
    }
    //删除方法
    public void deleteUser(String id){
        userDao.delete(id);
    }
    //查询总记录数
    public int selectUserCount(){
        return userDao.selectCount();
    }
    //查询返回单挑记录
    public User findUserById(String uid){
        return userDao.findUserById(uid);
    }
    //查询表中所有记录
    public List<User> findALL(){
        return userDao.findALL();
    }
    //批量添加
    public void addBatch(List<Object[]> batchArgs){
        userDao.addBatch(batchArgs);
    }
    //批量修改
    public void updateBatch(List<Object[]> batchArgs){
        userDao.updateBatch(batchArgs);
    }
    //批量删除
    public void deleteBatch(List<Object[]> batchArgs){
        userDao.deleteBatch(batchArgs);
    }
}
