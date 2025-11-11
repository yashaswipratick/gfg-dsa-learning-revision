package com.revision.topics.array.revisit;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/wave-array-1587115621
public class WaveArray_33 {

    /**
     * Just swap at each index
     * @param arr
     */
    //TODO - REVISIT - 26 Oct 2025
    public static void sortInWave(int arr[]) {
        // code here
        for(int i = 1; i<arr.length; i = i+2) {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        sortInWave(new int[]{1,2,3,4,5});
        sortInWave(new int[]{2,4,7,8,9,10});
        sortInWave(new int[]{1});
    }
}
