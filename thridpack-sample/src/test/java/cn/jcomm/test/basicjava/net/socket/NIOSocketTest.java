package cn.jcomm.test.basicjava.net.socket;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * Created by 066 on 2017/3/7 0007.
 */
public class NIOSocketTest {
    public static void main(String[] args) {
//        Thread server = new Thread(Server);
    }
}

class Server implements Runnable {
    private Selector selector;

    @Override
    public void run() {
        try {
            while (true){
                this.selector= Selector.open();

                Iterator<SelectionKey> selectionKeys = this.selector.selectedKeys().iterator();
                while (selectionKeys.hasNext()){
                    SelectionKey key = selectionKeys.next();

                    if (key.isValid()) {

                    }
                }
            }
        } catch (Exception e) {

        }
    }
}
