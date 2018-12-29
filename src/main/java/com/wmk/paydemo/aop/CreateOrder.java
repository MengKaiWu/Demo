package com.wmk.paydemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class CreateOrder {

    /*@Pointcut("execution(* com.wmk.paydemo.service.impl.AlipayServiceImpl.payByPC(..))")
    public void mycut() {
    }

    @Around("mycut()")
    public Object around(ProceedingJoinPoint pjp){
        //获得参数对象message
        Object[] obj=pjp.getArgs();
        for (Object o : obj) {

        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        //获得方法的签名
        MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
        System.out.println(methodSignature);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        //获得方法名
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        //操作结果
        Object obj1 = "";
        try {
            obj1 = pjp.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return obj1;
    }*/
}
