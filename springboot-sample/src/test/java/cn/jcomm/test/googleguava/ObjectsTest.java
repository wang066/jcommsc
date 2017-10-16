package cn.jcomm.test.googleguava;

import com.google.common.base.MoreObjects;

/**
 * Created by jowang on 2017/4/24 0024.
 */
public class ObjectsTest {
    public static void main(String[] args) {
//        com.google.common..(this).add("x", 1).toString();
        System.out.println(MoreObjects.toStringHelper("MyObject").add("x", 1).toString());


    }
}
