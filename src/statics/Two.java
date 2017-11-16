package statics;

public class Two extends One {

	private static String pvt = "private static String Two";
	protected static String ptc = "protected static String Two";
	public static String pbc = "public static String Two";

	static {
		System.out.println("Two Static Block.");
	}

	public static void main(String[] args) {
		System.out.println("Two Main.");
	}

	public Two() {
		System.out.println("Default Constructor of Two.");
	}

	@Override
	public String oneFunc() {
		System.out.println("Overridden One Function.");
		return "Overridden One Function.";
	}

	public static String oneFunc(String two) {
		System.out.println("Two Static Function.");
		return two;
	}

	public static String twoFunc() {
		System.out.println("Two Function.");
		return "Two Function.";
	}
}