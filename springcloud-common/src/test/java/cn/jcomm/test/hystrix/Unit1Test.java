package cn.jcomm.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.junit.Test;

import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

/**
 * @author: jowang
 * @date: 2018-07-05 9:23
 * @description:
 */
public class Unit1Test {
    @Test
    public void testAsynchronous1() throws Exception {
        Future<String> queue = new CommandHelloWorld("World!").queue();
        assertEquals("Hello World", queue.get());
//        assertEquals("Hello Bob", new CommandHelloWorld("Bob").queue().get());
    }

    class CommandHelloWorld extends HystrixCommand<String> {

        private final String name;

        public CommandHelloWorld(String name) {
            super(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"));
            this.name = name;
        }

        @Override
        protected String run() throws Exception {
            return "Hello World";
        }
    }


}
