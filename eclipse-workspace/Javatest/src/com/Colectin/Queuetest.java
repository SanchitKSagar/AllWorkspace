package com.Colectin;

import java.util.PriorityQueue;
import java.util.Queue;

class Test{
	int a;

	public Test(int a) {
		super();
		this.a = a;
	}

	@Override
	public String toString() {
		return "Test [a=" + a + "]";
	}
	
}

public class Queuetest {

	public static void main(String[] args)
	{
		Queue<Integer> q = new PriorityQueue<Integer>();
		q.add(7);
		q.add(2);
		q.add(45);
		q.add(32);
		q.add(12);
		System.out.println(q);
		
		
	}
}
