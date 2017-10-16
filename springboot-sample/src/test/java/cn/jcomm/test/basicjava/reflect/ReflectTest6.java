package cn.jcomm.test.basicjava.reflect;

import junit.framework.TestCase;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by jowang on 2017/1/3 0003.
 */
public class ReflectTest6 extends TestCase {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        ArrayList arrayList=new ArrayList();
//        int[] array = new int[10];
//        array[0] = 0;
//        for (int i : array) {
//            System.out.print(i+"--");
//        }
//        System.out.println();
//        Class type = array.getClass().getComponentType();
//        System.out.println(Array.getInt(array, 0));
////        Object o = type.newInstance();
//        Object o=Array.newInstance(type,10);
//        System.arraycopy(array, 0, o, 0, array.length);
//        int[] array2= (int[]) o;
//        for (int i : array2) {
//            System.out.print(i+"--");
//        }

//        Class<? extends ReflectTest6> aClass = ReflectTest6.class;
//        Method get = aClass.getMethod("get");
//        Object invoke = get.invoke(new ReflectTest6());
//        System.out.println(invoke);


    }

    public int get(){
        return 0;
    }

}
