package com.revision.topics.array.revision;

// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTQyMg%3D%3D
// PL - https://www.geeksforgeeks.org/problems/majority-element-1587115620/1
// PL - https://leetcode.com/problems/majority-element/submissions/1805032550/
public class MajorityElement {

    //Moore Voting Algorithm
    static int majorityElement(int arr[]) {
        int res = 0;
        int count = 1;

        //Find the potential candidate
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[res]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        //check if the candidate is actually a majority
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[res]) {
                count++;
            }
        }

        //validate the candidate satisfies the condition of majority
        if (count <= arr.length / 2) {
            return -1;
        }
        return arr[res];
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{8, 8, 6, 6, 6, 4, 6}));
        System.out.println(majorityElement(new int[]{1, 1, 2, 1, 3, 5, 1}));
        System.out.println(majorityElement(new int[]{2, 13}));
    }
}
