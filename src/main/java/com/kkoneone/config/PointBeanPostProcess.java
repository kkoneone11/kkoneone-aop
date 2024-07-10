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

    // 拦截标注了注解的类，通过反射搜索bean上有没有带有@Aop注解的，并且看看是路径还是注解放到对应的map中
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //获取对应bean类
        Class<?> beanClass = bean.getClass();
        //从beanClass获取标有Aop类型的注解
        Aop aop = beanClass.getAnnotation(Aop.class);
        if(aop != null){
            String jointPath = aop.jointPath();
            // 路径不为空
            if(!jointPath.equals("")){
                jointPointPathMap.put(jointPath , bean);
            }else {
                jointPointAnnotationMap.put(aop.jointAnnotationClass() , bean);
            }
        }
        return bean;
    }

    // 如果Bean的类名匹配了特定的路径，或者Bean具有特定的注解，它将被包装在一个代理对象中，以便在调用Bean的方法前后执行额外的操作
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        final Class<?> beanClass = bean.getClass();
        final String path = beanClass.getName();

        //看类名是否匹配对应路径
        for(String s : jointPointPathMap.keySet()) {
            // 和对应的key是相同的则为该bean进行代理
            if(path.startsWith(s)){

            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
