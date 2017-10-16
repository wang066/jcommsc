package cn.jcomm.test.thridpack.lombok;

import junit.framework.TestCase;
import lombok.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by 066 on 2017/4/5 0005.
 */
public class Test1 extends TestCase {

    @Setter(AccessLevel.PUBLIC)
    @Getter(AccessLevel.PROTECTED)
    private int id;
    private String shap;

    public static void main(String[] args) {
        val sets = new HashSet<String>();
        val lists = new ArrayList<String>();
        val maps = new HashMap<String, String>();
        //=>相当于如下
        final Set<String> sets2 = new HashSet<>();
        final List<String> lists2 = new ArrayList<>();
        final Map<String, String> maps2 = new HashMap<>();


//        @CommonsLog Creates log = org.apache.commons.logging.LogFactory.getLog(LogExample.class);
//        @Log Creates log = java.util.logging.Logger.getLogger(LogExample.class.getName());
//        @Log4j Creates log = org.apache.log4j.Logger.getLogger(LogExample.class);
//        @Log4j2 Creates log = org.apache.logging.log4j.LogManager.getLogger(LogExample.class);
//        @Slf4j Creates log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
//        @XSlf4j Creates log = org.slf4j.ext.XLoggerFactory.getXLogger(LogExample.class);


//        try {
//            @Cleanup InputStream inputStream = new FileInputStream(args[0]);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        //=>相当于
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void notNullExample(@NonNull String string) {
        string.length();
    }
    //=>相当于
    public void notNullExample2(String string) {
        if (string != null) {
            string.length();
        } else {
            throw new NullPointerException("null");
        }
    }


}


