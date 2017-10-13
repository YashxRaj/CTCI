package gfgMicrosoft;

public class LeastCommonAncestor {

	public static class Node {
		String name;
		int data;
		Node left, right;

		public Node() {
			super();
		}

		public Node(String name, int data) {
			super();
			this.name = name;
			this.data = data;
		}

		public Node(String name, int data, Node left, Node right) {
			super();
			this.name = name;
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node getLeft() {
			return this.left;
		}

		public Node getRight() {
			return this.right;
		}
	}
	
	
}
