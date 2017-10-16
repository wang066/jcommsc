package cn.jcomm.test.basicjava.socket;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 066 on 2017/2/23 0023.
 */
public class MyTest1 {
    final CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom().setMaxConnPerRoute(100).setMaxConnTotal(100).build();

    ReentrantLock reentrantLock=new ReentrantLock();

    public MyTest1() {
        httpClient.start();
    }

    @Test
    public void test() {
        try {


            // Start the client

            // Execute request
            HttpUriRequest request = null;
            Future<HttpResponse> future=null;
//            FutureCallback<HttpResponse> futureCallback=null;
//            reentrantLock.lock();
            if (ThreadLocalRandom.current().nextInt() > 0) {
                request = new HttpGet("http://192.168.210.80:8822/v1/cards/56XSUE");
                request.addHeader("Content-type", "application/json");
                 future = httpClient.execute(request, null);

            } else {
                request = new HttpPut("http://192.168.210.80:8822/v1/cards/56TH5X");
                StringEntity entity = new StringEntity("{\"cert\":\"0\",\"source\":\"20\",\"address\":\"12312312322000\",\"name\":\"11234434342420000\",\"account\":\"backaccount2000\",\"bank\":\"CAccountBlank2000\",\"type\":\"0\",\"telephone\":\"3343434344242000\",\"taxid\":\"330724199628022003\"}", "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");

                ((HttpPut) request).setEntity(entity);
                future = httpClient.execute(request, null);
            }

            // and wait until a response is received

            HttpResponse response = future.get();

//            if (response.getStatusLine().getStatusCode() != 200) {
//
//
//            } else {
//                String result = EntityUtils.toString(response.getEntity());
//                System.out.println(result);
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            reentrantLock.unlock();
        }

    }

    public static void main(String[] args) {


/*		Map<String,Object> map=qrbarcodeService.getInvoiceContent("56HGWV");

		String portalUserKpinfo=qrbarcodeService.findTzUserinfo("91818766624422LLL11");
		System.out.println(portalUserKpinfo);

		System.out.println("11");*/
        MyTest1 myTest1 = new MyTest1();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 200; j < 300; j++) {
                        myTest1.test();
                    }
                }
            }).start();
        }
        try {
            Thread.currentThread().sleep(1000000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
