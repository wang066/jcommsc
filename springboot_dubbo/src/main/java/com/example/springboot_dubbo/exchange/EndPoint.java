package com.example.springboot_dubbo.exchange;

public interface EndPoint {

    Url getUrl();

    void send(Object msg);

    void start();

    void stop();

    public class Url {

    }
}
