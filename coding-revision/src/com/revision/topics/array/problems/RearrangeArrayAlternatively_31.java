package com.revision.topics.array.problems;

import java.util.Arrays;


// VL - https://www.youtube.com/watch?v=kQrezgskpho
// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/-rearrange-array-alternately-1587115620
public class RearrangeArrayAlternatively_31 {

            /*
        Approach:
        ---------
        Goal:
        ------
        Rearrange a sorted array such that elements are placed in the following order:
            max, min, 2nd max, 2nd min, 3rd max, 3rd min, and so on.

        Example:
        ---------
        Input:  [1, 2, 3, 4, 5, 6]
        Output: [6, 1, 5, 2, 4, 3]

        Step-by-step logic:
        -------------------
        1. Sort the array first to ensure elements are in ascending order.

        2. Maintain two pointers:
           - minIndex = 0         (points to the smallest element)
           - maxIndex = n - 1     (points to the largest element)

        3. We need to store both old and new values in the same array
           without using extra space.
           To do this, we use **modular arithmetic encoding**:
           - Choose a number `max` greater than the maximum element (max = arr[n-1] + 1).
           - For each position i:
               - If i is even → place the next maximum element.
               - If i is odd  → place the next minimum element.
           - Encode new value into arr[i] as:
                 arr[i] = (newValue % max) * max + oldValue
             This stores both oldValue (in the remainder) and newValue (in the quotient).

        4. After filling the array:
           - Decode the final rearranged values by dividing each element by `max`:
                 arr[i] = arr[i] / max

        5. This achieves in-place rearrangement with O(1) extra space.

        Time Complexity:  O(n log n)  → due to sorting
        Space Complexity: O(1)        → no extra array used

        Key Trick:
        -----------
        → Using modular arithmetic to encode two numbers in a single array element.
        */

    // TODO - Revisit in 3-5 days
    public static void rearrange(int arr[]) {
        Arrays.sort(arr);
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int max = arr[arr.length-1] + 1;

        for(int i = 0; i< arr.length; i++) {
            if(i % 2 == 0) {
                arr[i] = (arr[maxIndex] % max) * max + arr[i];
                maxIndex--;
            } else {
                arr[i] = (arr[minIndex] % max) * max + arr[i];
                minIndex++;
            }
        }

        for(int i = 0; i< arr.length; i++) {
            arr[i]/=max;
        }
    }

    public static void main(String[] args) {
        rearrange(new int[]{890, 289, 483, 519, 550, 447, 946, 957, 92, 783});
    }
}
