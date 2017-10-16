package cn.jcomm.test.concurrency.a.a1;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *
 */
public class PipedTest {

    public static void main(String[] args) {

        sender sender = new sender();
        reciver reciver = new reciver();
        try {
            sender.out.connect(reciver.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sender.start();
        reciver.start();

    }

    static class sender extends Thread {
        public PipedOutputStream out = new PipedOutputStream();

        @Override
        public void run() {
            try {
                out.write("hello".getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class reciver extends Thread {
        public PipedInputStream in = new PipedInputStream();

        @Override
        public void run() {
            try {
                byte[] bytes = new byte[1000];
                int read = in.read(bytes);
                System.out.println(new String(bytes));
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
