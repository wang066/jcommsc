package cn.jcomm.test.basicjava.annotation;

import java.lang.annotation.*;

/**
 * Created by jowang on 2016/10/31 0031.
 * http://www.cnblogs.com/hanxirensheng/articles/2398254.html
 */

@Retention(value = RetentionPolicy.RUNTIME)//只有当声明为RUNTIME的时候，才能够在运行时刻通过反射API来获取到注解的信息
@Target(value = {ElementType.METHOD})//声明注解可以添加在哪里
@Documented()
@Inherited()//可以被继承的
public @interface Assignment {
    String assignee();
    int effort();
    double finsh() default 0;
}

