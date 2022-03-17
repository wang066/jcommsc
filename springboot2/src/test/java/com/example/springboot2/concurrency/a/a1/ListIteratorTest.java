package com.example.springboot2.concurrency.a.a1;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 */
public class ListIteratorTest {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList();
        for(int i=1;i<6;i++)
            list.add(new Integer(i));
        ListIterator<Integer> lt=list.listIterator(list.size());
        while(lt.hasPrevious())
            System.out.println(lt.previous());

//        LinkedList linkedList=new LinkedList();
//        for(int i=1;i<6;i++)
//            list.add(i);
//        while(linkedList.listIterator())
//            System.out.println(lt.previous());

    }
}
