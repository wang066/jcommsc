package cn.jcomm.test.basicjava.test;

import junit.framework.TestCase;

/**
 *
 */
public class SomeTest1 extends TestCase {

//    这段代码为什么会输出In the finally block？为什么没有打印出堆栈跟踪信息呢？
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkExit(int status) {
                throw new ThreadDeath();
            }
        });
        try {
            System.exit(0);
        } finally {
            System.out.println("In the finally block");
        }
    }

    public void test1(){
        String str = "Hello";
        String text = "Bye";
        System.out.println(str == text);
        str = text; // 把text的引用赋值给str

    }
}
