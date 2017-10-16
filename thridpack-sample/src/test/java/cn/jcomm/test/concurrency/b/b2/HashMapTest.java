package cn.jcomm.test.concurrency.b.b2;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by jowang on 2016/11/25 0025.
 */
public class HashMapTest {

    @Test
    public void test(){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);

        for (Integer integer : map.keySet()) {
            System.out.println(integer);
        }

        for (Integer integer : map.values()) {
            System.out.println(integer);
        }
    }
}
