package com.kkoneone.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/6/7 17:04
 * @Description:
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Aop {

    //基于路径aop
    String jointPath() default "";

    //基于注解aop
    Class<? extends Annotation> jointAnnotationClass() default Void.class;

}
