package cn.jcomm.test.basicjava;

/**
 *
 */
public class AssertTest {
    public static void main(String[] args) {
//        assert false;
//        System.out.println("ok");
        System.out.println("----start---");
        boolean isOpen = false;
        assert isOpen=true;             //如果开启了断言，会将isOpen的值改为true
        System.out.println("是否开启了断言"+isOpen);  //打印是否开启了断言
        if (isOpen)
        {
            int value=-1;
            assert 0 < value:"value="+value;
        }
        System.out.println("----end----");
    }
}
