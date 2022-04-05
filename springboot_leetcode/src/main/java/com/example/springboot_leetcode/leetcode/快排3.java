package com.example.springboot_leetcode.leetcode;

import java.util.Arrays;

public class 快排3 {
    public class QuickSort  {

        public int[] sort(int[] sourceArray) throws Exception {
            // 对 arr 进行拷贝，不改变参数内容
            int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

            return quickSort(arr, 0, arr.length - 1);
        }

        private int[] quickSort(int[] arr, int left, int right) {
            if (left < right) {
                int partitionIndex = partition(arr, left, right);
                quickSort(arr, left, partitionIndex - 1);
                quickSort(arr, partitionIndex + 1, right);
            }
            return arr;
        }

        private int partition(int[] arr, int left, int right) {
            // 设定基准值（pivot）
            int pivot = left;
            int index = pivot + 1;
            for (int i = index; i <= right; i++) {
                if (arr[i] < arr[pivot]) {
                    swap(arr, i, index);
                    index++;
                }
            }
            swap(arr, pivot, index - 1);
            return index - 1;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

    public static class QuickSort4 {

        public static void main(String[] args) {
            int n[] = { 3,2,3,1,2,4,5,5,6 };
            quicksort(n);
            System.out.print("快排结果：");
            for (int m : n) {
                System.out.print(m + " ");
            }
        }

        public static void quicksort(int n[]) {
            sort(n, 0, n.length - 1);
        }

        public static void sort(int n[], int l, int r) {
            if (l < r) {
                // 一趟快排，并返回交换后基数的下标
                int index = patition(n, l, r);

                // 递归排序基数左边的数组
                sort(n, l, index - 1);
                // 递归排序基数右边的数组
                sort(n, index + 1, r);
            }

        }

        public static int patition(int n[], int l, int r) {
            // p为基数，即待排序数组的第一个数
            int p = n[l];
            int i = l;
            int j = r;
            while (i < j) {
                // 从右往左找第一个小于基数的数
                while (n[j] >= p && i < j) {
                    j--;
                }
                // 从左往右找第一个大于基数的数
                while (n[i] <= p && i < j) {
                    i++;
                }
                // 找到后交换两个数
                swap(n, i, j);

            }
            // 使划分好的数分布在基数两侧
            swap(n, l, i);
            return i;
        }

        private static void swap(int n[], int i, int j) {
            int temp = n[i];
            n[i] = n[j];
            n[j] = temp;
            System.out.println(Arrays.toString(n));
        }

    }

}
