package cn.jcomm.test.googleguava;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import junit.framework.TestCase;

/**
 * Created by jowang on 2017/4/24 0024.
 */
public class OrderingTest extends TestCase {
    public static void main(String[] args) {
        Ordering<String> byLengthOrdering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };

        Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Foo, Comparable>() {
            @Override
            public Comparable apply(Foo input) {
                return input.notSortBy;
            }
        });


    }

    class Foo {
        int notSortBy;
    }
}
