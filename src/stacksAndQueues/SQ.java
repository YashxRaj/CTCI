package stacksAndQueues;

import java.util.Scanner;

public class SQ {

	public static void main(String[] args) {
		// SQ1(); // Read solution on how to implement flexible stacks
		// SQ2();
	}

	
	private static void SQ2() {

	}


	private static void SQ1() {
		int stackSize = (int) (Math.random() * 10);
		SQ1 stack = new SQ1(stackSize);
		for (int i = 0, k = 0; i < (stackSize * 3); i++) {
			stack.push(k, randomNumberBetweenZeroAnd(10));
			k++;
			if (k == 3)
				k = 0;
		}
		for (int i = 0; i < 3; i++)
			stack.printStackNumber(i);
	}

	private static int randomNumberBetweenZeroAnd(int range) {
		return ((int) (Math.random() * range));
	}
}
