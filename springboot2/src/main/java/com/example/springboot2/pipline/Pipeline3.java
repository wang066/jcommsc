package com.example.springboot2.pipline;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

public class Pipeline3 {

    // public interface Pipeline {
    //     void addFirst(Handler... handler);
    //
    //     void addLast(Handler... handler);
    // }

    public interface Pipeline {

        void add(Handler handler);

        void add(Executor executor, Handler handler);
    }

    public interface Handler {

        String getName();

        void invoke(Context context);
    }

    public interface Context<T> {

        T getResult();

        String toPrettyString();
    }

    public interface ResultBuilder<T> {
        T getResult();
    }

    public interface MultiHandler extends Handler {

    }

    public class MultiHandlerImpl implements MultiHandler {

        private List<Handler> handlers;

        @Override
        public String getName() {
            return "MultiHandler";

        }

        @Override
        public void invoke(Context context) {

        }
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
    }
}
