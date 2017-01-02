package stacksAndQueues;

public class StackWithMin extends Stack<Integer> {
	Stack<Integer> s;

	public StackWithMin() {
		s = new Stack<Integer>();
	}

	public void push(int value) {
		if (value <= min())
			s.push(value);
		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min())
			s.pop();
		return value;
	}

	public int min() {
		if (s.isEmpty())
			return Integer.MAX_VALUE;
		else
			return s.peek();
	}
}
// Alternate Solution - Holds a node for each value in stack. Too much space.
// class StackWithMin2 extends Stack<NodeWithMin> {
// public void push(int value) {
// int newMin = Math.min(value, min());
// super.push(new NodeWithMin(value, newMin));
// }
//
// public int min() {
// if (this.isEmpty())
// return Integer.MAX_VALUE;
// else
// return peek().min;
// }
// }
//
// class NodeWithMin {
// public int value, min;
//
// public NodeWithMin(int v, int min) {
// value = v;
// this.min = min;
// }
// }
