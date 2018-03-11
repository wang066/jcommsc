package cn.jcomm.test.concurrency.a.a1;

import junit.framework.TestCase;
import org.apache.commons.collections.map.HashedMap;

import java.util.*;

/**
 * Created by jowang on 2016/12/28 0028.
 */
public class ConcurrentTest1 extends TestCase{
    public static void main(String[] args) {
        Collection<String> strings = Collections.synchronizedCollection(new ArrayList<String>());
        Map map = Collections.synchronizedMap(new HashedMap());
    }

    /**
     * 本质还是数组
     * java.lang.UnsupportedOperationException
     at java.util.AbstractList.add(AbstractList.java:148)
     at java.util.AbstractList.add(AbstractList.java:108)
     at _test_thridpack.basicjava.concurrent.list.ConcurrentTest1.test1(ConcurrentTest1.java:25)
     at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     at java.lang.reflect.Method.invoke(Method.java:498)
     at junit.framework.TestCase.runTest(TestCase.java:176)
     at junit.framework.TestCase.runBare(TestCase.java:141)
     at junit.framework.TestResult$1.protect(TestResult.java:122)
     at junit.framework.TestResult.runProtected(TestResult.java:142)
     at junit.framework.TestResult.run(TestResult.java:125)
     at junit.framework.TestCase.run(TestCase.java:129)
     at junit.framework.TestSuite.runTest(TestSuite.java:252)
     at junit.framework.TestSuite.run(TestSuite.java:247)
     at org.junit.internal.runners.JUnit38ClassRunner.run(JUnit38ClassRunner.java:86)
     at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
     at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
     at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:51)
     at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:237)
     at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
     at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     at java.lang.reflect.Method.invoke(Method.java:498)
     at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
     */
    public void test1(){
        String[] array = new String[3];

        List<String> list = Arrays.asList(array);

        list.add("1");
    }

    public void test2(){
        List<String> list=new ArrayList<>();
        String[] array=new String[3];
        list.toArray(array);
        for (String s : array) {
            System.out.println(s);
        }
    }
}
