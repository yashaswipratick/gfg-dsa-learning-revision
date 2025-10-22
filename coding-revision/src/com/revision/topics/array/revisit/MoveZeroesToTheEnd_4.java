package com.revision.topics.array.revisit;

//VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTYwNA%3D%3D
//PL - https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1
public class MoveZeroesToTheEnd_4 {

    // TODO - REVISIT - 10 Oct 2025
    static void pushZerosToEnd(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && j > -1) {
                arr[j] = arr[i];
                j++;
            } else if (j < 0 && arr[i] == 0){
                j = i;
            }
        }

        while (j > 0 && j < arr.length) {
            arr[j] = 0;
            j++;
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
