package com.example.springboot2.concurrency.a.a5;

import java.util.PriorityQueue;

/**
 *虽然PriorityQueue保持了队列顶部元素总是最小，但内部的其它元素的顺序却随着元素的减少始终处于变化之中。
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add("dog");
        pq.add("apple");
        pq.add("fox");
        pq.add("easy");
        pq.add("boy");

        while (!pq.isEmpty()) {
            System.out.print("left:"+"\r\n");

            for (String s : pq) {
                System.out.print(s + " ");
            }
            System.out.println();
            System.out.println("poll(): " + pq.poll());
        }
    }
}
