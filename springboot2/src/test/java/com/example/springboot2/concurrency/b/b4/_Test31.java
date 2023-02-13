package com.example.springboot2.concurrency.b.b4;

import lombok.Lombok;

/**
 * Created by 066 on 2017/6/28 0028.
 */
public class _Test31 {

    public static void main(String[] args) {

        sneakThrow1(new Throwable("111"));
    }


    public static RuntimeException sneakThrow1(Throwable t) {
        if (t == null) {
            throw new NullPointerException("aaaa");
        }

        return sneakyThrow(t);
    }


    public static RuntimeException sneakyThrow(Throwable t) {
        if (t == null) throw new NullPointerException("t");
        return _Test31.sneakyThrow0(t);
    }

    public static <T extends Throwable> T sneakyThrow0(Throwable t) throws T {
        throw (T) t;
    }


    // public static RuntimeException sneakyThrow(Throwable t) {
    //     if (t == null) throw new NullPointerException("t");
    //     return Lombok.<RuntimeException>sneakyThrow0(t);
    // }
    //
    // private static <T extends Throwable> T sneakyThrow0(Throwable t) throws T {
    //     throw (T)t;
    // }

}
