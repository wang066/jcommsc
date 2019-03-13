package cn.jcomm.test.concurrency.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import junit.framework.TestCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 * @author: jowang
 * @date: 2018-07-11 15:44
 * @description:
 */
public class Test4 extends TestCase {
    public static void main(String[] args) {

    }

    public void test1() {
        ArrayList<Person> people = Lists.newArrayList(new Person("1", "1"),
                new Person("2", "2"),
                new Person("1", "1"));

        System.out.println(JSON.toJSONString(people));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return new CompareToBuilder()
                        .append(o1.getName(), o2.getName())
                        .append(o1.getAge(), o2.getAge())
                        .toComparison();
            }
        });



        System.out.println(JSON.toJSONString(people));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class  Person{
        String name;
        String age;
    }

}
