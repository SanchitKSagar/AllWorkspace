package com.abstrac;

abstract class Abs{
	abstract void test();
	Abs(){
		System.out.println("Abstract");
	}
}

class A extends Abs{
	void test() {
		System.out.println("A");
	}
}
public class TestAbs {

	public static void main(String[] args)
	{
		A a = new A();
		a.test();
	}
}
