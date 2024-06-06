package com.kkoneone.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/6/6 19:16
 * @Description:
 **/

//什么类型上可以使用这个注解
@Target(ElementType.METHOD)
//什么时候可以获取这个反射
@Retention(RetentionPolicy.RUNTIME)
public @interface Throwing {
}
