package com.revision.topics.design;

import java.util.LinkedList;
import java.util.Queue;

// PL - https://leetcode.com/problems/implement-stack-using-queues/
public class CustomStackUsingTwoQueue {

        Queue<Integer> queue1;
        Queue<Integer> queue2;
        int topElement;

        public CustomStackUsingTwoQueue() {
            this.queue1 = new LinkedList<>();
            this.queue2 = new LinkedList<>();
        }

        public void push(int x) {
            topElement = x;
            queue1.add(x);
            System.out.println(queue1);
        }

        public int pop() {
            int lastElement = 0;
            while (!queue1.isEmpty()) {
                lastElement = queue1.poll();
                queue2.add(lastElement);
            }
            System.out.println(queue2);
            while (!queue2.isEmpty()) {
                Integer poll = queue2.poll();
                if (poll != lastElement) {
                    topElement = poll;
                    queue1.add(poll);
                }
            }
            return lastElement;
        }

        public int top() {
            return topElement;
        }

        public boolean empty() {
            return queue1.isEmpty();
        }

    public static void main(String[] args) {
        CustomStackUsingTwoQueue myStack = new CustomStackUsingTwoQueue();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}
