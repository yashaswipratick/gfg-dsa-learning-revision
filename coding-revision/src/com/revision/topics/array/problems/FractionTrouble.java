package com.revision.topics.array.problems;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/fraction-trouble3803
// VL - https://www.youtube.com/watch?v=niUkBbIU_0I
public class FractionTrouble {

    //TODO - REVISIT - 12 Oct 2025
    public static int[] LargestFraction(int n, int d) {
        // code here
        int num = -1;
        int den = 1;

        for(int q = 10000; q>1; q--) {
            int p = (n * q -1)/d;
            if((gcd(p,q) == 1) && (num*q<=den*p)) {
                num = p;
                den = q;
            }
        }
        return new int[]{num, den};
    }

    private static int gcd(int n1, int n2) {
        if(n2 == 0) {
            return n1;
        }
        return gcd(n2,n1%n2);
    }

    public static void main(String[] args) {
        System.out.println(LargestFraction(1, 8));
        System.out.println(LargestFraction(2, 53));
    }
}
