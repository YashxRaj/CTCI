package stacksAndQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;

public class SetOfStacks<T> extends Stack<T> {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	int stackSize;

	public SetOfStacks(int stackCapacity) {
		stackSize = stackCapacity;
		Stack<T> stack = new Stack<T>(stackSize);
		stacks.add(stack);
	}

	public T push(T item) {
		Stack<T> last = getLastStack();
		if (last != null && !last.isFull())
			last.push(item);
		else {
			Stack<T> stack = new Stack<T>(stackSize);
			stacks.add(stack);
			stack.push(item);
		}
		return item;
	}

	public T pop() {
		Stack<T> last = getLastStack();
		if (last == null)
			throw new EmptyStackException();
		T item = last.pop();
		if (last.currentSize == 0)
			stacks.remove(stacks.size() - 1);
		return item;
	}

	private Stack<T> getLastStack() {
		return stacks.size() == 0 ? null : stacks.get(stacks.size() - 1);
	}

	public void print() {
		System.out.println("\nPrinting the set of stacks:");
		int i = 0;
		for (Stack<T> s : stacks) {
			System.out.println("Stack number: " + i++);
			ArrayList<T> temp = new ArrayList<T>();
			while (s.currentSize != 0) {
				T item = s.pop();
				temp.add(item);
			}
			Collections.reverse(temp);
			for (T t : temp) {
				System.out.print(t + "\t");
				s.push(t);
			}
			System.out.println();
		}
	}

	public T popAt(int index) {
		Stack<T> s;
		try {
			s = stacks.get(index);
			T item = s.pop();
			return item;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Number of stacks present < given index. Try again.");
		}
		return null;
	}
}
