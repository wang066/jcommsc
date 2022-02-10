package com.example.springboot_common.netty;

import lombok.Getter;
import lombok.Setter;

public class Bootstrap1 {

    public interface Worker {
        String action(Object object);
    }

    public interface Listener {
        void result(Object result);
    }

    @Getter
    @Setter
    public static class Wrapper {
        private Object param;
        private Worker worker;
        private Listener listener;
    }

    public static void main(String[] args) {
        Bootstrap1 bootstrap1 = new Bootstrap1();
        Worker worker = new Worker() {
            @Override
            public String action(Object object) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return object + " world";
            }
        };

        Wrapper wrapper = new Wrapper();
        wrapper.setWorker(worker);
        wrapper.setParam("hello");

        bootstrap1.doWork(wrapper).setListener(new Listener() {
            @Override
            public void result(Object result) {
                System.out.println("listerer:" + Thread.currentThread().getName());
                System.out.println(result);
            }
        });

        System.out.println(Thread.currentThread().getName());

    }

    public Wrapper doWork(Wrapper wrapper) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Worker worker = wrapper.getWorker();
                String result = worker.action(wrapper.getParam());
                wrapper.getListener().result(result);
            }
        }).start();

        return wrapper;
    }
}
