package cn.jcomm.test.googleguava;

import com.google.common.base.Preconditions;
import junit.framework.TestCase;

/**
 * Created by jowang on 2017/4/24 0024.
 */
public class GuavaPreconditionsTest extends TestCase{
    public static void main(String[] args) {

    }

    public void test1() throws Exception {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(false);
    }

    public void test2() throws Exception {

        Preconditions.checkNotNull(null,"not 1");
        Preconditions.checkNotNull(1,"not 1");

    }

    public void test3() throws Exception {
//        Preconditions p=new Preconditions()
        Preconditions.checkElementIndex(1,1,"aaaa");
    }
}
