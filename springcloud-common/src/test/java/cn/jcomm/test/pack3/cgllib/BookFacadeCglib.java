package cn.jcomm.test.pack3.cgllib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理
 * Created by jowang on 2016/11/27 0027.
 */
public class BookFacadeCglib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("trans start");
//        methodProxy.invoke(method,objects);
        methodProxy.invokeSuper(o, objects);
        System.out.println("tarns stop");
        return null;
    }

    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImp bookCglib = (BookFacadeImp) cglib.getInstance(new BookFacadeImp());
        bookCglib.addBook();
    }
}
