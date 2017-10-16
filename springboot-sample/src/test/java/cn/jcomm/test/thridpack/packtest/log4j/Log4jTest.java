package cn.jcomm.test.thridpack.packtest.log4j;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 *
 */
public class Log4jTest extends TestCase {
//    private static Logger logger = Logger.getLogger(Log4jTest.class);


    public static void main(String[] args) throws IOException {
        // System.out.println("This is println message.");
        Resource resource = new ClassPathResource("config/log4j.properties");
        PropertyConfigurator.configure(resource.getInputStream());
        Logger logger = Logger.getLogger(Log4jTest.class);
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void test() {
        PropertyConfigurator.configure("config/log4j.xml");
        //在后台输出
        Logger logger1 = Logger.getLogger("console");
        logger1.debug("debug!!!");
        logger1.info("info!!!");
        logger1.warn("warn!!!");
        logger1.error("error!!!");
        logger1.fatal("fatal!!!");
        //在NT系统日志输出
        Logger logger2 = Logger.getLogger("NTlog");
        //NTEventLogAppender nla = new NTEventLogAppender();
        logger2.debug("debug!!!");
        logger2.info("info!!!");
        logger2.warn("warn!!!");
        logger2.error("error!!!");
        //只有这个错误才会写入2000日志
        logger2.fatal("fatal!!!");
        //把日志发送到mail
        Logger logger3 = Logger.getLogger("MailLog");
        //SMTPAppender sa = new SMTPAppender();
        logger3.warn("warn!!!");
        logger3.error("error!!!");
        logger3.fatal("fatal!!!");
    }

    public void test_for_sb() {
        int x = 0, y = 0;
        for (int i = 0; i < 8; i++) {
            x = i % 2 * (610 + 31);//System.out.println((i%2)*610 + (i%2)*31);
            y = (i / 2) % 4 * (215 + 28);//  System.out.println((i/2%4*215)+(i/2%4)*28);
            System.out.println(x);
            System.out.println(y);
        }
    }

}
