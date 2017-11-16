package statics;

public class One {

	private static String pvt = "private static String One";
	protected static String ptc = "protected static String One";
	public static String pbc = "public static String One";

	public static void main(String[] args) {
		System.out.println("One Main.");
	}

	static {
		System.out.println("One Static Block.");
	}

	// Instance Method.
	public String oneFunc() {
		System.out.println("One Function.");
		return "One Function.";
	}

	public static String oneFunc(String one) {
		System.out.println("One Static Function.");
		return one;
	}

	public One() {
		System.out.println("Default Constructor of One.");
	}
}