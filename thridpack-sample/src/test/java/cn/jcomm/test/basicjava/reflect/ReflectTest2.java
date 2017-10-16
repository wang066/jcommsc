package cn.jcomm.test.basicjava.reflect;

import junit.framework.TestCase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jowang on 2017/1/3 0003.
 */
public class ReflectTest2 extends TestCase {

    public static void main(String[] args) {

//        Class<?>[] classes = Date.class.getClasses();
//        for (Class<?> aClass : classes) {
//            System.out.println(aClass.getName());
//        }
        Class c1 = ReflectTest2.class;
        Class superC1 = c1.getSuperclass();
        String modifiers = Modifier.toString(c1.getModifiers());
//        System.out.println(superC1.getName());
//        printConstructors(c1);
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        printMothods(c1);


    }

    public static void printConstructors(Class c1) {
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print("");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + " (");

            //print parameter types
            Class[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                Class paramType = paramTypes[i];
                if (i == paramTypes.length - 1) System.out.print(paramType.getName() + "");
                else System.out.print(paramType.getName() + ",");
            }

            System.out.println(");");
        }
    }

    public static void printMothods(Class c1) {
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            Class retType = method.getReturnType();
            String name=retType.getName();

            System.out.print(name+"  ");
            Class[] paramTypes = method.getParameterTypes();
            System.out.print(method.getName()+"  ");
            System.out.print("(");
            for (int i = 0; i < paramTypes.length; i++) {
                Class paramType = paramTypes[i];
                if (i == paramTypes.length - 1) System.out.print(paramType.getName() + "");
                else System.out.print(paramType.getName() + ",");
            }
            System.out.print(");");
            Class[] methodExceptionTypes = method.getExceptionTypes();

            if(methodExceptionTypes.length>0)    System.out.print("  throws   ");
            for (int i = 0; i < methodExceptionTypes.length; i++) {
                Class exceptionType = methodExceptionTypes[i];
                if (i == paramTypes.length - 1) System.out.print(exceptionType.getName() + "");
                else System.out.print(exceptionType.getName() + ",");
            }

            System.out.println("");
        }
    }
}
