package com.example.springboot2.designpattern;

/**
 * @author: jowang
 * @date: 2018-07-24 18:40
 * @description: 状态模式
 */
public class StatePattern {
    public static void main(String[] args) {
        Switch s1,s2;
        s1=new Switch("开关1");
        s2=new Switch("开关2");

        s1.on();
        s2.on();
        s1.off();
        s2.off();
        s2.on();
        s1.on();
    }
}

class Switch {
    private static State state,onState,offState; //定义三个静态的状态对象
    private String name;

    public Switch(String name) {
        this.name = name;
        onState = new OnState();
        offState = new OffState();
        this.state = onState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static State getState(String type) {
        if (type.equalsIgnoreCase("on")) {
            return onState;
        }
        else {
            return offState;
        }
    }

    //打开开关
    public void on() {
        System.out.print(name);
        state.on(this);
    }

    //关闭开关
    public void off() {
        System.out.print(name);
        state.off(this);
    }
}

abstract class State {
    public abstract void on(Switch s);
    public abstract void off(Switch s);
}

//打开状态
class OnState extends State {
    public void on(Switch s) {
        System.out.println("已经打开！");
    }

    public void off(Switch s) {
        System.out.println("关闭！");
        s.setState(Switch.getState("off"));
    }
}

//关闭状态
class OffState extends State {
    public void on(Switch s) {
        System.out.println("打开！");
        s.setState(Switch.getState("on"));
    }

    public void off(Switch s) {
        System.out.println("已经关闭！");
    }
}
