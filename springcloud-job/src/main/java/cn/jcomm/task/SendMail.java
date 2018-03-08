package cn.jcomm.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class SendMail implements Job {

    //    @Scheduled(cron = "0/5 * * * * ?")
    public void sendMail() {
        System.out.println("统计失败邮件定时重新发送开始");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("统计失败邮件定时重新发送开始");
    }
}