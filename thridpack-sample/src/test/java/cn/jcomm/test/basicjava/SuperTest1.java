package cn.jcomm.test.basicjava;

/**
 * Created by 066 on 2017/1/10 0010.
 */
public class SuperTest1 {

    static class Person {

        public static void prt(String s) {
            System.out.println(s);
        }

        Person() {
            prt("A Person.");
        }

        Person(String name) {
            prt("A person name is:" + name);

        }
    }

    static class Chinese extends Person{
        public Chinese(){
            super();
            prt("a chinese");
        }


    }

}
