package cn.IOC_xml.five_six;

//员工类
public class Emp {
    private String eName;
    private String eGender;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void seteGender(String eGender) {
        this.eGender = eGender;
    }

    public void test() {
        System.out.println(eName + ":" + eGender + ":" + dept);
    }
}
