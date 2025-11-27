package com.revision.topics.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/k-closest-points-to-origin/
// VL - https://www.youtube.com/watch?v=XC4EotTewro&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=8
public class KClosestPointToOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<CustomPair> pq =
                new PriorityQueue<>((o1, o2) -> Double.compare(o2.sqrt, o1.sqrt));

        for (int i = 0; i < points.length; i++) {
            pq.add(new CustomPair(new int[]{points[i][0], points[i][1]}, distance(points[i][0], points[i][1])));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[pq.size()][2];

        int i = 0;
        while (!pq.isEmpty()) {
            res[i] = pq.poll().arr;
            i++;
        }
        return res;
    }

    private static int distance(int x, int y) {
        return x*x + y*y;
    }

    static void print(int[][] origin) {
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[i].length; j++) {
                System.out.println(origin[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        int[][] res = kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        print(res);
    }
}

class CustomPair {
    int[] arr;
    double sqrt;

    public CustomPair(int[] arr, double sqrt) {
        this.arr = arr;
        this.sqrt = sqrt;
    }
}
