package com.revision.topics.sliding.window.problems.revision.fixed_size_window;

import java.util.ArrayList;
import java.util.List;

// PL - https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
// VL - https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4
public class FirstNegativeInEveryWindowOfSizeK {

    //TODO - Revise again
    static List<Integer> firstNegInt(int arr[], int k) {
        int i = 0;
        int j = 0;
        List<Integer> negative = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        while (j < arr.length) {
            //At every jth index add if number is < 0 to the negative list.
            if (arr[j] < 0) {
                negative.add(arr[j]);
            }

            //sliding window
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k){
                //If negative list is empty then store 0 in result list.
                if (negative.isEmpty()) {
                    result.add(0);
                } else {
                    //The first negative will always come at 0th index of negative list.
                    result.add(negative.get(0));
                }
                if (arr[i] < 0) {
                    // if ith index element is negative then remove it from negative list to maintain
                    // first negative in current subarray
                    negative.remove(0);
                }
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstNegInt(new int[]{-8, 2, 3, -6, 10}, 2));
        System.out.println(firstNegInt(new int[]{12, -1, -7, 8, -15, 30, 16, 28}, 3));
        System.out.println(firstNegInt(new int[]{12, 1, 3, 5}, 3));
    }
}
