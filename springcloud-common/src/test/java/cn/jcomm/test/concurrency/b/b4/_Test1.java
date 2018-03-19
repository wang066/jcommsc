package cn.jcomm.test.concurrency.b.b4;

import org.joda.time.DateTime;

/**
 * Created by 066 on 2017/6/28 0028.
 */
public class _Test1 {

    public static void main(String[] args) {

//synchronized ()
        System.out.println(DateTime.now());
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append(i);
        }
        System.out.println(DateTime.now());

        System.out.println(DateTime.now());
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            stringBuffer.append(i);
        }
        System.out.println(DateTime.now());
    }

}
