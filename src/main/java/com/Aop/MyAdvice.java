package com.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component//告知是Spring组件
@Aspect//MyAdvice是切面类
public class MyAdvice {
    @Pointcut("execution(void com.Dao.BookDao.update())")//接口里面的update方法
    //@Pointcut("execution(void com.Dao.imp.BookDaoImp.update())")//实现类里面的update方法
    private void update(){}


    @Pointcut("execution(void com.Dao.BookDao.select())")//接口里面的update方法
    //@Pointcut("execution(void com.Dao.imp.BookDaoImp.update())")//实现类里面的update方法
    private void select(){}


    //前置通知
    @Before("update()")
    public void CommonMethodBefore(){
        System.out.println("前置通知：AOP公共update方法.....");
    }
    //后置通知
    @After("update()")
    public void CommonMethodAfter(){
        System.out.println("后置通知：AOP公共update方法.....");
    }

    //环绕通知
    @Around("update()")
    public void CommonMethodRound(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知1：AOP公共update方法.....");
        pjp.proceed();
        System.out.println("环绕通知2：AOP公共update方法.....");
    }





    @Before("select()")
    public void CommonMethod2(){
        long start = System.currentTimeMillis();
        //万次执行效率。看时间
        for (int i = 0; i < 100; i++) {
            System.out.println("AOP公共select方法.....");
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("共消耗 "+time+" ms");
    }

}
