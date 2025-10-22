package com.revision.topics.array.problems;

import java.util.ArrayList;
 // PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/max-and-second-max
public class MaxAndSecondMax_22 {

    public static ArrayList<Integer> largestAndSecondLargest(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();

        int secondLargest = -1;
        int largest = arr[0];
        for(int i = 1; i<arr.length; i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }

            if(arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }

        list.add(largest);
        list.add(secondLargest);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(largestAndSecondLargest(new int[]{2, 1, 2}));
        System.out.println(largestAndSecondLargest(new int[]{3,3,3}));
        System.out.println(largestAndSecondLargest(new int[]{3}));
    }
}
