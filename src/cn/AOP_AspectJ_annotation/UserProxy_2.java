package cn.AOP_AspectJ_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class UserProxy_2 {
    //相同切入点抽取
    @Pointcut(value = "execution(* cn.AOP_AspectJ_annotation.User.add(..))")
    public void pointdemo(){}


    /*
        前置通知
        Before:表示前置通知
     */
//    @Before(value = "execution(* cn.AOP_AspectJ_annotation.User.add(..))")
    @Before(value = "pointdemo()")
    public void before() {
        System.out.println("before2...");
    }

    /*
       最终通知,不管有没有异常都执行
     */
//    @After(value = "execution(* cn.AOP_AspectJ_annotation.User.add(..))")
    @After(value = "pointdemo()")
    public void after() {
        System.out.println("after2...");
    }

    /*
       后置通知
     */
//    @AfterReturning(value = "execution(* cn.AOP_AspectJ_annotation.User.add(..))")
    @AfterReturning(value = "pointdemo()")
    public void afterReturning() {
        System.out.println("afterReturning2...");
    }

    /*
        异常通知
     */
//    @AfterThrowing(value = "execution(* cn.AOP_AspectJ_annotation.User.add(..))")
    @AfterThrowing(value = "pointdemo()")
    public void afterThrowing() {
        System.out.println("afterThrowing2...");
    }

    /*
        环绕通知
     */
//    @Around(value = "execution(* cn.AOP_AspectJ_annotation.User.add(..))")
    @Around(value = "pointdemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前2...");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后2...");
    }

}
