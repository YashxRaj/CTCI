package gfgMicrosoft;

public class BTisBST {

	public static class Node{
		String name;
		int data;
		Node left, right;
		public Node(){
			super();
		}
		public Node(String name, int data){
			super();
			this.name = name;
			this.data = data;
		}
		public Node(String name, int data, Node left, Node right){
			super();
			this.name = name;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public Node getLeft(){
			return this.left;
		}
		public Node getRight(){
			return this.right;
		}
	}
	
	private static int value (Node n){
		return n.data;
	}
	public static void main(String[] args) {
		Node root = new Node("root", 0);
		System.out.println(checkBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	
	private static boolean checkBST(Node n, int min, int max) {
		if (n == null)
			return true;
		if (value(n) < min || value(n) > max)
			return false;
		else
			return (checkBST(n.getLeft(), min, value(n) - 1) && checkBST(n.getRight(), value(n), max));
	}
}
