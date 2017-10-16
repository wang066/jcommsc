package cn.jcomm.test.basicjava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jowang on 2017/1/1 0001.
 */
public class BaseTypeTest1 {

    public static void main(String[] args) {
//        MathContext.DECIMAL64.getPrecision();
//大数
//        BigDecimal bigDecimal=new BigDecimal("1");
//        bigDecimal=bigDecimal.add(new BigDecimal("11111111111111111111111111111111"));
//        System.out.println(bigDecimal.toString());

//        System.out.println(Double.MAX_VALUE);

//        java.lang.
//java.lang.

//可以使用0b 或者_ 表示数了
//        int i1=0b1001;
//        int i2=100_000;
//        System.out.println(i1);
//        System.out.println(i2);

        //直接使用string更为高效
//        String str= "中";
//        char x ='中';
//        byte[] bytes=null;
//        byte[] bytes1=null;
//        try {
////            bytes = str.getBytes("utf-8");
//            bytes=str.getBytes();
//            bytes1 = charToByte(x);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//        System.out.println("bytes 大小："+bytes.length);
//        System.out.println("bytes1大小："+bytes1.length);


       String s="";
        String snull=null;
        System.out.println(s.equals(""));
        System.out.println(s.length());
        List<String> ss=new ArrayList<>();
        char[] chars=new char[]{'a'};
        System.out.println(chars.length);


    }

    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }
}
