package cn.jcomm.test.basicjava.validate;

import junit.framework.TestCase;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Max;

import java.util.List;

/**
 * Created by jowang on 2016/12/25 0025.
 */
public class OvalTest extends TestCase{

    @Max(100)
    private int age;
    @Length(min = 1,max = 10)
    private String name;

    public void test(){
        OvalTest ovalTest = new OvalTest();
        ovalTest.age = 1000;
        ovalTest.name = "kolor";

        Validator validator = new Validator();

        List<ConstraintViolation> ret = validator.validate(ovalTest);
        System.out.println(ret);
    }
}
