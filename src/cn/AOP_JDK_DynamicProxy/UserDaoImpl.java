package cn.AOP_JDK_DynamicProxy;

public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行...");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update方法执行...");
        return id;
    }
}
