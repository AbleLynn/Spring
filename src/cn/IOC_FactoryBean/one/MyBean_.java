package cn.IOC_FactoryBean.one;

import org.springframework.beans.factory.FactoryBean;

public class MyBean_ implements FactoryBean<Course> {

    /**
     * 定义返回bean类型
     *
     * @return
     * @throws Exception
     */
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setcName("FactoryBean中定义course");
        return course;
    }

    /**
     * 返回类型，返回对象类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    /**
     * 是否为单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
    public void test(){
        System.out.println("FactoryBean类型");
    }
}
