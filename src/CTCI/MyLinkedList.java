package CTCI;

public class MyLinkedList {
	private static int counter;
	private Node head;

	public MyLinkedList() {
	}

	public void add(Object data) {
		if (head == null) {
			head = new Node(data);
		}
		Node temp = new Node(data);
		Node current = head;
		while (current.next != null)
			current = current.getNext();
		current.setNext(temp);
		incrementCounter();
	}

	public boolean add(Object data, int index) {
		if (head == null)
			return false;
		else if (index <= this.size()) {
			Node temp = new Node(data);
			Node current = head;
			for (int i = 0; i < index && current.getNext() != null; i++)
				current = current.getNext();
			temp.setNext(current.getNext());
			current.next = temp;
			incrementCounter();
			return true;
		} else if (index > this.size())
			return false;
		return false;
	}

	public Object get(int index) {
		if (index > this.size() || index < 0 || head == null)
			return null;
		Node current = head.getNext();
		for (int i = 0; i < index; i++) {
			if (current.getNext() == null)
				return null;
			current = current.getNext();
		}
		return current.getData();
	}

	public boolean remove(int index) {
		if (index > this.size() || index < 0)
			return false;
		Node current = head;
		if (head != null) {
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null)
					return false;
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
			decrementCounter();
			return true;
		}
		return false;
	}

	private void decrementCounter() {
		counter--;
	}

	private void incrementCounter() {
		counter++;
	}

	private int getCounter() {
		return counter;
	}

	public int size() {
		return getCounter();
	}
}
