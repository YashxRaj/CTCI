package stacksAndQueues;

import java.util.EmptyStackException;

public class MultipleStacksInOneArray {

	private int numberOfStacks;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public MultipleStacksInOneArray(int stackSize, int nOS) {
		numberOfStacks = nOS;
		stackCapacity = stackSize;
		values = new int[stackCapacity * numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	public int push(int stackNum, int value) {
		if (isFull(stackNum) && sizes[stackNum] != 0)
			throw new FullStackException();
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
		return values[indexOfTop(stackNum)];
	}

	public int pop(int stackNum) {
		if (isEmpty(stackNum))
			throw new EmptyStackException();
		int topIndex = indexOfTop(stackNum);
		sizes[stackNum]--; // values[topIndex] = 0; - safety.
		return values[topIndex];
	}

	public void printAllStacks() {
		for (int i = 0; i < numberOfStacks; i++) {
			System.out.println("\nStack Number: " + i);
			for (int j = 0; j < sizes[i]; j++)
				System.out.print(values[i * stackCapacity + j] + "\t");
		}
		System.out.println();
	}

	public void printStackNumber(int stackNum) {
		System.out.println("Printing stack number: " + stackNum);
		for (int i = (stackNum * stackCapacity); i <= indexOfTop(stackNum); i++)
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