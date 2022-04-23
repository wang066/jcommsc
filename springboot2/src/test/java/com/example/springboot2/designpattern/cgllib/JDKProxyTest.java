package com.example.springboot2.designpattern.cgllib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static class Main {
        public static void main(String[] args) {
            InvocationHandler handler = new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println(method);
                    if (method.getName().equals("morning")) {
                        System.out.println("Good morning, " + args[0]);
                    }
                    return null;
                }
            };
            Hello hello = (Hello) Proxy.newProxyInstance(
                    Hello.class.getClassLoader(), // 传入ClassLoader
                    new Class[] { Hello.class }, // 传入要实现的接口
                    handler); // 传入处理调用方法的InvocationHandler
            hello.morning("Bob");
        }
    }

    interface Hello {
        void morning(String name);
    }

    //equals
    //public class HelloDynamicProxy implements Hello {
    //     InvocationHandler handler;
    //     public HelloDynamicProxy(InvocationHandler handler) {
    //         this.handler = handler;
    //     }
    //     public void morning(String name) {
    //         handler.invoke(
    //            this,
    //            Hello.class.getMethod("morning", String.class),
    //            new Object[] { name });
    //     }
    // }
}
