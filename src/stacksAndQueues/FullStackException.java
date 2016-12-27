package stacksAndQueues;

public class FullStackException extends Exception {

	public FullStackException() {
		this("Stack is full!");
	}

	public FullStackException(String exception) {
		super(exception);
	}
}
