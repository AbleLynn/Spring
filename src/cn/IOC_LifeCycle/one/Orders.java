package cn.IOC_LifeCycle.one;

public class Orders {
    private String oName;

    public Orders() {
        System.out.println("第一步，执行无参构造创建bean实例");
    }

    public void setoName(String oName) {
        this.oName = oName;
        System.out.println("第二步，调用set方法设置属性值");
    }
    //创建执行的初始化方法
    public void initMethod(){
        System.out.println("第四步，执行初始化方法");
    }
    //创建执行的销毁方法
    public void destoryMethod(){
        System.out.println("第七步，执行销毁方法");
    }
}
