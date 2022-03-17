package com.example.springboot2.designpattern.singleton;

public class Singleton {
    private Singleton(){

    }
    private static class SingletonHolder{
        private final static Singleton instance=new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }
}