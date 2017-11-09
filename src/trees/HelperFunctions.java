package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@SuppressWarnings({ "unused", "rawtypes" })
public class HelperFunctions {

	protected static int randomNumber() {
		int random = (int) (Math.random() * 20);
		return random;
	}

	protected static int randomTreeSize() {
		int random = 0;
		do {
			random = randomNumber();
		} while (random < 8);
		return random;
	}

	protected static char[] makeCharArray(int size) {
		char[] ch = new char[size];
		char a = 'A';
		for (int i = 0; i < size; i++)
			ch[i] = a++;
		return ch;
	}

	protected static int[] makeIntArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = randomNumber();
		return array;
	}

	protected static String[] makeStringArray(int size) {
		String[] array = new String[size];
		for (int i = 0; i < size; i++)
			array[i] = Integer.toString(i);
		return array;
	}

	protected static void printIntArray(int[] buffer, int index) {
		for (int i = 0; i < index; i++)
			System.out.print(buffer[i] + " ");
		System.out.println();
	}

	protected static void printCharArray(char[] path, int index) {
		for (int i = 0; i < index; i++)
			System.out.print(path[i] + " ");
		System.out.println();
	}

	protected static void printVector(Vector<Node> vector) {
		for (Node n : vector)
			System.out.print(n + " ");
		System.out.println();
	}

	// Prints graphical tree to console.
	protected static void printTree(Node root) {
		List<List<String>> lines = new ArrayList<List<String>>();
		List<Node> level = new ArrayList<Node>();
		List<Node> next = new ArrayList<Node>();
		level.add(root);
		int nn = 1, widest = 0;
		while (nn != 0) {
			List<String> line = new ArrayList<String>();
			nn = 0;
			for (Node n : level) {
				if (n == null) {
					line.add(null);
					next.add(null);
					next.add(null);
				} else {
					String aa = String.valueOf(n.data);
					line.add(aa);
					if (aa.length() > widest)
						widest = aa.length();
					next.add(n.left);
					next.add(n.right);
					if (n.left != null)
						nn++;
					if (n.right != null)
						nn++;
				}
			}

			if (widest % 2 == 1)
				widest++;
			lines.add(line);
			List<Node> tmp = level;
			level = next;
			next = tmp;
			next.clear();
		}
		int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
		for (int i = 0; i < lines.size(); i++) {
			List<String> line = lines.get(i);
			int hpw = (int) Math.floor(perpiece / 2f) - 1;
			if (i > 0) {
				for (int j = 0; j < line.size(); j++) {
					char c = ' ';
					if (j % 2 == 1) {
						if (line.get(j - 1) != null)
							c = (line.get(j) != null) ? '^' : '/';
						else if (j < line.size() && line.get(j) != null)
							c = '\\';
					}
					System.out.print(c);
					if (line.get(j) == null)
						for (int k = 0; k < perpiece - 1; k++)
							System.out.print(" ");
					else {
						for (int k = 0; k < hpw; k++)
							System.out.print(j % 2 == 0 ? " " : "_");
						System.out.print(" ");
						for (int k = 0; k < hpw; k++)
							System.out.print(j % 2 == 0 ? "_" : " ");
					}
				}
				System.out.println();
			}
			for (int j = 0; j < line.size(); j++) {
				String f = line.get(j);
				if (f == null)
					f = "";
				int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
				int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);
				for (int k = 0; k < gap1; k++)
					System.out.print(" ");
				System.out.print(f);
				for (int k = 0; k < gap2; k++)
					System.out.print(" ");
			}
			System.out.println();
			perpiece /= 2;
		}
	}

	protected static char randomChar(char[] rootChar) {
		return rootChar[(int) (Math.random() * (rootChar.length - 1))];
	}

	protected static char otherRandomChar(char[] rootChar, char x) {
		int random;
		do
			random = (int) (Math.random() * (rootChar.length - 1));
		while (rootChar[random] == x);
		return rootChar[random];
	}
}
