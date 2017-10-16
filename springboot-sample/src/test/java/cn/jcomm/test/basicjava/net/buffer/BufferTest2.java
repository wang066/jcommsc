package cn.jcomm.test.basicjava.net.buffer;

import junit.framework.TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by 066 on 2017/3/8 0008.
 * Java NIO系列教程（三） Buffer
 * http://ifeve.com/buffers/
 */
public class BufferTest2 extends TestCase {
    /*
    Buffer的基本用法
    Buffer的capacity,position和limit
    Buffer的类型
    Buffer的分配
    向Buffer中写数据
    flip()方法
    从Buffer中读取数据
    clear()与compact()方法
    mark()与reset()方法
    equals()与compareTo()方法

     */


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            RandomAccessFile aFile = new RandomAccessFile("a.txt", "rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);


//            for (int i = 0; i < 500; i++) {
//                byteBuffer.putInt(i % 48, 1);
//                if (!byteBuffer.hasRemaining()) {
//                    fileChannel.write(byteBuffer);
//                    byteBuffer.clear();
//                }
//            }
//            byteBuffer.clear();

            int read = fileChannel.read(byteBuffer);
            while (read != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.println((char) byteBuffer.get());
                }
                byteBuffer.clear();
                read = fileChannel.read(byteBuffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws Exception
     */
    public void test_FileWrite() throws Exception {
        FileChannel fc = new RandomAccessFile("a.txt", "rw").getChannel(); //RandomAccessFile不支持只写模式，因为把参数设为“w”是非法的

        fc.position(fc.size());        //定位到文件末尾

        fc.write(ByteBuffer.wrap("朋友!".getBytes()));

        fc.close();
    }

    /**
     * 直接写入
     * @throws Exception
     */
    public void test_FileRead() throws Exception {
        FileChannel fc = new FileInputStream("a.txt").getChannel();   //或者用下面的方法

//      fc = new RandomAccessFile("D:\\test.txt","r").getChannel();

        ByteBuffer buff = ByteBuffer.allocate(1024);

        fc.read(buff);

        buff.flip();

        Charset cs = Charset.defaultCharset();

        System.out.println(cs.decode(buff));

        fc.close();
    }


    /**
     * 如何append?
     * @throws Exception
     */
    public void test_FileWrite2() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("a.txt", "rw");
        FileChannel fileChannel = aFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
//        fileChannel.position(fileChannel.size());//这个可以定位文件末尾
        String newData="new string";
        byteBuffer.clear();
        byteBuffer.put(newData.getBytes());
        byteBuffer.flip();
        //注意FileChannel.write()是在while循环中调用的。因为无法保证write()方法一次能向FileChannel写入多少字节，因此需要重复调用write()方法，直到Buffer中已经没有尚未写入通道的字节。
        while (byteBuffer.hasRemaining()){
            fileChannel.write(byteBuffer);
        }
        fileChannel.close();
    }

    public void test_FileRead2() throws Exception {

    }
}
