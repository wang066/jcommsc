package com.example.springboot2.pipline;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

public class Pipeline2 {

    public interface Pipeline {
        void init();

        void start();

        Context getContext();
    }

    @Getter
    @Setter
    public class Context {
        protected long traceId;
    }

    @Getter
    @Setter
    public class BaseDynamicContext<T> extends Context {

        protected Map<String, Object> kv;

        private T returnValue;

        public BaseDynamicContext() {
            kv = new HashMap<>();
        }
    }

    public class UserContext extends BaseDynamicContext<Object> {

        public String getName() {
            return (String) kv.get("name");
        }

        public Integer getAge() {
            return (Integer) kv.get("age");
        }
    }

    public interface Value {

        CompletableFuture<Void> invoke(Context context);

        // void invokeNext(Context context);

        String getValueName();
    }

    public abstract class AbstractBaseValue implements Value {

        @Override
        public CompletableFuture<Void> invoke(Context context) {
            return CompletableFuture.runAsync(() -> {
                System.out.println("AbstractValue");
            });
        }

        @Override
        public String getValueName() {
            return getClass().getSimpleName();
        }
    }

    public abstract class AsyncAbstractAdValue extends AbstractBaseValue {

        private ThreadPoolExecutor threadPoolExecutor;

        public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
            this.threadPoolExecutor = threadPoolExecutor;
            threadPoolExecutor.prestartAllCoreThreads();
        }

        public boolean shouldExecute() {
            return true;
        }

        public void onError(Context context, Exception e) {

        }

        @Override
        public CompletableFuture<Void> invoke(Context context) {
            if (threadPoolExecutor != null) {
                return CompletableFuture.runAsync(() -> {
                    try {
                        super.invoke(context);
                    } catch (Exception e) {
                        onError(context, e);
                    }

                }, threadPoolExecutor);
            }

            return super.invoke(context);
        }

        @Override
        public String getValueName() {
            return getClass().getSimpleName();
        }
    }

    public class Executor {
        private Queue<List<Value>> queue = new LinkedList<>();
    }

    // public class Value1 implements Value {
    //
    //     @Override
    //     public void invoke(Context context) {
    //         System.out.println(1);
    //     }
    //
    //     @Override
    //     public String getValueName() {
    //         return "1";
    //     }
    // }
    //
    // public class Value2 implements Value {
    //
    //     @Override
    //     public void invoke(Context context) {
    //         System.out.println(2);
    //     }
    //
    //     @Override
    //     public String getValueName() {
    //         return "2";
    //     }
    // }
    //
    // public class Value3 implements Value {
    //
    //     @Override
    //     public void invoke(Context context) {
    //         System.out.println(2);
    //     }
    //
    //     @Override
    //     public String getValueName() {
    //         return "2";
    //     }
    // }

    public static void main(String[] args) {
    }
}
