package com.revision.topics.array.problems;

//VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTQwMw%3D%3D
//PL - https://www.geeksforgeeks.org/dsa/length-of-the-longest-alternating-even-odd-subarray/
// Article - https://www.geeksforgeeks.org/dsa/length-of-the-longest-alternating-even-odd-subarray/
public class LongestEventOddSubarray_13 {

    /**
     * Initialise two varaible one is count and one is res with 1.
     * count will maintain the current count of odd even sequence
     * res will store the max of the count and res in entire array.
     * check two condition
     *      if first element is even and second is odd OR second is odd and first is even then increment
     *      the count and get the max of count and res and store the max in res.
     *
     *      else if the sequence break resent the count to 1 and start again.
     * @param arr
     * @return
     */
    // TODO - REVISIT - 12 Oct 2025
    static int longestEvenOddSubarray(int[] arr) {
        int count = 1;
        int res = 1;

        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i-1] % 2 == 1)
            || (arr[i] % 2 != 0 && arr[i-1] % 2 == 0)) {
                count++;
                res = Math.max(count, res);
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
