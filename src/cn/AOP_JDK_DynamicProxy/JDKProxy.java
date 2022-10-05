package cn.AOP_JDK_DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        /*Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });//方式1 直接使用匿名内部类的方法*/
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));//方式2, 使用外部类继承InvocationHandler接口 并重写invoke增强逻辑
        int result = dao.add(1, 2);
        System.out.println("result:" + result);
    }
}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler {
    //创建具体的接口实现类的代理对象，就把具体的接口实现类传递过来
    //通过有参构造进行传递
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }


    //增强逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*
            porxy：代理对象
            method：需要增强的方法
            args：当前参数
         */
        //在被增强的方法之前处理，即在增强方法之前修改
        System.out.println("在方法之前执行..." + method.getName() + ":传递的参数" + args.toString());
        //被增强的方法执行
        Object res = method.invoke(obj, args);
        //在被增强的方法之后处理，即在增强方法之后修改
        System.out.println("在方法之后执行..." + obj);
        return res;
    }
}