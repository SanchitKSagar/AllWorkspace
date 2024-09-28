package com.polymorphism;

class Car {
	void milage()
	{
		System.out.println("45mph");
	}
}
class Hundai extends Car{
	@Override
	void milage()
	{
		System.out.println("40mph");
	}
}

public class Poly {

	public static void main(String []args)
	{
		Car c = new Hundai();
		c.milage(); // Hundai milage
		
	}
}
