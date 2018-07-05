package cn.jcomm.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: jowang
 * @date: 2018-07-03 22:04
 * @description:
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "hello world";
    }

    static class UnitTest {
        @Test
        public void testAsynchronous1() throws Exception {
            assertEquals("Hello World!", new CommandHelloWorld("World").queue().get());
            assertEquals("Hello Bob!", new CommandHelloWorld("Bob").queue().get());
        }
    }
}


