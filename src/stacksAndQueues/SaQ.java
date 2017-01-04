package stacksAndQueues;

import java.util.Scanner;

public class SaQ {

	public static void main(String[] args) {
		// MultipleStacksInOneArray(); // Read solution on making flexible stacks
		// StackWithMin();
		// SetOfStacks();
	}

	private static void SetOfStacks() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter stack size and number of values to store: ");
		int size = s.nextInt();
		int elements = s.nextInt();
		SetOfStacks<Integer> sos = new SetOfStacks<Integer>(size);
		for (int i = 0; i < elements; i++) {
			System.out.print("-> " + sos.push((int) (Math.random() * 10)) + " | ");
			if (chance())
				System.out.println("<- " + sos.pop());
		}
		sos.print();
		for (int i = 0; i < size; i++) {
			int x = randomNumberBetweenZeroAnd((int) (elements / size));
			System.out.println("[" + x + "]" + " <- " + sos.popAt(x));
		}
		sos.print();
	}

	private static void StackWithMin() {
		int stackSize = 7 + (int) (Math.random() * 5);
		StackWithMin sm = new StackWithMin(stackSize);
		for (int i = 0; i < stackSize; i++) {
			System.out.print("-> " + sm.push(randomNumberBetweenZeroAnd(10)) + " ");
			if (i > 3 && chance())
				System.out.print("<- " + sm.pop() + " ");
			System.out.println(sm.min() == Integer.MAX_VALUE ? " Stack is empty!" : " Min: " + sm.min());
		}
	}

	private static boolean chance() {
		return Math.random() <= 0.5;
	}

	private static void MultipleStacksInOneArray() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of a stack and number of stacks: ");
		int stackSize = s.nextInt();
		int numberOfStacks = s.nextInt();
		MultipleStacksInOneArray stack = new MultipleStacksInOneArray(stackSize, numberOfStacks);
		for (int i = 0, k = 0; i < (stackSize * numberOfStacks); i++, k = k == numberOfStacks - 1 ? 0 : k + 1) {
			System.out.print("[" + k + "]" + " -> " + stack.push(k, randomNumberBetweenZeroAnd(10)) + " | ");
			if (chance())
				System.out.println("[" + k + "]" + " <- " + stack.pop(k));
		}
		stack.printAllStacks();
	}

	private static int randomNumberBetweenZeroAnd(int range) {
		return ((int) (Math.random() * range));
	}
}
