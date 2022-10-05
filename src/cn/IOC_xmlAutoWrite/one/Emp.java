package cn.IOC_xmlAutoWrite.one;

import cn.IOC_xmlAutoWrite.one.Dept;

public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
    public void test(){
        System.out.println(dept);
    }
}
