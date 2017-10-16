package cn.jcomm.test.basicjava.commons;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * Created by 066 on 2017/3/28 0028.
 */
public class FastDateFormatTest {
    public static final FastDateFormat ISO_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");

    public static void main(String[] args) {
        Date now = new Date();
        String isoDT = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(now);
        System.out.println("It is currently: " + isoDT);

//        FastDateFormat formatter =
//                new FastDateFormat( "yyyy-mm",
//                        TimeZone.getDefault( ),
//                        Locale.getDefault( ) );

//        String output = formatter.format( new Date( ) );

//        System.out.println(output);

        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
