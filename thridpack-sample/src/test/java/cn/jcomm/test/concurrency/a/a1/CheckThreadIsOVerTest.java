package cn.jcomm.test.concurrency.a.a1;//package test.thread;
//
//import org.apache.log4j.PropertyConfigurator;
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import _test_thridpack.packtest.log4j.Log4jTest;
//import _test_thridpack.packtest.quartz._example1.HelloJob;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import static org.quartz.TriggerBuilder.newTrigger;
//
///**
// *
// */
//public class CheckThreadIsOVerTest implements Job {
//
////    private static final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
////
////    public static void main(String[] args) throws InterruptedException {
////        Thread t = new Thread(new Runnable() {
////            @Override
////            public void run() {
////
////                while (true) {
//////                    if (!singleThreadExecutor.isShutdown())
////                        singleThreadExecutor.execute(new Runnable() {
////                            @Override
////                            public void run() {
////                                while (true)
////                                {
////                                    try {
////                                        Thread.sleep(100);
////                                    } catch (InterruptedException e) {
////                                        e.printStackTrace();
////                                    }
////                                    System.out.println("run");
////                                }
////                            }
////                        });
//////                    else
//////                        System.out.println("not run");
////                    try {
////                        Thread.sleep(100);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }
////
////            }
////        });
////
////        t.start();
////        Thread.sleep(100000);
////    }
//
//    /**
//     * 测试quartz 中使用线程池的一些注意的点
//     * @param args
//     * @throws IOException
//     * @throws SchedulerException
//     */
//    public static void main(String[] args) throws IOException, SchedulerException {
//        Resource resource = new ClassPathResource("config/log4j.properties");
//        PropertyConfigurator.configure(resource.getInputStream());
//        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Log4jTest.class);
//
//        System.out.println("------- Initializing ----------------------");
//
//        // First we must get a reference to a scheduler
//        SchedulerFactory sf = new StdSchedulerFactory();
//        Scheduler sched = sf.getScheduler();
//
//        System.out.println("------- Initialization Complete -----------");
//
//        // computer a time that is on the next round minute
//        Date runTime = DateBuilder.evenMinuteDate(new Date());
//
//        System.out.println("------- Scheduling Job  -------------------");
//
//        // define the job and tie it to our HelloJob class
//        JobDetail job = JobBuilder.newJob(CheckThreadIsOVerTest.class).withIdentity("job1", "group1").build();
//
//        // Trigger the job to run on the next round minute
////        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
//        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build();
//        // Tell test.quartz to schedule the job using our trigger
//        sched.scheduleJob(job, trigger);
//        System.out.println(job.getKey() + " will run at: " + runTime);
//
//        // Start up the scheduler (nothing can actually run until the
//        // scheduler has been started)
//        sched.start();
//
//        System.out.println("------- Started Scheduler -----------------");
//
//        // wait long enough so that the scheduler as an opportunity to
//        // run the job!
//        System.out.println("------- Waiting 65 seconds... -------------");
//        try {
//            // wait 65 seconds to show job
//            Thread.sleep(65L * 1000L);
//            // executing...
//        } catch (Exception e) {
//            //
//        }
//
//        // shut down the scheduler
//        System.out.println("------- Shutting Down ---------------------");
//        sched.shutdown(true);
//        System.out.println("------- Shutdown Complete -----------------");
//    }
//
//
//    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);
//
//    private static final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(100);
//
//    @Override
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        singleThreadExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    EXECUTOR_SERVICE.execute(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                Thread.sleep(100);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println(1);
//                        }
//                    });
//                }
//            }
//        });
//    }
//}
