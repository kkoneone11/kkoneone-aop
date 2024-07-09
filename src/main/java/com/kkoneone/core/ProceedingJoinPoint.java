package com.kkoneone.core;

import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/7/9 19:46
 * @Description:
 **/
public class ProceedingJoinPoint extends JoinPoint{
    private final Object targetObject;
    private final MethodProxy methodProxy;

    public ProceedingJoinPoint(Method method, Object[] args , Object targetObject , MethodProxy methodProxy) {
        super(method, args);
        this.targetObject = targetObject;
        this.methodProxy = methodProxy;
    }


    @Override
    public Object invoke() throws Throwable {
        return methodProxy.invoke(targetObject , getArgs());
    }

    @Override
    public Object invoke(Object[] args) throws Throwable {
        return methodProxy.invoke(targetObject , args);
    }


}
