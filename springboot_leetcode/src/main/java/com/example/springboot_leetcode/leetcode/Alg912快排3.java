package com.example.springboot_leetcode.leetcode;

import java.util.Arrays;
import java.util.Random;
// 作者：wonderzlf
// 链接：https://leetcode-cn.com/problems/sort-an-array/solution/javakuai-su-pai-xu-jian-xi-by-wonderzlf/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class Alg912快排3 {
    public class QuickSort  {

        public int[] sortArray(int[] nums) {
            randomizedQuicksort(nums, 0, nums.length - 1);
            return nums;
        }

        public void randomizedQuicksort(int[] nums, int l, int r) {
            if (l < r) {
                int pos = randomizedPartition(nums, l, r);
                randomizedQuicksort(nums, l, pos - 1);
                randomizedQuicksort(nums, pos + 1, r);
            }
        }

        public int randomizedPartition(int[] nums, int l, int r) {
            int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
            swap(nums, r, i);
            return partition(nums, l, r);
        }

        public int partition(int[] nums, int l, int r) {
            int pivot = nums[r];
            int i = l - 1;
            for (int j = l; j <= r - 1; ++j) {
                if (nums[j] <= pivot) {
                    i = i + 1;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, r);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
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
