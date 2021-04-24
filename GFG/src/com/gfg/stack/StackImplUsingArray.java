package com.gfg.stack;

import java.util.Arrays;

public class StackImplUsingArray {
	int[] stack;
	int capacity;
	int top;
	public StackImplUsingArray(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
		top = -1;
	}
	
	public int size() {
		return top+1;
	}
	
	public void push(int data) {
		top++;
		stack[top] = data;
	}
	
	public int pop() {
		int item = stack[top];
		top--;
		return item;
	}
	
	public int peek() {
		if(top == -1)
			return -1;
		return stack[top];
	}
	
	public boolean isEmpty() {
		return (top == 0);
	}
	
	public static void main(String[] args) {
		StackImplUsingArray myStack = new StackImplUsingArray(3);
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		System.out.println(myStack.peek());
		System.out.println(myStack.size());
		
		myStack.pop();
		System.out.println(myStack.size());
		myStack.pop();
		myStack.pop();
		System.out.println(myStack.isEmpty());
		myStack.push(40);
		System.out.println(myStack.isEmpty());
	}
	
}
