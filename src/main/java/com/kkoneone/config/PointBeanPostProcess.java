package com.kkoneone.config;

import com.kkoneone.annotation.Aop;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : huangzhengyi.hzy@alibaba-inc.com
 * @Date : 2024/6/14 16:58
 * @Description: 执行Aop启动后的具体逻辑
 **/

@Component
public class PointBeanPostProcess implements BeanPostProcessor {

    //根据注解路径缓存bean
    Map<Class , Object> jointPointAnnotationMap;
    //根据全类名路径缓存bean
    Map<String, Object> jointPointPathMap;

    //初始化
    public PointBeanPostProcess(){
        this.jointPointAnnotationMap = new HashMap<>();
        this.jointPointPathMap = new HashMap<>();
    }

    //通过反射搜索bean上有没有带有@Aop注解的，并且看看是路径还是注解放到对应的map中
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //获取对应bean类
        Class<?> beanClass = bean.getClass();
        //从beanClass获取标有Aop类型的注解
        Aop aop = beanClass.getAnnotation(Aop.class);
        if(aop != null){
            String jointPath = aop.jointPath();
            if(!jointPath.equals("")){
                jointPointPathMap.put(jointPath , bean);
            }else {
                jointPointAnnotationMap.put(aop.jointAnnotationClass() , bean);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
