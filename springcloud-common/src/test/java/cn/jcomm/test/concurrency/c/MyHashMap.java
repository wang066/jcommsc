package cn.jcomm.test.concurrency.c;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: jowang
 * @date: 2018-12-07 15:04
 * @description:
 */
public class MyHashMap<K,V> {
    private List<LinkedList> list;

    public V getValue(K key){
        LinkedList linkedList = list.get(key.hashCode() % list.size());
        return null;
    }

    public void  put(K key,V value){

    }
}
