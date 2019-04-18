package Prototype;

import java.util.ArrayList;
import java.util.LinkedList;

public class s {
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list.add(1);
		list1.add(list);
		list.add(2);
		list2.add(list1);
		list1.add(list);
		list.add(3);
		System.out.println(list2.toString());
		
		
		
	}

}
