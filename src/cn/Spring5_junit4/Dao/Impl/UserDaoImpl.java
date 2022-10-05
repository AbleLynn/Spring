package cn.Spring5_junit4.Dao.Impl;


import cn.Spring5_junit4.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //多钱
    @Override
    public void addMoney() {
        String sql = "update t_account set money = money - ? where username = ?";
        jdbcTemplate.update(sql, 100, "Lucy");
    }

    //少钱
    @Override
    public void reduceMoney() {
        String sql = "update t_account set money = money + ? where username = ?";
        jdbcTemplate.update(sql, 100, "Mary");
    }
}
