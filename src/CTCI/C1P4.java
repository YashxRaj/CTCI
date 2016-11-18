package CTCI;
import java.util.Scanner;

public class C1P4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter String: ");
		String str = s.next();
		System.out.println("Enter true length of the string: ");
		int l = s.nextInt();
		System.out.println("Insertion of %20: " + percentageInsertion(str, l));

	}

	private static String percentageInsertion(String str, int l) {
		for (int i = 0; i < l; i++) {
			if (str.charAt(i) == ' ') {
				
			}
		}
		return null;
	}
}
