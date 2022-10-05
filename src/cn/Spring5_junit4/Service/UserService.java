package cn.Spring5_junit4.Service;

import cn.Spring5_junit4.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(timeout = -1, readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
public class UserService {
    @Autowired
    private UserDao userDao;

    //@Transactional
//    @Transactional
    public void accountMoney() {
        //开启事务
        //业务操作
        //lucy少100
        userDao.reduceMoney();
        //模拟异常
//        int i = 10 / 0;
        //mary多100
        userDao.addMoney();
        //如果没有异常，则提交事务
    }
}
