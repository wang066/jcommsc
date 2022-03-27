package com.example.springboot_leetcode.leetcode;

import com.alibaba.fastjson.JSON;

public class 岛屿数量 {

    static class Solution {
        public static int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        System.out.println(i + "=" + j);
                        count++;
                        clear2(grid, i, j);
                        System.out.println(JSON.toJSONString(grid));
                    }
                }
            }

            return count;
        }

        public static void clear2(char[][] grid, int x, int y) {
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length) {
                return;
            }
            if (grid[x][y] == '1') {
                grid[x][y] = '0';
                clear2(grid, x - 1, y);
                clear2(grid, x + 1, y);
                clear2(grid, x, y + 1);
                clear2(grid, x, y - 1);
            }
        }

        // public static void clear(char[][] grid, int x, int y) {
        //     for (int i = x; i < grid.length; i++) {
        //         for (int j = y; j < grid[i].length; j++) {
        //             if (grid[i][j] == '1') {
        //                 grid[i][j] = '0';
        //                 clearY(grid, i + 1, j);
        //             } else {
        //                 return;
        //             }
        //         }
        //     }
        // }
        //
        //
        // private static void clearY(char[][] grid, int x, int y) {
        //     for (int i = x; i < grid.length; i++) {
        //         if (grid[i][y] == '1') {
        //             grid[i][y] = '0';
        //             clear(grid, i, y);
        //         } else {
        //             return;
        //         }
        //     }
        // }


        public static void main(String[] args) {
            char[][] grid = new char[][]{
                    new char[]{'1', '1', '0', '0', '0'},
                    new char[]{'1', '1', '0', '0', '0'},
                    new char[]{'0', '0', '1', '0', '0'},
                    new char[]{'0', '0', '0', '1', '1'},
            };

            // char[][] grid = new char[][]{
            //         new char[]{'1', '1', '1'},
            //         new char[]{'1', '0', '1'},
            //         new char[]{'1', '1', '1'}
            // };

            // char[][] grid = new char[][]{
            //         new char[]{'1', '1', '1'},
            //         new char[]{'0', '1', '0'},
            //         new char[]{'1', '1', '1'}
            // };
            // [["1","1","1"],["0","1","0"],["1","1","1"]]
            System.out.println(numIslands(grid));
        }
    }


}
