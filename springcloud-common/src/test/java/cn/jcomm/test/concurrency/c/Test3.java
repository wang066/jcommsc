package cn.jcomm.test.concurrency.c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;

/**
 * @author: jowang
 * @date: 2018-11-21 11:17
 * @description:
 */
public class Test3 extends TestCase {

    public void test1() {
        //var consumer=()->{};
        //final
        //var example=new ArrayList<>();
        //lombok.val i=0;
        //i++;

        lombok.var i = 0;
        i++;
        System.out.println(i);

        //var
    }

    public void test2(){
        //System.out.println(Ints.stringConverter().convert("1"));
        ;
        System.out.println(JSON.toJSONString(ThreadLocalRandom.current().ints().limit(10).toArray()));
    }

    public void test3(){
        //for (int i = 0; i <3; i++) {
        //    System.out.println(1);
        //}
        //
        //for (;;){
        //    System.out.println(ThreadLocalRandom.current().nextInt());
        //}

        ConcurrentLinkedQueue concurrentLinkedQueue=new ConcurrentLinkedQueue();
        //concurrentLinkedQueue.
    }
}
