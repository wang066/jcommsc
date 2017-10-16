package cn.jcomm.test.basicjava.reflect;

import junit.framework.TestCase;

/**
 * Created by jowang on 2017/1/3 0003.
 */
public class ReflectTest3 extends TestCase {

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(i * i);
//        }
//
//        System.out.println(toString2(list));
    }

//    public static String toString2(Object obj) {
//        Class c1 = obj.getClass();
//        String name = c1.getName();
//        do {
//            name += "[";
//            Field[] fields = c1.getDeclaredFields();
//            AccessibleObject.setAccessible(fields, true);
//            for (Field field : fields) {
//                if (! Modifier.isStatic(field.getModifiers())) {
//                    if (! name.endsWith("[")) name += ",";
//                    name += field.getName() + "=";
//                    try {
//                        Object val = field.get(obj);
//                        name += toString2(val);
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//            name += "]";
//            c1 = c1.getSuperclass();
//        } while (c1 != null);
//        return name;
//    }
}
