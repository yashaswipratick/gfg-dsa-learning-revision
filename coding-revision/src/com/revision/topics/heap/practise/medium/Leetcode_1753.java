package com.revision.topics.heap.practise.medium;

import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/maximum-score-from-removing-stones/
public class Leetcode_1753 {

    public static int maximumScore(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.sum, o1.sum)));
        insert(pq, a, b, c);
        int score = 0;

        while ((a > 0 && b > 0) || (a > 0 && c > 0) || (b > 0 && c > 0)) {
            Pair poll = pq.poll();
            if (poll.a > 0 && poll.b > 0) {
                poll.a--;
                poll.b--;
                int sum = poll.a + poll.b;
                if (poll.state == 1) {
                    a--;
                    b--;
                    insert(pq, a, b, c);
                } else if (poll.state == 2) {
                    b--;
                    c--;
                    insert(pq, a, b, c);
                } else {
                    a--;
                    c--;
                    insert(pq, a, b, c);
                }
                score++;
            }
        }
        return score;
    }

    private static void insert(PriorityQueue<Pair> pq, int a, int b, int c) {
        pq.clear();
        pq.add(new Pair(a, b, (a + b), 1));
        pq.add(new Pair(b, c, (b + c), 2));
        pq.add(new Pair(a, c, (a + c), 3));
    }

    static class Pair {
        int a;
        int b;
        int sum;
        int state;

        public Pair(int a, int b, int sum, int state) {
            this.a = a;
            this.b = b;
            this.sum = sum;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        System.out.println(maximumScore(2, 4, 6));
        System.out.println(maximumScore(4, 4, 6));
        System.out.println(maximumScore(1, 8, 8));
    }
}
