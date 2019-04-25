package cn.jcomm.test.concurrency.c;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import junit.framework.TestCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * @author: jowang
 * @date: 2018-07-11 15:44
 * @description:
 */
public class Test4 extends TestCase {
    public static void main(String[] args) {

    }

    public void test1() {
        ArrayList<Person> people = Lists.newArrayList(new Person("1", "1"),
                new Person("2", "2"),
                new Person("1", "1"));

        System.out.println(JSON.toJSONString(people));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return new CompareToBuilder()
                        .append(o1.getName(), o2.getName())
                        .append(o1.getAge(), o2.getAge())
                        .toComparison();
            }
        });


        System.out.println(JSON.toJSONString(people));
    }

    public void test2() throws Exception {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        PooledObjectFactory factory = new StringBufferFactory();
        ObjectPool<StringBuffer> pool = new GenericObjectPool(factory, config);
        StringReader in = new StringReader("abcdefg");
        StringBuffer buf = null;
        try {
            // 从池中获取对象
            buf = pool.borrowObject();

            // 使用对象
            for (int c = in.read(); c != -1; c = in.read()) {
                buf.append((char) c);
            }
            System.out.println(buf.toString());
        } catch (Exception e) {
            try {
                // 出现错误将对象置为失效
                pool.invalidateObject(buf);
                // 避免 invalidate 之后再 return 抛异常
                buf = null;
            } catch (Exception ex) {
                // ignored
            }

            throw e;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                // ignored
            }

            try {
                if (null != buf) {
                    // 使用完后必须 returnObject
                    pool.returnObject(buf);
                }
            } catch (Exception e) {
                // ignored
            }
        }
    }

    public void test41() {
        System.out.println(JSON.toJSONString(JSON.parseObject("{type:1}", demo.class)));
    }

    public void test42() {
        System.out.println(DateTime.now().plusDays(5).toLocalDate().toDate());
        System.out.println(Days.daysBetween(DateTime.now().plusDays(1), new DateTime().plusDays(5)).getDays());
    }

    public void test43() {
        //StringBuilder result = new StringBuilder();
        //List messages = Arrays.asList("a", "b", "c");
        //List<CompletableFuture> futures = messages.stream()
        //        .map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(s -> delayedUpperCase(s)))
        //        .collect(Collectors.toList());
        //CompletableFuture allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
        //        .whenComplete((v, th) -> {
        //            futures.forEach(cf -> assertTrue(isUpperCase(cf.getNow(null))));
        //            result.append("done");
        //        });
        //allOf.join();
        //assertTrue("Result was empty", result.length() > 0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<String> list = Lists.newArrayList("1", "2");
        CompletableFuture.allOf(list.stream().map(t -> {
            return CompletableFuture.runAsync(() -> {
                System.out.println(t);
            }, executorService);
        }).toArray(l -> new CompletableFuture[l])).join();

    }

    public void test45() {
        System.out.println(JSON.toJSONString(getPage(Lists.newArrayList("1", "2", "3"), 4)));
        System.out.println(JSON.toJSONString(getPage(Lists.newArrayList("1", "2", "3"), 3)));
        System.out.println(JSON.toJSONString(getPage(Lists.newArrayList("1", "2", "3"), 2)));
        System.out.println(JSON.toJSONString(getPage(Lists.newArrayList("1", "2", "3"), 1)));
    }

    /**
     * suggest readonly
     *
     * @param list
     * @param pageSize
     * @param <T>
     * @return
     */
    public <T> List<List<T>> getPage(List<T> list, int pageSize) {
        if (pageSize < 1)
            throw new IllegalArgumentException("pageSize < 1");
        List<List<T>> reslt = new ArrayList<>();
        int pageTotal = list.size() / pageSize + (list.size() % pageSize > 0 ? 1 : 0);
        for (int i = 0; i < pageTotal; i++) {
            List<T> pageList = list.subList(i * pageSize, (i + 1) * pageSize > list.size() ? list.size() : (i + 1) * pageSize);
            reslt.add(pageList);
        }
        return reslt;
    }

    public void test46() {
        ExecutorService threadPool =Executors.newFixedThreadPool(2);
        List<CompletableFuture> futures=Lists.newArrayList();
        //IntStream.range(1,5).forEach(t->{
        //    futures.add(CompletableFuture.runAsync(() -> {
        //        try {
        //            int i = RandomUtils.nextInt(1, 5);
        //            TimeUnit.SECONDS.sleep(i);
        //            System.out.println(i);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //    }, threadPool));
        //});

        threadPool.shutdown();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();

        System.out.println("ok");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Person {
        String name;
        String age;
    }

    static class StringBufferFactory extends BasePooledObjectFactory<StringBuffer> {

        @Override
        public StringBuffer create() throws Exception {
            return new StringBuffer();
        }

        @Override
        public PooledObject<StringBuffer> wrap(StringBuffer stringBuffer) {
            return new DefaultPooledObject<>(stringBuffer);
        }

        @Override
        public void passivateObject(PooledObject<StringBuffer> p) throws Exception {
            p.getObject().setLength(0);
        }
    }

    public static class demo {
        int type;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
