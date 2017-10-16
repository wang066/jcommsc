package cn.jcomm.test.basicjava.commons;

import java.text.DecimalFormat;

/**
 * Created by 066 on 2017/2/16 0016.
 */
public class MathTest {
    public static void main(String[] args) {
        double d = 3.1155926;
        String result = String.format("%.2f",d);
        System.out.println(result);


        DecimalFormat    df   = new DecimalFormat("######0.00");

        double d1 = 3.23456;
        double d2 = 0.0;
        double d3 = 2.0;
        System.out.println(df.format(d1));
        System.out.println(df.format(d2));
        df.format(d3);

        System.out.println(new DecimalFormat("#.00").format(3.1415926));


        DecimalFormat df2=new DecimalFormat(".##");
        double dd2=1252.2563;
        String st2=df.format(dd2);
        System.out.println(st2);
//        CyclicBarrier;

    }
}
