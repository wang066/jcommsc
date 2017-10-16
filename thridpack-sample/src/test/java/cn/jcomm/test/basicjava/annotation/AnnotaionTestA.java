package cn.jcomm.test.basicjava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jowang on 2016/10/31 0031.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PACKAGE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.TYPE})
public @interface AnnotaionTestA {
    String name();

    int id() default 0;

    Class<Long> gid();


}
