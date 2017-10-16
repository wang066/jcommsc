package cn.jcomm.test.basicjava.reflect;

import junit.framework.TestCase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by jowang on 2017/1/3 0003.
 */
public class ReflectTest4 extends TestCase {

    class Person {
        int age;
        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Employee extends Person {
        int workyear;

        public int getWorkyear() {
            return workyear;
        }

        public void setWorkyear(int workyear) {
            this.workyear = workyear;
        }
    }

    class TwoString {
        private String m_s1="", m_s2="";

        public TwoString() {
        }


        public TwoString(String s1, String s2) {
            m_s1 = s1;
            m_s2 = s2;
        }

        @Override
        public String toString() {
            return "TwoString{" +
                    "m_s1='" + m_s1 + '\'' +
                    ", m_s2='" + m_s2 + '\'' +
                    '}';
        }
    }

    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c1=Employee.class;
        Field[] declaredFields = c1.getDeclaredFields();
        Field[] fields = c1.getFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());;
        }



        Class c2 = TwoString.class;
        Object o1 =  c2.newInstance();
        System.out.println(o1.toString());
        Class[] types = new Class[]{String.class, String.class};
//        Constructor constructor = c2.getConstructor(String.class, String.class);
        Constructor constructor = TwoString.class.getDeclaredConstructor(types);
//        TwoString o = (TwoString) constructor.newInstance("1", "2");
        Object[] args=new Object[]{"1","2"};
        TwoString o = (TwoString) constructor.newInstance(args);
        System.out.println(o.toString());

//        Class c1=Short.TYPE;


    }

    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{

    }

}
