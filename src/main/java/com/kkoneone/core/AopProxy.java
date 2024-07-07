package com.kkoneone.core;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/7/6 22:23
 * @Description:
 **/

//自定义Aop代理接口 用于增强逻辑
public class AopProxy implements MethodInterceptor {
    // 对应注解的拦截方法
    Method beforeMethod;
    Method afterMethod;
    Method throwingMethod;
    Method aroundMethod;

    public AopProxy(){}

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }



}
