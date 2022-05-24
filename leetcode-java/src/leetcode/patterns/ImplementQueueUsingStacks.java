package leetcode.patterns;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {

    // 1 -> 2 -> 3
    // 3 -> 2 -> 1
    class MyQueue {
        private Deque<Integer> stack = new ArrayDeque<>();

        public MyQueue() {

        }

        public void push(int x) {
            Deque<Integer> newStack = new ArrayDeque<>();
            stack.add(x);
            while (!stack.isEmpty()){
                newStack.add(stack.pollFirst());
            }
            this.stack = newStack;
        }

        public int pop() {
            return stack.pollFirst();
        }

        public int peek() {
            return stack.peekFirst();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
