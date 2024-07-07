package com.kkoneone.core;

import java.lang.annotation.Annotation;

/**
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/7/7 19:15
 * @Description:
 **/
public interface IJoinPoint {

    Object[] getArgs();

    <T extends Annotation> T getAnnotation(Class<T> annotationClass);
    // 调用连接点Joint的方法
    default Object invoke() throws Throwable {
        return null;
    }

    default  Object invoke(Object[] args) throws Throwable {
        return null;
    }
}
