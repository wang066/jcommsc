package cn.jcomm.test.googleguava.collection;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.*;

/**
 * Created by jowang on 2017/4/25 0025.
 */
public class MultisetTest {
    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        String[] words = {"a", "b", "c", "a"};
        for (String word : words) {
            Integer count = counts.get(word);
            if (count == null) {
                counts.put(word, 1);
            } else {
                counts.put(word, count + 1);
            }
        }


//        mutiset
        List<Ints> list = Lists.newArrayList();
//        Lists.newArrayListWithCapacity(100);
        Multiset<String> multiset = HashMultiset.create();
        Arrays.stream(words).forEach(t -> multiset.add(t));
        System.out.println(multiset.count("a"));

//        Iterables.
//        Iterables.addAll()
//        Iterators.addAll()

        ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };

        ImmutableListMultimap<Integer, String> digitsByLength= Multimaps.index(digits, lengthFunction);
        System.out.println(digitsByLength);
/*
*  digitsByLength maps:
*  3 => {"one", "two", "six"}
*  4 => {"zero", "four", "five", "nine"}
*  5 => {"three", "seven", "eight"}
*/
//        Multisets.
//        BoundType
//        Range.open()

        TreeSet treeSet=new TreeSet();

    }
}
