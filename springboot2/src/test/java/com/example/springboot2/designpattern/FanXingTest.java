package com.example.springboot2.designpattern;

public class FanXingTest {
    public static class Context {

    }

    public interface BillBillProcessor<U extends Context> {
        public void action(U context);
    }

    public static abstract class AbstractBillProcessor<T, U extends Context> implements BillBillProcessor<U> {
        @Override
        public void action(U context) {
            this.check();
            int next = next();
            action(next, context);

        }

        public void prepare() {

        }

        public void check() {

        }

        public int next() {
            return 1;
        }


        public void action(int next, U context) {

        }

        public void save() {

        }
    }
}
