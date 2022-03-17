package com.example.springboot2.designpattern.proxy;

/**
 * Created by jowang on 2016/11/10 0010.
 */
public class MathProxy implements IMath {
    private java.lang.Math math;

    public MathProxy() throws Exception {
        math = (java.lang.Math) Class.forName("_design_mode._proxy_mode.Math").newInstance();
    }

    public double add(double x, double y) {
        return 0;
    }
}
