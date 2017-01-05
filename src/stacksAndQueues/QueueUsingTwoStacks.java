package stacksAndQueues;

import java.util.ArrayList;
import java.util.Collections;

public class QueueUsingTwoStacks<T> extends Stack<T> {
	private Stack<T> pushStack, popStack;

	public QueueUsingTwoStacks() {
		pushStack = new Stack<T>();
		popStack = new Stack<T>();
	}

	public T push(T t) {
		if (pushStack.isEmpty())
			transfer(pushStack, true);
		return pushStack.push(t);
	}

	public T pop() {
		if (popStack.isEmpty())
			transfer(popStack, false);
		return popStack.pop();
	}

	private void transfer(Stack<T> push, boolean flag) {
		if (flag)
			while (!popStack.isEmpty())
				pushStack.push(popStack.pop());
		if (!flag)
			while (!pushStack.isEmpty())
				popStack.push(pushStack.pop());
	}

	public T peek() {
		if (popStack.isEmpty())
			transfer(popStack, false);
		return popStack.peek();
	}

	public void print() {
		if (pushStack.isEmpty())
			while (!popStack.isEmpty())
				System.out.print(pushStack.push(popStack.pop()) + "\t");
		else {
			ArrayList<T> a = new ArrayList<T>();
			while (!pushStack.isEmpty())
				a.add(pushStack.pop());
			Collections.reverse(a);
			for (T t : a)
				System.out.print(pushStack.push(t) + "\t");
		}
	}

	public int size() {
		return pushStack.currentSize == 0 ? popStack.currentSize : pushStack.currentSize;
	}
}
