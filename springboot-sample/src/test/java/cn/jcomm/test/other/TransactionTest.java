package cn.jcomm.test.other;//package cn.jcomm.test.thridpack.mytest;
//
//import jowang.bookstore_springmvc.BasicTest;
//import jowang.bookstore_springmvc.entity.BsCustomer;
//import jowang.bookstore_springmvc.service.CustomerService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.TransactionCallback;
//import org.springframework.transaction.support.TransactionTemplate;
//
///**
// * Created by jowang on 2016/11/19 0019.
// */
//
//public class TransactionTest extends BasicTest {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Test
//    public void test() {
//        boolean execute =(Boolean) new TransactionTemplate().execute(new TransactionCallback<Object>() {
//            @Override
//            public Object doInTransaction(TransactionStatus status) {
//                try {
//                    BsCustomer customer = new BsCustomer();
//                    customer.setUserid("lin");
//                    customer.setUserpwd("wang");
//                    customerService.register(customer);
//                    throw new Exception("i want _test trans");
//                } catch (Exception e) {
//                    status.setRollbackOnly();
//                    return true;
//                }
//            }
//        });
//        Assert.assertTrue(execute);
//    }
//}
