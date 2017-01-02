package stacksAndQueues;

public class SetOfStacks extends Stack<Integer> {
	int stackSize;
	Stack<Integer> s;
	public SetOfStacks(int stackCapacity) {
		stackSize = stackCapacity;
		s = new Stack<Integer>();
	}
	
}
