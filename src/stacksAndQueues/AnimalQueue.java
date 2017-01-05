package stacksAndQueues;

import java.util.LinkedList;

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;

	public void enqueue(Animal a) {
		a.setOrder(order++);
		if (a instanceof Dog)
			dogs.addLast((Dog) a);
		else if (a instanceof Cat)
			cats.addLast((Cat) a);
	}

	public Animal dequeueAny() {
		return dogs.size() == 0 ? dequeueCat()
				: (cats.size() == 0 ? dequeueDog()
						: dogs.peek().isOlderThan(cats.peek()) == true ? dequeueDog() : dequeueCat());
	}

	public Dog dequeueDog() {
		return dogs.poll();
	}

	public Cat dequeueCat() {
		return cats.poll();
	}
}
