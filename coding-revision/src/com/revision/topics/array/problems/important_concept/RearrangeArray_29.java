package com.revision.topics.array.problems.important_concept;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/rearrange-an-array-with-o1-extra-space3142
// VL - https://www.youtube.com/watch?v=h4aBagy4Uok

public class RearrangeArray_29 {

    /*
        Approach:
        ---------
        Problem Context:
        The goal of this method is to rearrange the elements of the array
        such that each element at index 'i' becomes the value of the array
        at the index specified by its current value.
        In simple terms, if arr[i] = j, then after rearrangement arr[i] should become arr[j].

        Example:
        ---------
        Input : arr[] = {4, 0, 2, 1, 3}
        Step 1: For each index i, we look at arr[i] = cur
        Step 2: We then pick element = arr[cur]
        Step 3: We store that in a temporary array 'res[i]'
        After processing all, we copy res[] back to arr[]

        Step-by-step:
        --------------
        1. Create a temporary array 'res' of same length as arr
        2. Traverse the array:
              - For every index i:
                  cur = arr[i]
                  res[i] = arr[(int)cur]
           This ensures each element in res represents arr[arr[i]]
        3. Copy all elements of res[] back into arr[]
           so that arr[i] becomes arr[arr[i]]

        Time Complexity:
        ----------------
        O(n) — Single traversal to fill res[] and one more to copy it back.

        Space Complexity:
        -----------------
        O(n) — Because of the extra array 'res[]' used.

        Example Trace:
        ---------------
        arr = {4, 0, 2, 1, 3}
        Iteration 1: i=0 → arr[0]=4 → res[0]=arr[4]=3
        Iteration 2: i=1 → arr[1]=0 → res[1]=arr[0]=4
        Iteration 3: i=2 → arr[2]=2 → res[2]=arr[2]=2
        Iteration 4: i=3 → arr[3]=1 → res[3]=arr[1]=0
        Iteration 5: i=4 → arr[4]=3 → res[4]=arr[3]=1

        Final res = {3, 4, 2, 0, 1}
        Copy res → arr = {3, 4, 2, 0, 1}
      */
    public static void arrange(long[] arr) {
        long[] res = new long[arr.length];

        for(int i = 0; i<arr.length; i++) {
            long cur = arr[i];
            long element = arr[(int)cur];
            res[i] = element;
        }

        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    // Modular Arithmatic Approach
    /*
        -----------
        1️⃣ Problem:
           We need to rearrange the array so that each element becomes arr[i] = arr[arr[i]].
           But if we directly modify arr[i], we lose the original value needed for future computation.

        2️⃣ Idea:
           Use modular arithmetic to store two values in the same index:
           - The old value (arr[i] % n)
           - The new value (arr[arr[i]] % n)
           Encode them as:
               arr[i] = arr[i] + (arr[arr[i]] % n) * n

        3️⃣ Decoding:
           After encoding all elements, we divide each element by n to extract the new values:
               arr[i] = arr[i] / n

        4️⃣ Time Complexity: O(n)
            Each element is visited twice.

        5️⃣ Space Complexity: O(1)
            In-place transformation, no extra array used.
        */

    //TODO - REVISIT - 26 Oct 2025 - important concept
    public static void arrangeOptimised(long[] arr) {
        int n = arr.length;

        // Step 1: Encode both old and new values at same index
        for (int i = 0; i < n; i++) {
            // arr[i] + (arr[arr[i]] % n) * n ensures we don’t lose original arr[i]
            arr[i] = arr[i] + (arr[(int) arr[i]] % n) * n;
        }

        // Step 2: Decode new values by dividing each element by n
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
    }

    static void print(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) {
        long[] arr = new long[]{1,0};
        arrangeOptimised(arr);
        print(arr);
        long[] arr1 = new long[]{4,0,2,1,3};
        arrangeOptimised(arr1);
        print(arr1);
    }
}
