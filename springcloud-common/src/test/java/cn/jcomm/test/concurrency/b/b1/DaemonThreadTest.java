package cn.jcomm.test.concurrency.b.b1;

/**
 * Created by jowang on 2016/11/26 0026.
 */
public class DaemonThreadTest extends Thread{

//    守护线程在没有用户线程可服务时自动离开，在Java中比较特殊的线程是被称为守护（Daemon）线程的低级别线程。
// 这个线程具有最低的优先级，用于为系统中的其它对象和线程提供服务。将一个用户线程设置为守护线程的方式是在线程对象创建之前调用线程对象的setDaemon方法。典型的守护线程例子是JVM中的系统资源自动回收线程，
// 我们所熟悉的Java垃圾回收线程就是一个典型的守护线程，当我们的程序中不再有任何运行中的Thread，程序就不会再产生垃圾，垃圾回收器也就无事可做，
// 所以当垃圾回收线程是Java虚拟机上仅剩的线程时，Java虚拟机会自动离开。它始终在低级别的状态中运行，用于实时监控和管理系统中的可回收资源。
// 守护进程（Daemon）是运行在后台的一种特殊进程。它独立于控制终端并且周期性地执行某种任务或等待处理某些发生的事件。也就是说守护线程不依赖于终端，
// 但是依赖于系统，与系统“同生共死”。那Java的守护线程是什么样子的呢。当JVM中所有的线程都是守护线程的时候，JVM就可以退出了；如果还有一个或以上的非守护线程则JVM不会退出。
//    Java有两种Thread：“守护线程Daemon”与“用户线程User”。
//    我们之前看到的例子都是用户，守护线程是一种“在后台提供通用性支持”的线程，它并不属于程序本体。
//    从字面上我们很容易将守护线程理解成是由虚拟机（virtual machine）在内部创建的，而用户线程则是自己所创建的。事实并不是这样，任何线程都可以是“守护线程Daemon”或“用户线程User”。他们在几乎每个方面都是相同的，唯一的区别是判断虚拟机何时离开：
//    用户线程：Java虚拟机在它所有非守护线程已经离开后自动离开。
//    守护线程：守护线程则是用来服务用户线程的，如果没有其他用户线程在运行，那么就没有可服务对象，也就没有理由继续下去。
//    setDaemon(boolean on)方法可以方便的设置线程的Daemon模式，true为Daemon模式，false为User模式。setDaemon(boolean on)方法必须在线程启动之前调用，当线程正在运行时调用会产生异常。isDaemon方法将测试该线程是否为守护线程。
// 值得一提的是，当你在一个守护线程中产生了其他线程，那么这些新产生的线程不用设置Daemon属性，都将是守护线程，用户线程同样。
    public DaemonThreadTest(){

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        DaemonThreadTest t=new DaemonThreadTest();
        t.setDaemon(true);//设置守护线程
        t.start();
        System.out.println(t.isDaemon());
        //这下面为了模拟用户线程 当用户线程没了，守护进程也就没有意义。
//        try {
//            System.in.read() ;
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}
