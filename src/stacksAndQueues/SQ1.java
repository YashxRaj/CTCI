package stacksAndQueues;

public class SQ1 {

	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public SQ1(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	public void push(int stackNum, int value) {
		if (isFull(stackNum)) {
			System.out.println("Stack is full!");
			return;
		}
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	public int pop(int stackNum) {
		if (isEmpty(stackNum)) {
			System.out.println("Stack is empty!");
			return -1;
		}
		int topIndex = indexOfTop(stackNum), value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}

	public void printStackNumber(int stackNum) {
		System.out.println("Printing stack number: " + stackNum);
		for (int i = (indexOfTop(stackNum) - sizes[stackNum] + 1); i <= indexOfTop(stackNum); i++)
			System.out.print(values[i] + "\t");
		System.out.println();
	}

	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity, size = sizes[stackNum];
		return offset + size - 1;
	}
}