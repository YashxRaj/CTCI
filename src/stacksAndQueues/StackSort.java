package stacksAndQueues;

import java.util.ArrayList;

public class StackSort extends Stack<Integer> {
	private Stack<Integer> s, temp;

	public StackSort(int len) {
		s = new Stack<Integer>(len);
		temp = new Stack<Integer>(len);
	}

	public Integer push(int t) {
		if (s.isEmpty())
			return s.push(t);
		while (s.currentSize > 0 && t > s.peek())
			temp.push(s.pop());
		s.push(t);
		while (!temp.isEmpty())
			s.push(temp.pop());
		return t;
	}

	public Integer pop() {
		return s.pop();
	}

	public Integer peek() {
		return s.peek();
	}

	public boolean isEmpty() {
		return s.isEmpty();
	}

	public void print() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		while (!s.isEmpty())
			a.add(s.pop());
		for (int x : a)
			System.out.print(s.push(x) + "\t");
		System.out.println();
	}
}
