package cn.jcomm.test.basicjava.socket;

import javafx.concurrent.Task;
import junit.framework.TestCase;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class SocketTest extends TestCase {

    public void test() {
        List<Task> taskQueue = Collections.synchronizedList(new LinkedList<Task>());
    }
}
