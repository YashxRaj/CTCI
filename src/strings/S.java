package strings;

import java.util.Scanner;

public class S {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// S1(s);
		// S2(s);
		// S3(s);
		// S4(s);
		// S5(s);
		// S6(s);
		// S7(s);
		// S8(s);
		// S9(s);
		s.close();
	}
	private static void S9(Scanner s) {
		System.out.print("Enter string one: ");
		String one = s.nextLine();
		System.out.print("Enter string two: ");
		String two = s.nextLine();
		System.out.println("String Rotation: "+S9.StringRotation(one,two));
	}

	private static void S8(Scanner s) {
		System.out.print("Enter M: ");
		int m = s.nextInt();
		System.out.print("Enter N: ");
		int n = s.nextInt();
		int[][] a = new int[m][n];
		System.out.println("Enter matrix:");
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				System.out.print(i + "\t" + j + " : ");
				a[i][j] = s.nextInt();
			}
		S8.ZeroMatrix(a, m, n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(a[i][j] + "\t");
			System.out.println();
		}
	}
	private static void S7(Scanner s) {
		System.out.print("Enter N: ");
		int n = s.nextInt();
		int[][] m = new int[n][n];
		System.out.println("Enter the values for NxN matrix.");
		System.out.println("Row Column:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(i + " " + j);
				m[i][j] = s.nextInt();
			}
		}
		boolean flag = S7.Rotate(m, n);
		if (!flag)
			System.out.println("Invalid.");
		else {
			System.out.println("Rotated Matrix:");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.println(m[i][j] + "\t");
				}
				System.out.println();
			}
		}
	}

	private static void S6(Scanner s) {
		System.out.print("Enter String: ");
		System.out.println(S6.Compress(s.nextLine()));
	}

	private static void S5(Scanner s) {
		System.out.print("Enter String One: ");
		String one = s.nextLine();
		System.out.print("Enter String Two: ");
		String two = s.nextLine();
		System.out.println("One Away: " + S5.OneAway(one, two));
	}

	private static void S4(Scanner s) {
		System.out.print("Enter String: ");
		System.out.println("Palindrome Permutation Check: " + S4.PalindromePermutationCheck(s.nextLine()));
	}

	private static void S3(Scanner s) {
		System.out.print("Enter String: ");
		String str = s.nextLine();
		System.out.println("Enter true length of the string: ");
		int l = s.nextInt();
		System.out.println("Insertion of %20:");
		System.out.println(S3.URLify(str, l));
	}

	private static void S2(Scanner s) {
		System.out.println("Enter Strings:");
		System.out.println("Permutation Check: " + S2.permutationCheck(s.next(), s.next()));
	}

	private static void S1(Scanner s) {
		System.out.print("Enter String: ");
		String str = s.next().trim();
		System.out.println("Using Hashmap: " + S1.check(str));
		System.out.println("Using No Additional Data Structures: " + S1.check2(str));
	}
}
