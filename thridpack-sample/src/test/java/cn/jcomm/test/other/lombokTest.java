package cn.jcomm.test.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * Created by jowang on 2016/11/20 0020.
 */

public class lombokTest {
//    @Data   ：注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
//    @Setter：注解在属性上；为属性提供 setting 方法
//    @Getter：注解在属性上；为属性提供 getting 方法
//    @Log4j ：注解在类上；为类提供一个 属性名为log 的 _log4j 日志对象
//    @NoArgsConstructor：注解在类上；为类提供一个无参的构造方法
//    @AllArgsConstructor：注解在类上；为类提供一个全参的构造方法
    @Test
    public void test(){
        stu s=new stu();
        s.setName("1");
        System.out.println(s.getName());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
//    @Log4j 这里有点问题
    class stu{
        private String name;
    }

}


