package com.example.springboot2.designpattern.bridge;

/**
 * Created by 066 on 2017/3/8 0008.
 * 汽车在路上的桥接设计模式的应用
 */
public class CarRunOnRoad {
    public static void main(String[] args) {
        Road road=new SpeedWay();
        road.setCar(new Bus());
        road.run();
    }
}

abstract class Road {
    protected Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public abstract void run();
}

class SpeedWay extends Road {

    @Override
    public void run() {
        car.run();
        System.out.println("SpeedWay");
    }
}

class Street extends Road {

    @Override
    public void run() {
        car.run();
        System.out.println("Street");
    }
}

abstract class Car {
    public abstract void run();
}

class Bus extends Car {

    @Override
    public void run() {
        System.out.println("bus on ");
    }
}