package cn.IOC_xml.three;

/**
 * 使用有参构造方法注入属性
 */
public class Orders {
    //创建属性
    private String oName;
    private String oAddress;

    //创建属性对应的有参构造方法
    public Orders(String oName, String oAddress) {
        this.oName = oName;
        this.oAddress = oAddress;
    }

    public void test() {
        System.out.println(oName + ":" + oAddress);
    }
}
