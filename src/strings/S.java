package strings;

import java.util.Scanner;

public class S {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//S1(s);
		//S2(s);
		//S3(s);
		S4(s);
		//S5(s);
	}

	private static void S4(Scanner s) {
		System.out.print("Enter String: ");
		System.out.println(S4.PalindromePermutationCheck(s.nextLine()));
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
		System.out.println("Permutation Check: "+S2.permutationCheck(s.next(),s.next()));
	}

	private static void S1(Scanner s) {
		System.out.print("Enter String: ");
		String str =s.next().trim();
		System.out.println("Using Hashmap: " + S1.check(str));
		System.out.println("Using No Additional Data Structures: " + S1.check2(str));
	}
}
