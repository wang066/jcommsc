package cn.jcomm.test.concurrency.c;

import junit.framework.TestCase;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by jowang on 2018/9/19 0019.
 */
public class Test2 extends TestCase {
    public static void main(String[] args) {

    }

    public void test1(){
        List<String> list= Lists.newArrayList("1","2","abc");
        list.stream().filter(t->t.equals("1"));
        Stream<char[]> stream = list.stream().flatMap(t -> Stream.of(t.toCharArray()));
    }

    public void test2(){
        Integer ii=null;
        Optional<Integer> i=Optional.of(ii);
        Supplier<? extends Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 2;
            }
        };
        System.out.println(i.orElse(3));
    }

    public void test3(){

    }
}
