package cn.IOC_annotation.Three.service;

import cn.IOC_annotation.Three.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService_three")
//value的值等价于bean标签内的id值，然后在哪个类加的注解，就相当于bean标签内的class值；value也可以不写，默认为类的名称(首字母变小写)
public class UserService {

    //普通类型属性注解，value值即为普通类型属性设置的值
    @Value(value = "abc")
    private String name;
    public void testName(){
        System.out.println(this.name);
    }


    //定义dao类型属性
    @Autowired//如果一个接口有多个实现类，则不能只使用Autowired，需要Qualifier指定名称
    @Qualifier(value = "UserDaoImpl4")
    private UserDao userDao1;
    public void test1(){
        System.out.println("service test...");
        userDao1.test();
    }
    @Autowired
    @Qualifier(value = "UserDaoImpl5")
    private UserDao userDao2;
    public void test2(){
        System.out.println("service test...");
        userDao2.test();
    }
    //@Resource//如果一个接口有多个实现类，则不能只使用Resource，需要Qualifier指定名称或者在Resource内设置具体的name值
    @Resource(name = "UserDaoImpl6")
    private UserDao userDao3;
    public void test3(){
        System.out.println("service test...");
        userDao3.test();
    }

}
