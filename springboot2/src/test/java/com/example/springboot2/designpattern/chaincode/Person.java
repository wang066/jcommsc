package com.example.springboot2.designpattern.chaincode;

/**
 * Created by jowang on 2016/12/24 0024.
 */
public class Person {
    private String name;
    private int Age;
    private String phone;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return Age;
    }

    public Person setAge(int age) {
        Age = age;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", Age=" + Age +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person p=new Person();
        System.out.println(p.setName("1").setPhone("2").setAge(3).toString());
    }
}
