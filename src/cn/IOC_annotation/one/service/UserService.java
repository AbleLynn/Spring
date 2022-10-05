package cn.IOC_annotation.one.service;

import org.springframework.stereotype.Controller;

/*@Service
@Repository
@Component*/
@Controller(value = "userService_one")
//value的值等价于bean标签内的id值，然后在哪个类加的注解，就相当于bean标签内的class值；value也可以不写，默认为类的名称(首字母变小写)
public class UserService {
    public void test(){
        System.out.println("service test 对象创建...");
    }
}
