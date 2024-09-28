package com.Colectin;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
class Emp implements Comparable<Emp> {

	public String s;
	Emp(String s){
		this.s = s;
	}
	
	@Override
	public String toString() {
		return this.s;
	}

	@Override
	public int compareTo(Emp o) {
		// TODO Auto-generated method stub
		return this.s.compareToIgnoreCase(o.s);
	}
}
public class SetCollntest {

	public static void main(String[] args) {
	// HashSet  
//	HashSet hs = new HashSet();	
//	int a=100;
//	//Integer b = new Integer(a);
//	Integer b=a;  // auto-boxing : converting primitive to object. 
//	
//	hs.add(10);		// auto-boxing : converting primitive to object. 
//	hs.add(b);
//	hs.add(10.10);
//	hs.add("Ravi");
//	hs.add(true);
//	hs.add(new Emp());
//	System.out.println(hs);
		
//	// HashSet classes methods 
//	Set ss1 = new HashSet();
//	System.out.println("Size "+ss1.size());
//	System.out.println("empty "+ss1.isEmpty());
//	ss1.add(30);
//	ss1.add(10);
//	ss1.add(60);
//	ss1.add(40);
//	ss1.add(90);
//	ss1.add(90);
//	ss1.add(70);
//	System.out.println(ss1);
//	System.out.println("Size "+ss1.size());
//	System.out.println("empty "+ss1.isEmpty());
//	System.out.println("search "+ss1.contains(10));
//	System.out.println("search "+ss1.contains(100));
//	System.out.println("search "+ss1.remove(10));
//	System.out.println("search "+ss1.remove(100));
//	System.out.println(ss1);
//	ss1.clear();
//	System.out.println("Size "+ss1.size());
//	System.out.println("empty "+ss1.isEmpty());
		
//	// LinkedHashSet 
//		Set ss1 = new LinkedHashSet();
//		System.out.println("Size "+ss1.size());
//		System.out.println("empty "+ss1.isEmpty());
//		ss1.add(30);
//		ss1.add(10);
//		ss1.add(60);
//		ss1.add(40);
//		ss1.add(90);
//		ss1.add(90);
//		ss1.add(70);
//		System.out.println(ss1);
//		System.out.println("Size "+ss1.size());
//		System.out.println("empty "+ss1.isEmpty());
//		System.out.println("search "+ss1.contains(10));
//		System.out.println("search "+ss1.contains(100));
//		System.out.println("search "+ss1.remove(10));
//		System.out.println("search "+ss1.remove(100));
//		System.out.println(ss1);
//		ss1.clear();
//		System.out.println("Size "+ss1.size());
//		System.out.println("empty "+ss1.isEmpty());
		
		// TreeSet 
		SortedSet<Emp> sss = new TreeSet<Emp>();
		sss.add(new Emp("A"));
		sss.add(new Emp("V"));
		sss.add(new Emp("D"));
		sss.add(new Emp("E"));
		sss.add(new Emp("B"));
//		SortedSet ss1 = new TreeSet();
//		System.out.println("Size "+ss1.size());
//		System.out.println("empty "+ss1.isEmpty());
//		ss1.add(30);
//		ss1.add(10);
//		ss1.add(60);
//		ss1.add(40);
//		//ss1.add("Ravi");
//		ss1.add(90);
//		ss1.add(90);
//		ss1.add(70);
//		System.out.println(" head set "+ss1.headSet(40));
//		System.out.println(" tail set "+ss1.tailSet(40));
//		System.out.println(ss1);
//		System.out.println("Size "+ss1.size());
//		System.out.println("empty "+ss1.isEmpty());
//		System.out.println("search "+ss1.contains(10));
//		System.out.println("search "+ss1.contains(100));
//		System.out.println("search "+ss1.remove(10));
//		System.out.println("search "+ss1.remove(100));
//		System.out.println(ss1);
//		ss1.clear();
//		System.out.println("Size "+ss1.size());
//		System.out.println("empty "+ss1.isEmpty());
		System.out.println(sss);
	}

}