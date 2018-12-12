package cn.jcomm.test.concurrency.c;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: jowang
 * @date: 2018-12-06 13:44
 * @description:
 */
public class ABATest {
    public static void main(String[] args) {
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 0);
        AtomicInteger integer = new AtomicInteger(0);

        //IntStream.range(1, 3).forEach(t -> {
        //    new Thread(() -> {
        //
        //    }).start();
        //});
        System.out.println(atomicStampedReference.getStamp());
        boolean b1 =      atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
        System.out.println(atomicStampedReference.getStamp());//0,1
        boolean b2 =      atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
        System.out.println(atomicStampedReference.getStamp());//1,2
        boolean b3 = atomicStampedReference.compareAndSet(100, 101, 0,1);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

    }
}
