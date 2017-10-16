package cn.jcomm.test.basicjava.annotation;

/**
 * Created by jowang on 2016/10/31 0031.
 */
@AnnotaionTestA(id = 1,name = "name",gid = Long.class)
public class UserAnnotation {
    @AnnotaionTestA(id = 2,name = "name2",gid = Long.class)
    public int A(){
        return 0;
    }
    @AnnotaionTestA(id = 3,name = "name3",gid = Long.class)
    public UserAnnotation(){

    }
}
