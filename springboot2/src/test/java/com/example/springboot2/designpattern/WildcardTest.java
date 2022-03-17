package com.example.springboot2.designpattern;

import java.util.ArrayList;

/**
 *
 */
public class WildcardTest {
    public static void main(String[] args) {
        MyBox myBox = new MyBox();
        MyUnbox myUnbox = new MyUnbox();
        myUnbox.unbox(myBox);

        Box sBox = BoxImpl.<Integer>make();
    }
}

class MyList1<T extends Integer> extends ArrayList<T> {
}

interface Box<T extends Object> {
    public T get();

    public void put(T element);
}

class MyBox implements Box {

    @Override
    public Object get() {
        return 1;
    }

    @Override
    public void put(Object element) {
        System.out.println("put");
    }
}

class MyUnbox {
    public void unbox(Box<?> box) {

        System.out.println(box.get());
    }

    public <V> void unbox2(Box<V> box, V v) {
        box.put(v);
    }
}

class BoxImpl<T> implements Box<T> {

    public static <V> Box<V> make() {
        return new BoxImpl<V>();
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public void put(T element) {

    }
}