package cn.IOC_xml.seven_eight;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    //数组类型属性
    private String[] sources;

    //List类型属性
    private List<String> list;

    //Map类型属性
    private Map<String, String> map;

    //set类型属性
    private Set<String> set;

    //学生所学多门课程
    private List<Course> courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setSources(String[] sources) {
        this.sources = sources;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void test() {
        System.out.println(Arrays.toString(sources));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(courseList.toString());
    }
}
