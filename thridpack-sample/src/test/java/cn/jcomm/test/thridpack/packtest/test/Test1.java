//package cn.jcomm.test.thridpack.packtest.test;
//
//import org.apache.commons.lang3.ArrayUtils;
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// * Created by 066 on 2017/3/20 0020.
// */
//public class Test1 {
//    JdbcTemplate jdbcTemplate;
//
//    public long add(int i1, int i2) {
//        return i1 + i2;
//    }
//
//    @Test
//    public void testAdd() {
//        Assert.assertEquals(3, add(1, 2));
//    }
//
//    public int count() {
//        return jdbcTemplate.queryForObject("", int.class);
//    }
//
//    @Test
//    public void testCount() {
//        //setup、exercise、verify、teardown
////        this.jdbcTemplate=mock
//
//    }
//
//    @Test
//    public void test() {
////        System.out.println(Objects.equals(null, 1));
//        String[] strings = ArrayUtils.toArray("1", "2");
////        ArrayUtils
//
//        //这里会报错 List 是内部类 实质还是数组
////        List<String> list = Arrays.asList("1", "2");
////        list.add("3");
////        list.forEach(t -> System.out.println(t));
//    }
//
//    @Test
//    public void test2() {
//        double d = 3.1415926;
//        String result = String .format("%.2f%%",d);
//        System.out.println(result);
////        System.out.println(String.format("%.2f%"), 0.1d * 100));
//    }
//}
//
