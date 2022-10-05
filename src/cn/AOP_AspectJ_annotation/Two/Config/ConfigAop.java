package cn.AOP_AspectJ_annotation.Two.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"cn.AOP_xml"})
@EnableAspectJAutoProxy(proxyTargetClass = true)//开启aspect生成代理对象
public class ConfigAop {
    
}
