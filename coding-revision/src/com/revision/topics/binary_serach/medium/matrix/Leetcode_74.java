package com.revision.topics.binary_serach.medium.matrix;

// PL - https://leetcode.com/problems/search-a-2d-matrix/description
public class Leetcode_74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1] >= target) {
                return findTarget(matrix[mid], target);
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    private static boolean findTarget(int[] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 3));
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 13));
    }
}
