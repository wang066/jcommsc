package com.example.springboot_leetcode.leetcode;

import java.util.Arrays;
// 作者：wonderzlf
// 链接：https://leetcode-cn.com/problems/sort-an-array/solution/javakuai-su-pai-xu-jian-xi-by-wonderzlf/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class Alg912快排QuickSort2 {

    /**
     * 数组内元素交换
     * @param nums 输入数组
     * @param i 元素1下标
     * @param j 元素2下标
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums [i];
        nums [i] = nums [j];
        nums [j] = temp;
    }

    /**
     * 快速排序
     *
     * @param nums 输入数组
     * @param left 划分左边界
     * @param right 划分右边界
     */
    private static void quickSort(int[] nums, int left, int right) {
        // 递归返回条件，和分区排序结束
        if (right-left <=0) {
            return;
        }
        // 选择数组右边界值作为分区节点
        int pivot = nums[right];
        // 从数组左边界值开始维护分区
        int partition=left-1;
        // 遍历当前分区内元素
        for (int i = left; i <= right-1; i++) {
            if ((nums [i] < pivot) ) {
                // 将小于pivot的值交换到partition左边
                // 将大于等于pivot的值交换到partition右边
                partition++;
                swap(nums, partition, i);
            }
        }
        // 将分区节点插入到数组左右分区中间
        partition++;
        swap(nums, partition, right);
        // 分区节点排序完成
        // 左分区继续排序，右分区继续排序
        quickSort(nums,left, partition-1);
        quickSort(nums,partition+1, right);
    }

    /**
     * 排序数组入口函数
     *
     * @param nums 输入数组
     * @return 返回完成排序的数组
     */
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length ==0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {6,72,113,11,23};
        array= Alg912快排QuickSort2.sortArray(array);
        System.out.println("排序后的结果");
        System.out.println(Arrays.toString(array));

    }


}
