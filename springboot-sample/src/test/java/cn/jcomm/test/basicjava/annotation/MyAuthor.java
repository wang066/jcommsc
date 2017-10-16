package cn.jcomm.test.basicjava.annotation;

/**
 * Created by jowang on 2016/10/31 0031.
 */
public @interface MyAuthor {
    String[] value() default {"test1","test2"};
}

