package trees;

public class Main {

	public static void main(String[] args) {

		int stringRootSize = HelperFunctions.randomTreeSize();
		String[] rootString = HelperFunctions.makeStringArray(stringRootSize);
		Node stringRoot = ConstructionsAndConversions.makeStringBinaryTree(rootString);

		int charRootSize = HelperFunctions.randomTreeSize();
		char[] rootChar = HelperFunctions.makeCharArray(charRootSize);
		Node<Character> charRoot = ConstructionsAndConversions.makeCharBinaryTree(rootChar);

		int intRootSize = HelperFunctions.randomTreeSize();
		int[] rootInt = HelperFunctions.makeIntArray(intRootSize);
		Node<Integer> intRoot = ConstructionsAndConversions.makeIntBinaryTree(rootInt);

	}

}
