package cn.jcomm.common;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;

/**
 * @author: jowang
 * @date: 2018-06-30 10:22
 * @description:
 */
public class IDGeneratorTest extends TestCase {

    public void test() {
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 1, TimeUnit.DAYS, new ArrayBlockingQueue<Runnable>(1000));

        Set<Long> longs1 = new HashSet<>();
        Set<Long> longs2 = new HashSet<>();

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                IDGenerator idWorker = new IDGenerator(0, 0);
                IntStream.rangeClosed(1, 1000).forEach(
                        index -> {
                            long id = idWorker.nextId();
                            longs1.add(id);
                            System.out.println(id);
                        }
                );
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                IDGenerator idWorker2 = new IDGenerator(1, 0);
                IntStream.rangeClosed(1, 1000).forEach(
                        index -> {
                            long id = idWorker2.nextId();
                            longs2.add(id);
                            System.out.println(id);
                        }
                );
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(longs1.size() + "---" + longs2.size());
        System.out.println(CollectionUtils.containsAny(longs1, longs2));

        executorService.shutdown();
    }

    public void test3() {
        long time = Duration.between(LocalDate.now().plusDays(1).atStartOfDay(), LocalDateTime.now()).toMillis();
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now().plusDays(1).atStartOfDay());
        System.out.println(Duration.between(LocalDateTime.now(), LocalDate.now().plusDays(1).atStartOfDay()).toMillis());
//        System.out.println(time);
    }

    public void test2() {
        String s = "delete FROM portal_app_message WHERE dt_orderDate <= '2018-7-30' and orderDate >='2018-7-1'";

        DateTime start = new DateTime(2016, 1, 1, 1, 1);
        while (start.isBefore(DateTime.now())) {
            System.out.println("delete FROM portal_app_message WHERE dt_orderDate >='" + start.toString("yyyy-MM-dd") + "' and dt_orderDate <='" + start.plusMonths(1).toString("yyyy-MM-dd") + "'");
            start = start.plusMonths(1);
        }


//        delete FROM portal_app_message WHERE dt_orderDate <='2016-01-01' and orderDate >='2016-02-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-02-01' and orderDate >='2016-03-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-03-01' and orderDate >='2016-04-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-04-01' and orderDate >='2016-05-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-05-01' and orderDate >='2016-06-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-06-01' and orderDate >='2016-07-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-07-01' and orderDate >='2016-08-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-08-01' and orderDate >='2016-09-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-09-01' and orderDate >='2016-10-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-10-01' and orderDate >='2016-11-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-11-01' and orderDate >='2016-12-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2016-12-01' and orderDate >='2017-01-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-01-01' and orderDate >='2017-02-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-02-01' and orderDate >='2017-03-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-03-01' and orderDate >='2017-04-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-04-01' and orderDate >='2017-05-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-05-01' and orderDate >='2017-06-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-06-01' and orderDate >='2017-07-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-07-01' and orderDate >='2017-08-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-08-01' and orderDate >='2017-09-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-09-01' and orderDate >='2017-10-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-10-01' and orderDate >='2017-11-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-11-01' and orderDate >='2017-12-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2017-12-01' and orderDate >='2018-01-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2018-01-01' and orderDate >='2018-02-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2018-02-01' and orderDate >='2018-03-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2018-03-01' and orderDate >='2018-04-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2018-04-01' and orderDate >='2018-05-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2018-05-01' and orderDate >='2018-06-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2018-06-01' and orderDate >='2018-07-01'
//        delete FROM portal_app_message WHERE dt_orderDate <='2018-07-01' and orderDate >='2018-07-30'
    }

}