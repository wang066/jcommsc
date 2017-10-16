package cn.jcomm.test.basicjava.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Hello world!
 */
public class AnnotiationDemo {
    public static void main(String[] args) {
        MyBook myBook = new MyBook();


        try {
            Class clazz = Class.forName("annotation.UserAnnotation");
            Annotation[] astype = clazz.getAnnotations();
//            for (Annotation a : astype) {
//                AnnotaionTestA ata = (AnnotaionTestA) a;
//                System.out.println(ata.id() + "     " + ata.name() + "     " + ata.gid());
//            }
            Method[] ms=clazz.getDeclaredMethods();
            for (Method m : ms) {
                boolean hasAnnotation=m.isAnnotationPresent(AnnotaionTestA.class);
                if(hasAnnotation){
                    AnnotaionTestA ata=m.getAnnotation(AnnotaionTestA.class);
                    System.out.println(ata.id() + "     " + ata.name() + "     " + ata.gid());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("Hello World!");

//        reflect
//        String classname = "Person";
//        try {
//            Class<?> clazz = Class.forName(classname);
//            Person p = (Person) clazz.newInstance();
//            System.out.println(p.toString());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
