package cn.AOP_AspectJ_annotation;

import org.springframework.stereotype.Component;

/*
    被增强类
 */
@Component
public class User {
    public void add() {
//        int i = 3/ 0;
        System.out.println("add...");
    }
}


