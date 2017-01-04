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
		if (index >= stacks.size()) {
			System.out.println("Number of stacks present < given index. Try again.");
			return null;
		} else {
			T item = (T) stacks.get(index).pop();
			if (stacks.get(stacks.size() - 1).isEmpty())
				stacks.remove(stacks.get(index));
			else
				shiftLeft(index + 1);
			return item;
		}
	}

	private void shiftLeft(int i) {
		while (i < stacks.size()) {
			ArrayList<T> temp = new ArrayList<T>();
			while (stacks.get(i).currentSize != 0)
				temp.add((T) stacks.get(i).pop());
			stacks.get(i - 1).push(temp.remove(temp.size() - 1));
			if (temp.isEmpty())
				stacks.remove(i);
			else {
				Collections.reverse(temp);
				for (T t : temp)
					stacks.get(i).push(t);
			}
			i++;
		}
	}
}
