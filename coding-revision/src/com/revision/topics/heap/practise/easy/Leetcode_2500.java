package com.revision.topics.heap.practise.easy;

import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/delete-greatest-value-in-each-row/

public class Leetcode_2500 {

    public static int deleteGreatestValue(int[][] grid) {
        int sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int k = grid[0].length;
        while (k-- > 0){
            for (int i = 0; i < grid.length; i++) {
                pq.add(findMaxIdx(grid[i], i, visited));
                if (pq.size() > 1) {
                    pq.poll();
                }
            }
            sum += (!pq.isEmpty() ? pq.poll() : 0);
        }
        return sum;
    }

    private static int findMaxIdx(int[] nums, int j, boolean[][] visited) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max && !visited[j][i]) {
                max = nums[i];
                idx = i;
            }
        }
        visited[j][idx] = true;
        return nums[idx];
    }

    public static void main(String[] args) {
        System.out.println(deleteGreatestValue(new int[][]{{1, 2, 4}, {3, 3, 1}}));
        System.out.println(deleteGreatestValue(new int[][]{{10}}));
    }
}
