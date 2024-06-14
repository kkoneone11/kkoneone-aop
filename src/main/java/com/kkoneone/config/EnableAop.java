package com.kkoneone.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/6/14 16:57
 * @Description:
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(PointBeanPostProcess.class) //表示使用这个注解会自动启用PointBeanPostProcess
public @interface EnableAop {

}
