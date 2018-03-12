package cn.jcomm.test.designpattern;

/**
 * Created by jowang on 2016/11/21 0021.
 */
public class SingletonTest {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().i);

    }
}

class Singleton {
    private static Singleton instance;

    public int i;

    private Singleton(int i) {
        this.i=i;
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(1);
        }
        return instance;
    }
}