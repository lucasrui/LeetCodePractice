package com.tuilu;

import java.util.Stack;

/**
 * Created by Administrator on 2015/12/30.
 */
public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int element) {
        if(!stack1.empty()){
            stack2.push(element);
        }else{
            stack1.push(element);
        }
    }

    public int pop() {
        int result=0;
        if(!stack1.empty())
            result = stack1.pop();
        if(stack1.empty()){
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
        return result;

    }

    public int top() {
        return stack1.peek();
    }
}
