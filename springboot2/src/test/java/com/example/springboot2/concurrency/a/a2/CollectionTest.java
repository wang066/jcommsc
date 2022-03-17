package com.example.springboot2.concurrency.a.a2;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * 测试Logger 日志记录
 */
public class CollectionTest {

    public void test1() {
        Logger l = Logger.getLogger("Test");
//        Set<Integer> setOfIntegers = new HashSet();
//        setOfIntegers.add(Integer.valueOf(10));
//        setOfIntegers.add(Integer.valueOf(20));
//        setOfIntegers.add(Integer.valueOf(30));
//        setOfIntegers.add(Integer.valueOf(40));
//        setOfIntegers.add(Integer.valueOf(50));
//
//        for (Integer i : setOfIntegers) {
//            l.info("Integer value is : " + i);
//        }

//        Set<Integer> setOfIntegers = new HashSet<Integer>();
//        setOfIntegers.add(Integer.valueOf(10));
//        setOfIntegers.add(Integer.valueOf(11));
//        setOfIntegers.add(Integer.valueOf(10));
//        for (Integer i : setOfIntegers) {
//            l.info("Integer value is: " + i);
//        }

        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer i : listOfIntegers) {
            l.info("Integer value is : " + i);
        }


        //
        Integer i1 = 1000000;
        Integer i2 = 1000000;
        System.out.println(i1.equals(i2));
    }
}
