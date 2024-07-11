package com.kkoneone.core;

import com.kkoneone.annotation.After;
import com.kkoneone.annotation.Around;
import com.kkoneone.annotation.Before;
import com.kkoneone.annotation.Throwing;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 封装可执行的目标方法数据
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
    Object aopObject;
    // 是否存在全局拦截器
    boolean isInterceptorAll = false;
    // 需要拦截的方法
    Map<Integer,Method> interceptorMethods = new HashMap<>();


    // 检查aopObject中加强方法并进行对应存储
    public void  setEnhancermethods(Object aopObject){
        Method[]  methods = aopObject.getClass().getDeclaredMethods();
        for(Method method : methods){
            if (method.isAnnotationPresent(Before.class)) {
                beforeMethod = method;
            }else if (method.isAnnotationPresent(After.class)){
                afterMethod = method;
            }else if (method.isAnnotationPresent(Around.class)) {
                aroundMethod = method;
            }else if (method.isAnnotationPresent(Throwing.class)){
                throwingMethod = method;
            }
        }


    }

    public AopProxy(){}

    /**
     *
     * 拦截器方法，通常用于在方法执行前后添加额外的行为
     * @param o 被调用方法的目标对象
     * @param method 被拦截的方法的 Method 对象
     * @param objects 方法参数数组
     * @param methodProxy 原始方法的代理对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 方法哈希码
        final int hashcode = method.hashCode();
        // 前后置拦截器入参分别为 JoinPoint
        // 环绕为 ProceedingJoinPoint 因为环绕有 invoke 行为 是否存在全局拦截器或是否有针对当前方法的特定拦截器
        // 是否存在全局拦截器或是否有针对当前方法的特定拦截器（通过哈希码查找）
        if(isInterceptorAll || interceptorMethods.containsKey(hashcode)){
            // 拦截对象的加强顺序 前 -> 环绕 -> 后 -> 异常
            Object ret = null;
            try {
                //前置方法加强

            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        }
        return null;
    }

    private Object invokeMethod(Object jointObject , Method method) {
        return null;
    }



}
