package cn.jcomm.service;

import java.util.concurrent.Future;

/**
 * Created by jowang on 2017/7/13 0013.
 */
public interface AsyncService {
    Future<String> task1() throws InterruptedException;
    Future<String> task2() throws InterruptedException;
}
