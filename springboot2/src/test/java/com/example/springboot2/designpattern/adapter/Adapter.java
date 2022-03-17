package com.example.springboot2.designpattern.adapter;

/**
 * Created by jowang on 2016/11/10 0010.
 */
public class Adapter implements Target {
    private Adaptee adaptee;//=new adaptee()

    public Adapter(Adaptee adaptee) {
        super();
        this.adaptee = adaptee;
    }

    public void reqeust() {
        adaptee.specificRequest();
    }
}
