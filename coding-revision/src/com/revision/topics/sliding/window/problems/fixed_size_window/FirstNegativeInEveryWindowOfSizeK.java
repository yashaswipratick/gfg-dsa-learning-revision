package com.revision.topics.sliding.window.problems.fixed_size_window;

import java.util.ArrayList;
import java.util.List;

// PL - https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
// VL - https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4
public class FirstNegativeInEveryWindowOfSizeK {

    // It is always assumed that negatList will contain the first negative always element int he current window size
    // at index 0 of negatList list.
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int i = 0;
        int j = 0;
        List<Integer> negatList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        while(j < arr.length) {
            if(arr[j] < 0) {
                negatList.add(arr[j]);
            }

            if(j-i+1 < k) {
                j++;
            } else if(j-i+1 == k) {
                if (negatList.isEmpty()) {
                    list.add(0);
                } else {
                    list.add(negatList.get(0));
                }
                if (arr[i] < 0) {
                    negatList.remove(0);
                }
                i++;
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(firstNegInt(new int[]{-8, 2, 3, -6, 10}, 2));
        System.out.println(firstNegInt(new int[]{12, -1, -7, 8, -15, 30, 16, 28}, 3));
        System.out.println(firstNegInt(new int[]{12, 1, 3, 5}, 3));
    }
}
