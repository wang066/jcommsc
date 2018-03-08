package cn.jcomm.task;

import org.springframework.stereotype.Component;

@Component
public class SendMail {

    public void sendMail() {
        System.out.println("统计失败邮件定时重新发送开始");
    }
}