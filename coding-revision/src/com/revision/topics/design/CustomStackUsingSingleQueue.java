package com.revision.topics.design;

import java.util.LinkedList;
import java.util.Queue;

// PL - https://leetcode.com/problems/implement-stack-using-queues/
public class CustomStackUsingSingleQueue {

    Queue<Integer> queue;

    public CustomStackUsingSingleQueue() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int n = queue.size();
        for (int i = 0; i < n-1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        CustomStackUsingSingleQueue myStack = new CustomStackUsingSingleQueue();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}
