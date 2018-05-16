package cn.jcomm.test.concurrency.b.b4;

/**
 * Created by 066 on 2017/6/28 0028.
 */
public class _Test7 {


    public static void main(String[] args) {
        new A().hello();
    }

}

class B {

    {
        System.out.println("static b");
    }

    B() {
        System.out.println("init b");
    }

    void hello() {
        System.out.println("hello b");
    }
}

class A extends B {

    {
        System.out.println("static a");
    }

    A() {
        System.out.println("init a");
    }

    void hello() {
        System.out.println("hello a");
    }
}