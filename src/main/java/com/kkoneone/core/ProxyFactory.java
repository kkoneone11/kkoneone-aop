package com.kkoneone.core;

import org.springframework.stereotype.Component;

/**
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/7/6 18:46
 * @Description:
 **/

@Component
public class ProxyFactory {
    public static <T> T get(Object target , AopProxy aop) {
        return null;
    }

    public static Object tryBuild(Object targetObject, Object aopObject){
        return null;
    }
}
