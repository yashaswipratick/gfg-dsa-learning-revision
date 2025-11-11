package com.revision.topics.array.revisit.important_concept;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/reverse-array-in-groups0255
public class ReverseInGroups_27 {

    /**
     * Approach
     * If k > arr.lngth reverse the entire array.
     * If k == 1 ignore.
     *  Else
     *      * assign k value to the window variable.
     *      * Get the actual len to reverse the array by taking the mod of arr length and k
     *      * get groups by dividing array length by k
     *      * initialise i to 0;
     *      * run loop until group is greater 0
     *          * inside loop
     *              * reverse the array from ith position till k-1.
     *              * after every reverse of array assign kth value to i.
     *              * increment k to k + window size.
     *              * decrement the group by 1
 *              * In last check if len is greater than 0 outside the loop
     *              * reverse the array from ith position till array length - 1.
     * @param arr
     * @param k
     */
    //TODO - REVISIT - 26 Oct 2025 - important concept
    public static void reverseInGroups(int[] arr, int k) {
        if (k >= arr.length) {
            reverse(arr, 0, arr.length-1);
        } else if (k == 1) {
            return;
        } else {
            int window = k;
            int len = arr.length % k;
            int groups = arr.length / k;
            int i = 0;
            while (groups > 0) {
                reverse(arr, i, k-1);
                i = k;
                k += window;
                groups--;
            }
            if (len > 0) {
                reverse(arr, i, arr.length-1);
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        /*reverseInGroups(new int[]{5, 6, 8, 9}, 5);
        // Basic case - k exactly divides array length
        reverseInGroups(new int[]{1, 2, 3, 4, 5, 6}, 2); // Groups: (1,2), (3,4), (5,6)*/

// Basic case - k does not divide array length
        /*reverseInGroups(new int[]{1, 2, 3, 4, 5}, 3); // Groups: (1,2,3), (4,5)
        reverseInGroups(new int[]{7, 8, 1, 4, 3, 8, 3, 10, 2}, 3);*/ // Groups: (1,2,3), (4,5)
        reverseInGroups(new int[]{10, 5, 5, 10, 6, 10, 1, 7, 1, 7}, 6); // Groups: (1,2,3), (4,5)

/*// Case - k == 1 (no reversal happens)
        reverseInGroups(new int[]{10, 20, 30, 40}, 1);

// Case - k equal to array size (reverse entire array)
        reverseInGroups(new int[]{5, 6, 8, 9}, 4);

// Case - k greater than array size (reverse entire array)
        reverseInGroups(new int[]{5, 6, 8, 9}, 5);

// Smallest array (size = 1)
        reverseInGroups(new int[]{42}, 3);

// Case - array size not multiple of k, small leftover group
        reverseInGroups(new int[]{1, 2, 3, 4, 5, 6, 7}, 4); // Groups: (1,2,3,4), (5,6,7)

// Case - large k = array length - 1
        reverseInGroups(new int[]{1, 2, 3, 4, 5}, 4); // Groups: (1,2,3,4), (5)

// Case - k = 2 with odd length array
        reverseInGroups(new int[]{9, 8, 7, 6, 5}, 2); // Groups: (9,8), (7,6), (5)*/

    }

}
