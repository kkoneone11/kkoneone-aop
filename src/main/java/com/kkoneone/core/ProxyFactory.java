package com.kkoneone.core;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

/**
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/7/6 18:46
 * @Description:
 **/

@Component
public class ProxyFactory {
    // CGLIB的代理对象在执行方法调用时会应用 AopProxy 中定义的增强逻辑
    public static <T> T get(Object target , AopProxy aop) {
        // CGLIB中用于创建代理对象的类
        Enhancer enhancer = new Enhancer();
        // 设置要代理的目标类的 Class 对象。CGLIB通过继承目标类来创建代理类
        enhancer.setSuperclass(target.getClass());
        // 设置回调对象。在CGLIB中，可以通过实现 MethodInterceptor 接口来定义方法拦截逻辑
        enhancer.setCallback(aop);
        // 创建一个代理对象，并将其作为泛型类型 T 返回
        return (T) enhancer.create();
    }

    // 根据特定的条件来决定是否需要对给定的目标对象（targetObject）进行增强，并返回原始对象或增强后的代理对象
    public static Object tryBuild(Object targetObject, Object aopObject){
        //是否返回AOP代理对象

        // 设置 aopObject 中增强方法
        // 如果是以路径进行拦截，因路径最小单元为类级别，因此直接将整个类中的方法进行增强
        return null;
    }

}
