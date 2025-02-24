package ex4_iterator;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class EnumerationEx1 {
	public static void main(String[] args) {
//        List<Object> fruits = new Vector<>();
        Vector<Object> fruits = new Vector<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Mango");
        //elements() : Vector 클래스의 멤버. 
        Enumeration<Object> e = fruits.elements();
        System.out.println("과일 목록:");
        print(e);
	}
	private static void print(Enumeration<Object> e) {
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement()+",");
        }
        System.out.println();
	}
}
