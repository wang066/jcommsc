package cn.jcomm.test.pack3.lombok;

import lombok.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Set;

/**
 * Created by 066 on 2017/4/5 0005.
 */
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
public class Test2 {
    @NonNull
    private int id;
    @NonNull
    private String shap;
    private int age;

    public static void main(String[] args) {
        new Test2(1, "circle");
        //使用静态工厂方法
        Test2.of(2, "circle");
        //无参构造
        new Test2();
        //包含所有参数
        new Test2(1, "circle", 2);


        BuilderExample.builder().age(11).name("aaa").build();
    }
}

@Builder
class BuilderExample {
    private String name;
    private int age;
    @Singular
    private Set<String> occupations;

    public static void main(String[] args) {
        BuilderExample test = BuilderExample.builder().age(11).name("Test1").build();
    }
}

class ThrowExample {
    @SneakyThrows()
    public void read() {
        InputStream inputStream = new FileInputStream("");
    }
    @SneakyThrows
    public void write() {
        throw new UnsupportedEncodingException();
    }
    //相当于
//    public void read() throws FileNotFoundException {
//        InputStream inputStream = new FileInputStream("");
//    }
//    public void write() throws UnsupportedEncodingException {
//        throw new UnsupportedEncodingException();
//    }
}