package cn.jcomm.test.concurrency.c;

import java.util.LinkedHashMap;

import junit.framework.TestCase;

/**
 * @author: jowang
 * @date: 2018-09-30 9:31
 * @description: Least Recent Used
 *
 */
public class LRUTest extends TestCase{
    public void  test1(){
        LinkedHashMap lru=new LinkedHashMap(5,0.75f,true);
    }
}
