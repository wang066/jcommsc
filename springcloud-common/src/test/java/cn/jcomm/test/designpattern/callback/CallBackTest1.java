package cn.jcomm.test.designpattern.callback;

import lombok.AllArgsConstructor;
import lombok.Data;

interface Fetcher {
    void fetchData(FetcherCallBack fetcherCallBack);
}

interface FetcherCallBack {
    void success(MyData myData);

    void error(Exception e);
}

/**
 * Created by 066 on 2017/3/2 0002.
 */
public class CallBackTest1 {
    public static void main(String[] args) {
        Worker worker = new Worker(new MyData(1,1));
        worker.doWork();
    }
}

class Worker {
//    FetcherCallBack fetcherCallBack;

    MyData myData;

    public Worker(MyData myData) {
        this.myData = myData;
    }


    public void doWork() {
        new MyFetcher(myData).fetchData(new FetcherCallBack() {
            @Override
            public void success(MyData myData) {
                System.out.println(myData);
            }

            @Override
            public void error(Exception e) {
                System.out.println("no");
            }
        });
    }

}

class MyFetcher implements Fetcher {
    private MyData myData;

    public MyFetcher(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void fetchData(FetcherCallBack fetcherCallBack) {
        try {
            fetcherCallBack.success(myData);
        } catch (Exception e) {
            fetcherCallBack.error(e);
        }
    }
}

@Data
@AllArgsConstructor
class MyData {
    private int n;
    private int m;



//    public MyData(int n, int m) {
//        this.n = n;
//        this.m = m;
//    }
}
