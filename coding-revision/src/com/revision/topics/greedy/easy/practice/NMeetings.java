package com.revision.topics.greedy.easy.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetings {

    static class Meetings {
        int start;
        int end;

        public Meetings(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int maxMeetings(int start[], int end[]) {
        List<Meetings> list = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            list.add(new Meetings(start[i], end[i]));
        }

        list.sort(Comparator.comparingInt(a -> a.end));

        int currEnd = 0;
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (currEnd == 0 || currEnd < list.get(i).start) {
                count++;
                currEnd = list.get(i).end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}));
        System.out.println(maxMeetings(new int[]{10, 12, 20}, new int[]{20, 25, 30}));
        System.out.println(maxMeetings(new int[]{1, 2}, new int[]{100, 99}));
    }
}
