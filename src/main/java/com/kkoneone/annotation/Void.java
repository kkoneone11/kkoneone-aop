package com.kkoneone.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/6/14 16:18
 * @Description:
 **/


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Void {
}
