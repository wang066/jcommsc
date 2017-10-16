package cn.jcomm.test.basicjava.reflect;

import junit.framework.TestCase;

import java.lang.reflect.Modifier;
import java.util.Date;

/**
 * Created by jowang on 2017/1/3 0003.
 */
public class ReflectTest extends TestCase {
    class Employee {
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

    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        System.out.println(Employee.class.getName());
//        Employee e = new Employee();
//        System.out.println(e.getClass().getName());

//        String classname = "java.util.Date";
//        Class<?> DateClass = Class.forName(classname);
//        System.out.println(DateClass.getName());
//        Date dt= (Date) DateClass.newInstance();
//        System.out.println(dt);

        Class c1= Date.class;
        Class c2=int.class;
        Class c3=double[].class;
        Class c4=Double[].class;
        Class c5=double[].class;
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());
        System.out.println(c4.getName());
        System.out.println(c3==c4);
        System.out.println(c1==new Date().getClass());


        System.out.println("---------------------------");


//        for (Field field : c1.getDeclaredFields()) {
//            System.out.println(field.getName());
//        }
//        System.out.println("---------------------------");
//        for (Constructor constructor : c1.getDeclaredConstructors()) {
//            System.out.println(constructor.getName());
//        }
//        System.out.println("---------------------------");
//        for (Method method : c1.getDeclaredMethods()) {
//            System.out.println(method.getName());
//            System.out.println(method.getModifiers());
//
//        }

        System.out.println(Modifier.isAbstract(1));
        System.out.println(Modifier.toString(1));
    }
}
