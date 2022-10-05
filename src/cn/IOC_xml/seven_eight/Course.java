package cn.IOC_xml.seven_eight;
//课程类
public class Course {
    private String cName;//课程名称

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cName='" + cName + '\'' +
                '}';
    }
}
