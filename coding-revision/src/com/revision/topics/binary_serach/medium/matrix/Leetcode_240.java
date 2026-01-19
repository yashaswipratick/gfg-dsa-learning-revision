package com.revision.topics.binary_serach.medium.matrix;

//PL - https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class Leetcode_240 {

    // TODO - Revisit
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1; // important case. check 3rd use case.

        while (row <= matrix.length - 1 && column >= 0) {
            if (target == matrix[row][column]) {
                return true;
            } else if (target < matrix[row][column]) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));

        System.out.println(searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 20));

        System.out.println(searchMatrix(new int[][]{{-1, 3}}, 3));
    }
}
