package cn.jcomm.test.googleguava.comparisonchain;

import com.google.common.collect.ComparisonChain;

/**
 * Created by jowang on 2017/4/24 0024.
 */
public class ComparisonChainTest {



    public static void main(String[] args) {
        System.out.println(new ComparisonChainTest().compareTo(null));////////*********************************----885
    }


    public int compareTo(Person that) {

        return ComparisonChain.start()
                .compare("1", "2")
                .result();

    }

    class Person implements Comparable<Person> {

        private String lastName;

        private String firstName;

        private int zipCode;


        public int compareTo(Person other) {

            int cmp = lastName.compareTo(other.lastName);

            if (cmp != 0) {

                return cmp;

            }

            cmp = firstName.compareTo(other.firstName);

            if (cmp != 0) {

                return cmp;

            }

            return Integer.compare(zipCode, other.zipCode);

        }
    }
}
