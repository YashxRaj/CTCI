package treesAndGraphs;

public class CustomTree {

	CustomTreeNode root = null;

	public CustomTree() {
		super();
	}

	public CustomTreeNode getRoot() {
		return root;
	}

	public void setRoot(int x) {
		this.root = new CustomTreeNode(Integer.toString(x));
	}

	public CustomTreeNode insert(int a, String dir) {
		if (this.root == null) {
			this.root = new CustomTreeNode(Integer.toString(a));
			return root;
		}
		if (dir == null) {
			System.out.println("No directions were given.");
			return null;
		}
		CustomTreeNode temp = new CustomTreeNode(Integer.toString(a)), t = root;
		char[] c = dir.toCharArray();
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == 'l') {
				int leftc = t.getLeftCount();
				leftc++;
				t.setLeftCount(leftc);
				t = t.getLeft();
			} else if (c[i] == 'r') {
				int rightc = t.getRightCount();
				rightc++;
				t.setRightCount(rightc);
				t = t.getRight();
			} else {
				System.out.println("Error : Could not parse string Dir.");
				return null;
			}
		}
		if (c[c.length - 1] == 'l'){
			int leftc = t.getLeftCount();
			leftc++;
			t.setLeftCount(leftc);
			t.setLeft(temp);			
		}
		else if (c[c.length - 1] == 'r'){
			int rightc = t.getRightCount();
			rightc++;
			t.setRightCount(rightc);
			t.setRight(temp);
		}
		else
			System.out.println("Error : Could not parse string Dir.");
		return temp;
	}

	public boolean find(int a) {
		return false;
	}

	public CustomTreeNode delete(int a) {
		
		return null;
	}

	public CustomTreeNode randomNode() {
		
		return null;
	}

}
