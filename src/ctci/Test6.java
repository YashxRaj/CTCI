package ctci;

import java.util.HashMap;
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] s1 = s.nextLine().trim().split(",");
		String[] s2 = s.nextLine().trim().split(",");
		System.out.println("States1: " + s1.length);
		System.out.println("States2: " + s2.length);
		s.close();
		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		for (String state : s1)
			hm1.put(state, hm1.containsKey(state) ? hm1.get(state) + 1 : 1);
		for (String state : s2)
			hm1.put(state, hm1.containsKey(state) ? hm1.get(state) + 1 : 1);
		int count = 0;
		for (String state : hm1.keySet())
			if (hm1.get(state) > 1) {
				count++;
				System.out.print(state + ",");
			}
		System.out.println(count);
		// for(String state : hm1.keySet()) System.out.print(state+" - " +
		// hm1.get(state) + ", ");
	}
}
