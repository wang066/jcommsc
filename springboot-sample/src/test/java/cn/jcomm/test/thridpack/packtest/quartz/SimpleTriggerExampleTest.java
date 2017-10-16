package cn.jcomm.test.thridpack.packtest.quartz;

import org.quartz.DateBuilder;

import java.util.Date;

/**
 *
 */
public class SimpleTriggerExampleTest {
    public static void main(String[] args) {
        Date startTime = DateBuilder.nextGivenSecondDate(null, 1);
        System.out.println(startTime);
//        org.quartz.DateBuilder.dateOf()


    }
}
