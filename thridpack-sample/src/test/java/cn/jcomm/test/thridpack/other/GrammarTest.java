package cn.jcomm.test.thridpack.other;

/**
 * Created by jowang on 2016/11/18 0018.
 */
public class GrammarTest {
    @org.junit.Test
    public void test(){
        String s="1";
        switch (s) {
            case "2":
                System.out.println("false");
                break;
            case "1":
                System.out.println("ok");
                break;
            default:
                System.out.println("i dont know");
        }
    }
}
