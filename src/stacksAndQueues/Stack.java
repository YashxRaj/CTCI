package stacksAndQueues;

import java.util.EmptyStackException;

public class Stack<T> {
	int stackSize, currentSize;

	public Stack(int stackCapacity) {
		stackSize = stackCapacity;
		currentSize = 0;
	}

	private static class StackNode<T> {
		private T data;
		StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;

	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		currentSize--;
		return item;
	}

	public void push(T item) {
		if (this.isFull())
			throw new FullStackException();
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
		currentSize++;
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public boolean isFull() {
		return currentSize == stackSize;
	}
}
