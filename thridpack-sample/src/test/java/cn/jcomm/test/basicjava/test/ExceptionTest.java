package cn.jcomm.test.basicjava.test;

/**
 *
 */
public class ExceptionTest {
    @SuppressWarnings(value = "")
    public static int get(){
        int i=0;
        try {
            i=1;
            return i;
        }catch (Exception e){
            i=2;
            return i;
        }finally {
            i=3;
        }
    }

    public static void main(String[] args) {
        System.out.println(get());
    }
}
