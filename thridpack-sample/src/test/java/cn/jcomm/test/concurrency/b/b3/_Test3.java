package cn.jcomm.test.concurrency.b.b3;

import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jowang on 2017/6/12 0012.
 */
public class _Test3 {

    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();

        //太反人类了啊啊啊
        try (Closeable closeable=new FileReader("")){

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
