package cn.JdbcTemplateDemo_1.dao.Impl;

import cn.JdbcTemplateDemo_1.dao.UserDao;
import cn.JdbcTemplateDemo_1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    //注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加操作
    @Override
    public void add(User user) {
        String sql = "insert into t_user values(?,?,?)";
        int update = jdbcTemplate.update(sql, user.getUserId(), user.getUserName(), user.getuStatus());
        System.out.println(update);
    }

    //修改操作
    @Override
    public void update(User user) {
        String sql = "update t_user set username = ? , ustatus = ? where user_id = ?";
        int update = jdbcTemplate.update(sql, user.getUserName(), user.getuStatus(), user.getUserId());
        System.out.println(update);
    }

    //删除操作
    @Override
    public void delete(String id) {
        String sql = "delete from t_user where user_id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    //查询总记录数
    @Override
    public int selectCount() {
        String sql = "select count(*) from t_user";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    //查询返回单挑user对象
    @Override
    public User findUserById(String userId) {
        String sql = "select * from t_user where user_id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userId);
        return user;
    }
    //查询所有记录
    @Override
    public List<User> findALL() {
        String sql = "select * from t_user";
        List<User> user = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return user;
    }
    //批量添加
    @Override
    public void addBatch(List<Object[]> batchArgs) {
        String sql = "insert into t_user values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
    //批量修改
    @Override
    public void updateBatch(List<Object[]> batchArgs) {
        String sql = "update t_user set username = ? , ustatus = ? where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
    //批量删除
    @Override
    public void deleteBatch(List<Object[]> batchArgs) {
        String sql = "delete from t_user where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
