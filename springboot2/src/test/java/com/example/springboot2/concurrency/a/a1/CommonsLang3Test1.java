// package com.example.springboot2.concurrency.a.a1;
//
// import junit.framework.TestCase;
// import org.apache.commons.collections.CollectionUtils;
// import org.apache.commons.lang3.ArrayUtils;
//
// import java.util.List;
// import java.util.Map;
//
// /**
//  * Created by 066 on 2017/3/20 0020.
//  * json操作：fastjson
//  阿里巴巴JAVA开发手册29/ 32md5操作：commons-codec工具集合：Guava包数组操作：ArrayUtils（org.apache.commons.lang3.ArrayUtils）集合操作：CollectionUtils(org.apache.commons.collections4.CollectionUtils)除上面以外还有NumberUtils、DateFormatUtils、DateUtils等优先使用org.apache.commons.lang3这个包下的，不要使用org.apache.commons.lang包下面的。原因是commons.lang这个包是从JDK1.2开始支持的所以很多1.5/1.6的特性是不支持的，例如：泛型。
//  */
// public class CommonsLang3Test1 {
//     public static void main(String[] args) {
// //        org.apache.commons.
// //        StringUtils.replacePattern()
// //        ArrayUtils.
//         Map<Object, Object> objectObjectMap = ArrayUtils.toMap(new Object[][]{{1, 1}});
// //        objectObjectMap.forEach();
//         System.out.println(objectObjectMap.get(1));
//
// //        EnumUtils.
//
// //        ExceptionUtils
//     }
//
//     public void  test1(){
// //        Collections.
// //        CollectionUtils.addAll();
//         List<String> list=null;
//         System.out.println(CollectionUtils.isEmpty(list));
//     }
//
//
// }
