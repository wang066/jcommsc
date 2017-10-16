package cn.jcomm.test.concurrency.b.b2;

import java.util.Scanner;

/**
 * Created by jowang on 2016/11/26 0026.
 */
public class ScannerTest {

    public static void main(String[] args) {
        String str = "1 2 3 4 5 6 7 8 9";
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        while (scanner.hasNext()&&total<3) {
            total += scanner.nextInt();
        }
        System.out.println("TOTAL:" + total);
        scanner.close();
    }
}
