package cn.jcomm.test.concurrency.b.b4;

import junit.framework.TestCase;

import java.util.*;

/**
 * Created by 066 on 2017/6/28 0028.
 */
public class _Test6 extends TestCase{

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

    }

    public void  test1(){
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("3", "33");
        map.put("1","11");
        map.put("2", "22");

        for (Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println("排序之前:"+entry.getKey()+" 值"+entry.getValue());

        }
        System.out.println("======================================================");
        SortedMap<String,String> sort=new TreeMap<String,String>(map);
        Set<Map.Entry<String,String>> entry1=sort.entrySet();
        Iterator<Map.Entry<String,String>> it=entry1.iterator();
        while(it.hasNext())
        {
            Map.Entry<String,String> entry=it.next();
            System.out.println("排序之后:"+entry.getKey()+" 值"+entry.getValue());
        }


    }

}
