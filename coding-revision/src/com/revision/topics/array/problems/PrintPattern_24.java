package com.revision.topics.array.problems;

import java.util.ArrayList;
import java.util.List;

// VL - https://www.youtube.com/watch?v=p3k27y0W6mQ
// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/print-pattern3549
public class PrintPattern_24 {

    //TODO - REVISIT in 3-5 days
    public static List<Integer> printPattern(int n) {
        List<Integer> result = new ArrayList<>();
        generatePattern(n, n, result);
        return result;
    }

    private static void generatePattern(int current, int original, List<Integer> result) {
        result.add(current);

        // Base condition: if current is less than or equal to 0, stop decreasing
        if (current <= 0) {
            return;
        }

        // Recursive call: subtract 5
        generatePattern(current - 5, original, result);

        // After recursion unwinds: simulate the reverse path
        result.add(current);
    }

    public static void main(String[] args) {
        System.out.println(printPattern(10));    // [10, 5, 0, 5, 10]
        System.out.println(printPattern(-16));   // [-16]
        System.out.println(printPattern(1));     // [1, -4, 1]
        System.out.println(printPattern(0));     // [0]
        System.out.println(printPattern(5));     // [5, 0, 5]
        System.out.println(printPattern(15));    // [15, 10, 5, 0, 5, 10, 15]
    }
}
