package ctci;

import java.util.HashMap;

public class test2 {

	public static void main(String[] args) {
		int a = 80;
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toHexString(a));
		System.out.println(Integer.toOctalString(a));
		System.out.println(Integer.toString(a));
		System.out.println(Integer.toString(a, 2));
		System.out.println(Integer.toString(a, 8));
		System.out.println(Integer.toString(a, 16));
		System.out.println(Integer.toString(a, 64));
	}
}
