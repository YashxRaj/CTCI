package linkedLists;

import java.util.HashSet;
import java.util.LinkedList;

public class LL1 {

	public static void removeDuplicatesNoBuffer(LinkedList<Integer> l) {
		System.out.println("Removing Duplicates without Buffer.");
		for (int i = 0; i < l.size()-1; i++) {
			for (int j = i+1; j < l.size(); j++) {
				if(l.get(i)==l.get(j)){
					l.remove(j);
					j--;
				}
					
			}
		}
	}

	public static void removeDuplicatesBuffer(LinkedList<Integer> l) {
		System.out.println("Removing Duplicates with Hashset Buffer.");
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < l.size(); i++) {
			set.add(l.get(i));
		}
		l.clear();
		for (Integer x : set)
			l.add(x);
	}

}
