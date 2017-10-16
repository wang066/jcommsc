package cn.jcomm.test.thridpack.other;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * Created by jowang on 2016/11/16 0016.
 */
public class JodaTest {
    @Test
    public void JodaTest1() {
        DateTime dt = new DateTime();
        System.out.println("----------------------");
        System.out.println(dt);
//        LocalDate localDate=SystemFactory.
        DateTime dt2 = new DateTime(2000, 1, 1, 1, 1);
        dt2 = dt2.plusDays(3);
        System.out.println(dt2.toString("E MM/dd/yyyy HH:mm:ss.SSS"));
        System.out.println("----------------------");
    }
}
