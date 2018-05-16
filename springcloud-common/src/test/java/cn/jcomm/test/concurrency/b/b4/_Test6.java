package cn.jcomm.test.concurrency.b.b4;

import junit.framework.TestCase;

import java.lang.ref.WeakReference;
import java.util.*;

/**
 * Created by 066 on 2017/6/28 0028.
 */
public class _Test6 extends TestCase {

    static ThreadLocal<Integer> i = new ThreadLocal<>();

    /**
     * test oom int[] 数组是存放在heap里
     *
     * @param args
     */
    public static void main(String[] args) {
        //heap
//        List<int[]> list = new ArrayList<>();
//        while (true) {
//            int[] ints = new int[1000];
//            list.add(ints);
//        }
        System.out.println(0x7fffffff);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1233123123 >>> 16);


    }

    public void test1() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("3", "33");
        map.put("1", "11");
        map.put("2", "22");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("排序之前:" + entry.getKey() + " 值" + entry.getValue());

        }
        System.out.println("======================================================");
        SortedMap<String, String> sort = new TreeMap<String, String>(map);
        Set<Map.Entry<String, String>> entry1 = sort.entrySet();
        Iterator<Map.Entry<String, String>> it = entry1.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("排序之后:" + entry.getKey() + " 值" + entry.getValue());
        }


    }


    public void test2() {
        ThreadLocal<Integer> t = new ThreadLocal<>();
//        while (true) {
//            t.set(1);
//        }
        t.remove();
        WeakReference<Integer> w = new WeakReference<Integer>(1);
        w.clear();
    }

    public void test3() {
        System.out.println(0.3d==0.1*3);
        toString();
    }

    public void test4() {
        System.out.println("1".equalsIgnoreCase("1"));
    }
}
