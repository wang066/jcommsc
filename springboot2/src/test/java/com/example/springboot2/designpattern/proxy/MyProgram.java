package com.example.springboot2.designpattern.proxy;

/**
 * Created by jowang on 2016/11/10 0010.
 */
public class MyProgram {
    public static void main(String[] args) throws Exception {
        MathProxy p=new MathProxy();
        System.out.println(p.add(1, 1));
    }
}
