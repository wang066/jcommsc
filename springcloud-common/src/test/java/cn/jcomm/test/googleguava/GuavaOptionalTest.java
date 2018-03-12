package cn.jcomm.test.googleguava;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import junit.framework.TestCase;

/**
 * Created by jowang on 2017/3/20 0020.
 */
public class GuavaOptionalTest extends TestCase {
    public void test1(){
        Optional<Integer> possible=Optional.of(3);
        System.out.println(possible.isPresent());
        System.out.println(possible.get());
    }

    public void test2() throws Exception {
        Optional<Integer> possible=Optional.of(3);
        Optional<Object> absent = Optional.absent();
        Optional<Object> nullable = Optional.fromNullable(null);
        System.out.println(nullable.isPresent());

        System.out.println(possible.isPresent());//是否有值
        System.out.println(possible.get());//get 值

        System.out.println(nullable.or(1));//1

        System.out.println(possible.asSet());
        System.out.println(nullable.asSet());

    }

    public void test3() throws Exception {
//        Objects.
        System.out.println(Strings.isNullOrEmpty("   "));
    }
}
