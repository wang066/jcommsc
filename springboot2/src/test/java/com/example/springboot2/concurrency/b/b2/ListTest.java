package com.example.springboot2.concurrency.b.b2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jowang on 2016/11/26 0026.
 */
public class ListTest {

    //linkedlist 双向链表
    @Test
    public void test() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        System.out.println("loop print");
        for (String s : linkedList) {
            System.out.println(s);
        }

        List sub = linkedList.subList(1, 4);
        System.out.println(sub);

        //
        String[] ss = linkedList.toArray(new String[]{"1", "2"});
        System.out.println(ss);
        for (String s : ss) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() {
        System.out.println(toDouble("123.4"));
//        System.out.println(toDouble(".123"));
//        System.out.println(toDouble("123."));
//        System.out.println(toDouble("1.23"));
//        System.out.println(toDouble("1.23a"));
    }

    @Test
    public void test3() {
//        Scanner scanner=new Scanner(System.in);
//        if(scanner.hasNext()){
//            System.out.println(scanner.next());
//        }

        System.out.println(100 == 100);
        System.out.println(1000 == 1000);
        System.out.println('a' == 'a');
    }

    /**
     * 字符串转double 面试题 多准面试题
     *
     * @param string
     * @return
     */
    public Double toDouble(String string) {
        if (string.isEmpty() || string == null) return null;
        char[] chars = string.toCharArray();
        char charDot = '.';
        char[] charsDouble = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Double result = null;

        //确认是否为数字
        int iDot = chars.length;
        boolean isDouble = true;
        for (int i = 0; i < chars.length; i++) {
            if (charDot == chars[i]) iDot = i;
            else {
                boolean isNum = false;
                for (char cdouble : charsDouble) {
                    if (cdouble == chars[i]) {
                        isNum = true;
                        break;
                    }
                }
                if (!isNum) {
                    isDouble = false;
                    break;
                }
            }
        }
        if (iDot == chars.length - 1 || iDot == 0) isDouble = false;
        if (isDouble == false) {
            System.out.println("不是double");
            return null;
        }

        result = 0d;
        for (int i = 0; i < chars.length; i++) {
            String temp = String.valueOf(chars[i]);
            if (i < iDot) {
                result += Math.pow(10, iDot - i - 1) * Double.valueOf(temp);
            } else if (i > iDot) {
                result += Math.pow(0.1, i - iDot) * Integer.valueOf(temp);
            }
        }

        return result;
    }

//    /**
//     * c 是否为chars里的元素
//     *
//     * @param c
//     * @param chars
//     * @return
//     */
//    public int Contain(char c, char[] chars) {
//        for (int i = 0; i < chars.length; i++) {
//            if (c == chars[i]) return i;
//        }
//        return - 1;
//    }


}
