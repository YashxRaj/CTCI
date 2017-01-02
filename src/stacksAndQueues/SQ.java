package stacksAndQueues;

public class SQ {

	public static void main(String[] args) {
		// SQ1(); // Read solution on how to implement flexible stacks
		// SQ2();
		
	}

	private static void SQ2() {
		StackWithMin sm = new StackWithMin();
		int stackSize = 5 + (int) (Math.random() * 5);
		for (int i = 0; i < stackSize; i++) {
			int ran = (int) (Math.random() * 8);
			sm.push(randomNumberBetweenZeroAnd(10));
			System.out.print("Pushed: " + sm.peek() + " --- ");
			if (i > 3) {
				for (int j = 0; j < ran; j++)
					if (chance()) {
						System.out.print(sm.min() == Integer.MAX_VALUE ? "Stack is empty!" : "Min: " + sm.min());
						System.out.print(" Popped: " + sm.pop() + " --- ");
					}
			}
			System.out.println(sm.min() == Integer.MAX_VALUE ? "Stack is empty!" : "Min: " + sm.min());
		}
	}

	private static boolean chance() {
		return Math.random() <= 0.5;
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
