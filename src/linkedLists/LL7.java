package linkedLists;

public class LL7 {

	public static void checkIntersection(Node one, Node two) {
		Result r1 = getLengthAndTail(one);
		Result r2 = getLengthAndTail(two);
		if (r1.tail != r2.tail) {
			System.out.println("They do not intersect.");
			return;
		} else {
			Node shorter = r1.size < r2.size ? one : two, longer = r1.size < r2.size ? two : one;
			longer = getKthNode(longer, Math.abs(r1.size - r2.size));
			LL.printLL(findIntersection(longer, shorter), "Intersected linked list:");
		}

	}

	private static Node findIntersection(Node longer, Node shorter) {
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		return longer;
	}

	private static Node getKthNode(Node longer, int d) {
		while (d > 0) {
			longer = longer.next;
			d--;
		}
		return longer;
	}

	private static Result getLengthAndTail(Node n) {
		Node temp = n;
		int i;
		for (i = 0; temp.next != null; i++) {
			temp = temp.next;
		}
		return new Result(temp, i);
	}

	// This is needed in order to return the length and last node of the LL.
	static class Result {
		Node tail;
		int size;

		public Result(Node r, int l) {
			tail = r;
			size = l;
		}
	}

}
