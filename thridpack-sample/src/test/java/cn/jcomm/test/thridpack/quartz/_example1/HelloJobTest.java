package cn.jcomm.test.thridpack.quartz._example1;

import org.joda.time.DateTime;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

import static org.quartz.TriggerBuilder.newTrigger;

/**
 *
 */
public class HelloJobTest implements Job {

    public static void main(String[] args) throws SchedulerException, IOException {

//        Resource resource = new ClassPathResource("config/log4j.properties");
//        PropertyConfigurator.configure(resource.getInputStream());
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HelloJobTest.class);

        System.out.println("------- Initializing ----------------------");

        // First we must get a reference to a scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        System.out.println("------- Initialization Complete -----------");

        // computer a time that is on the next round minute
        Date runTime = DateBuilder.evenMinuteDate(new Date());

        System.out.println("------- Scheduling Job  -------------------");

        // define the job and tie it to our HelloJob class
        JobDetail job = JobBuilder.newJob(HelloJobTest.class).withIdentity("job1", "group1").build();

        // Trigger the job to run on the next round minute
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

        // Tell test.quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + runTime);

        // Start up the scheduler (nothing can actually run until the
        // scheduler has been started)
        sched.start();

        System.out.println("------- Started Scheduler -----------------");

        // wait long enough so that the scheduler as an opportunity to
        // run the job!
        System.out.println("------- Waiting 65 seconds... -------------");
        try {
            // wait 65 seconds to show job
            Thread.sleep(65L * 1000L);
            // executing...
        } catch (Exception e) {
            //
        }

        // shut down the scheduler
        System.out.println("------- Shutting Down ---------------------");
        sched.shutdown(true);
        System.out.println("------- Shutdown Complete -----------------");


    }
    private static Logger _log = LoggerFactory.getLogger(HelloJobTest.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello World! - " + DateTime.now().toString());
    }
}
