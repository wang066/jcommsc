package cn.jcomm.test.basicjava.file;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jowang on 2017/1/1 0001.
 * todo 文件各种操作
 */
public class FileTest1 {
    public static void main(String[] args) {
//java.io.
//        double d=2;
//        System.out.println(BigDecimal.valueOf(2).doubleValue());
//        System.out.println(Integer.valueOf(2).equals(Double.valueOf(2)));

//        uncheckedGenerics();
    }

    @SuppressWarnings("all")
    static void uncheckedGenerics() {
        List words = new ArrayList();

        words.add("hello"); // this causes unchecked warning
    }
}
