package cn.jcomm.test.designpattern.adapter;

/**
 * Created by jowang on 2016/11/10 0010.
 */
public class MyProgram {
    public static void main(String[] args) {
        Target t=new Adapter(new Adaptee());
        t.reqeust();
    }
}
