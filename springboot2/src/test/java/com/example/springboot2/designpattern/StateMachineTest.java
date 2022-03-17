package com.example.springboot2.designpattern;

/**
 * @author: jowang
 * @date: 2018-11-21 18:15
 * @description:
 */
public class StateMachineTest {

    public static class StateMachine{

    }

    public static enum Singleton{
        INSTANCE;
    }

    public static enum Utility {
    }

    interface Named{
        String name();
        int order();
    }

    enum Planets implements Named{
        Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune;

        @Override
        public int order() {
            return 0;
        }
    }

    public enum Operation {

        PLUS   { double eval(double x, double y) { return x + y; } },

        MINUS  { double eval(double x, double y) { return x - y; } },

        TIMES  { double eval(double x, double y) { return x * y; } },

        DIVIDE { double eval(double x, double y) { return x / y; } };

        // Do arithmetic op represented by this constant
        abstract double eval(double x, double y);

    }



}
