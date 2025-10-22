package com.revision.topics.array.revision;

//VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTQwMw%3D%3D
//PL - https://www.geeksforgeeks.org/dsa/length-of-the-longest-alternating-even-odd-subarray/
// Article - https://www.geeksforgeeks.org/dsa/length-of-the-longest-alternating-even-odd-subarray/
public class LongestEvenOddSubArray {

    /**
     * The idea is to find longest subarray of either odd even element or even odd element.
     * Approach
     *
     * Intialise count and res as 1 because arr will have atleast one element odd or even.
     * run a loop from index 1 of the array and each index check below condition
     *  * either arr[i] is even and arr[i-1] is odd OR arr[i] is odd and arr[i-1] is even.
     *      If it satisfies increament the count and store the max(res, count).
     *      else reset count to 1.
     *  Atlast return the res which stores the max length of subarray that contains sequence of odd even or even odd element.
     * @param arr
     * @return
     */
    static int longestEvenOddSubarray(int[] arr) {
        int count = 1;
        int res = 1;

        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i-1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i-1] % 2 == 0)) {
                count++;
                res = Math.max(res,count);
            } else {
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestEvenOddSubarray(new int[]{1, 2, 3, 4, 5, 7, 9}));
        System.out.println(longestEvenOddSubarray(new int[]{5, 10, 20, 6, 3, 8}));
        System.out.println(longestEvenOddSubarray(new int[]{1, 3, 5}));
        System.out.println(longestEvenOddSubarray(new int[]{1, 2, 3, 4, 5, 3, 7, 2, 9, 4 }));
    }
}
