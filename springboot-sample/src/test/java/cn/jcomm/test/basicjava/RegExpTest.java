package cn.jcomm.test.basicjava;

import junit.framework.TestCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jowang on 2017/1/19 0019.
 */
public class RegExpTest extends TestCase{
    public static void main(String[] args) {
//        Pattern p= Pattern.compile("\\w+");
        Pattern p= Pattern.compile("\\d+");
        Pattern p2=Pattern.compile(".*");
        Matcher matcher = p2.matcher("232");
        System.out.println(matcher.find());
        System.out.println(matcher.matches());
        Matcher matcher2 =p.matcher("123word");
        System.out.println(matcher2.find());
        System.out.println(matcher2.matches());
    }

    /**
     * split 切分
     */
    public void test1(){
        Pattern p=Pattern.compile("\\d+");
        String[] str=p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        for (String s : str) {
            System.out.println(s);
        }
    }


    //Pattern.matches 全匹配
    public void  test2(){
        System.out.println(Pattern.matches("\\d+", "2223"));
        System.out.println(Pattern.matches("\\d+", "2223aa"));
        System.out.println(Pattern.matches("\\d+", "22bb23"));
    }

    //当前是哪个创建的
    public void test3(){
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("22bb23");
        System.out.println(m.pattern().pattern());
    }


    public void testlookattest(){
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("22bb23");
        System.out.println(m.lookingAt());
        Matcher m2=p.matcher("aa2223");
        System.out.println(m2.lookingAt());
    }

    public void testfindtest(){
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("22bb23");
        System.out.println(m.find());
        Matcher m2=p.matcher("aa2223");
        System.out.println(m2.find());
        Matcher m3=p.matcher("aa2223bb");
        System.out.println(m3.find());
        Matcher m4=p.matcher("aabb");
        System.out.println(m4.find());
    }

}
