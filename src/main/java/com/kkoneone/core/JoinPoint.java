package com.kkoneone.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 封装目标方法的形参以及目标方法
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/7/7 21:47
 * @Description:
 **/
public class JoinPoint implements IJoinPoint{

    protected final Object[] args;
    private Method method;

    public JoinPoint(Method method,Object[] args) {
        this.method = method;
        this.args = args;
    }

    @Override
    public Object[] getArgs() {
        return new Object[0];
    }

    @Override
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        return null;
    }
}
