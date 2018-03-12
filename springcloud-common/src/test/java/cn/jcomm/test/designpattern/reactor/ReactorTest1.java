package cn.jcomm.test.designpattern.reactor;

/**
 * Created by 066 on 2017/2/27 0027.
 * 反应堆 设计模式
 */
public class ReactorTest1 {
    public static void main(String[] args) {

    }
}

class Reactor {
    public void handlEvents() {

    }

    public void register() {

    }

    public void remove() {

    }
}

/**
 * 同步事件复用器 （多路复用）
 */
class SynchronousEventDemultiplexer{

}

class Handle{

}

interface EventHanlder{
    void handleEvent();
    void getHandle();
}

class ConcreteEventHandlerA  {

}

class ConcreteEventHandlerB {

}