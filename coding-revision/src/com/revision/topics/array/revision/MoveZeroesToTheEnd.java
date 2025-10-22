package com.revision.topics.array.revision;

//VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTYwNA%3D%3D
//PL - https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1
public class MoveZeroesToTheEnd {

    /**
     *  Initialise counter variable as 0;
     *  when you are traversing check whether the element is non-zero element
     *  if it is a non-zero element move it to arr of count position and increment the count
     *  at the end run the loop until count is less than arr length and make all the element as zero
     * @param arr
     */
    static void pushZerosToEnd(int[] arr) {
       int count = 0;
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }

        while (count < arr.length) {
            arr[count] = 0;
            count++;
        }

        print(arr);
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        pushZerosToEnd(new int[]{1, 2, 0, 4, 3, 0, 5, 0});
        pushZerosToEnd(new int[]{10, 20, 30});
        pushZerosToEnd(new int[]{0, 0});
        pushZerosToEnd(new int[]{8, 5, 0, 10, 0, 20});
        pushZerosToEnd(new int[]{8, 0, 0, 10, 0});
        pushZerosToEnd(new int[]{8});
        pushZerosToEnd(new int[]{0});
        pushZerosToEnd(new int[]{10, 0});
        pushZerosToEnd(new int[]{0, 10});
    }
}
