package cn.JdbcTemplateDemo_1.dao;

import cn.JdbcTemplateDemo_1.domain.User;

import java.util.List;

public interface UserDao {
    //添加方法
    public void add(User user);
    //修改方法
    void update(User user);
    //删除方法
    void delete(String id);
    //查询记录数
    int selectCount();
    //查询单条记录
    User findUserById(String userId);
    //查询所有记录
    List<User> findALL();
    //批量添加
    void addBatch(List<Object[]> batchArgs);
    //批量修改
    void updateBatch(List<Object[]> batchArgs);
    //批量删除
    void deleteBatch(List<Object[]> batchArgs);
}
