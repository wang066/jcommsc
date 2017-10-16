package cn.jcomm.test.basicjava;//package test;
//
//import junit.framework.TestCase;
//
///**
// * Created by jowang on 2016/12/19 0019.
// */
//public class ConcurrencyTestUtilTest {
////    public void testAssertConcurrent() throws InterruptedException {
////        List<Runnable> tasks = new ArrayList<Runnable>(100000);
////        for(int i = 0; i < 100000; i++) {
////            tasks.add(new Runnable() {
////
////                @Override
////                public void run() {
////                    try {
////                        Thread.sleep(20);
////                    }
////                    catch(InterruptedException _) {
////
////                    }
////                }
////
////            });
////        }
////
////        ConcurrencyTestUtil.assertConcurrent("1024tasks", tasks, 10, 1000);
////    }
//
//    public static Test suite() {
//        int users = 10;
//        Timer timer = new ConstantTimer(100);
//        long maxElapsedTime = 2000;
//        return new TimedTest(new LoadTest(
//                new WidgetDAOImplTest("testCreate"), users, timer),
//                maxElapsedTime);
//    }
//
//}
//
//
//public class WidgetDAOImplTest extends TestCase {
//
//
//    public void testCreate() throws Exception{
//        try{
//            Thread.sleep(3000);
//        }catch(Exception e){
//            TestCase.fail("CreateException thrown creating a Widget");
//        }
//    }
//
//    protected void setUp() throws Exception {
////        ApplicationContext context =
////                new ClassPathXmlApplicationContext("spring-config.xml");
////        this.dao = (WidgetDAO) context.getBean("widgetDAO");
//    }
//}