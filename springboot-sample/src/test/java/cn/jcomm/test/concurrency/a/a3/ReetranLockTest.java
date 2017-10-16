package cn.jcomm.test.concurrency.a.a3;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * cache demo2
 * 线程进入读锁的前提条件：
 没有其他线程的写锁，
 没有写请求或者有写请求，但调用线程和持有锁的线程是同一个

 线程进入写锁的前提条件：
 没有其他线程的读锁
 没有其他线程的写锁

 (a).重入方面其内部的WriteLock可以获取ReadLock，但是反过来ReadLock想要获得WriteLock则永远都不要想。
 (b).WriteLock可以降级为ReadLock，顺序是：先获得WriteLock再获得ReadLock，然后释放WriteLock，这时候线程将保持Readlock的持有。反过来ReadLock想要升级为WriteLock则不可能，为什么？参看(a)，呵呵.
 (c).ReadLock可以被多个线程持有并且在作用时排斥任何的WriteLock，而WriteLock则是完全的互斥。这一特性最为重要，因为对于高读取频率而相对较低写入的数据结构，使用此类锁同步机制则可以提高并发量。
 (d).不管是ReadLock还是WriteLock都支持Interrupt，语义与ReentrantLock一致。
 (e).WriteLock支持Condition并且与ReentrantLock语义一致，而ReadLock则不能使用Condition，否则抛出UnsupportedOperationException异常。
 */
public class ReetranLockTest {
//    static ReentrantLock reentrantLock=new ReentrantLock();

    static Map<String, Object> map = new HashedMap();

    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        Object val = null;
        reentrantReadWriteLock.readLock().lock();
        try {

            val=map.get("1");
            System.out.println(map);
            if(val==null){
                reentrantReadWriteLock.readLock().unlock();
                reentrantReadWriteLock.writeLock().lock();
                try {
                    val="a";
                    map.put("1",val);
                    System.out.println(map);
                }finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }

                reentrantReadWriteLock.readLock().lock();
            }
        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }

    }
}
