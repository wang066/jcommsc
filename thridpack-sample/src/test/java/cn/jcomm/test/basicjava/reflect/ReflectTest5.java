package cn.jcomm.test.basicjava.reflect;

import junit.framework.TestCase;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by jowang on 2017/1/3 0003.
 */
public class ReflectTest5 extends TestCase {

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




    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{
        Object o = newInstance(TwoString.class.getName(), new Object[]{"1", "2"});
        System.out.println(o.toString());
    }


    /**
     * 不能使用方法内部类
     *
     * @param classname
     * @param args
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public Object newInstance(String classname,Object[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        new Date();
        Date date=Date.class.newInstance();
        Constructor c2=Date.class.getConstructor(int.class,int.class,int.class);
        Date o = (Date) c2.newInstance(2000,10,10);
        System.out.println(o);
        Class newoneclass=Class.forName(classname);
        Class[] argClass=new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argClass[i]=args[i].getClass();
        }
        Constructor c=newoneclass.getConstructor(String.class,String.class);
        return  c.newInstance(args);
    }

//    public void test3(){
//        printmany("1","2","3");
//    }
//
//    void printmany(String... vargs){
//        for (String varg : vargs) {
//            System.out.println(varg);
//        }
//    }
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