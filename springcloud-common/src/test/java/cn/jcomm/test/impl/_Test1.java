package cn.jcomm.test.impl;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: jowang
 * @date: 2018-07-11 18:48
 * @description:
 */
public class _Test1 {
    public static void main(String[] args) {
        ServiceLoader<DemoService> serviceLoader = ServiceLoader.load(DemoService.class);
        Iterator<DemoService> it = serviceLoader.iterator();
        while (it!=null && it.hasNext()) {
            DemoService demoService = it.next();
            System.out.println("class:"+demoService.getClass().getName()+"***");
            demoService.sayHi("World");
        }
    }
}
