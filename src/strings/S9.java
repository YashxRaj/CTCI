package strings;

public class S9 {

	public static Boolean StringRotation(String one, String two) {
		return one.concat(one).contains(two);
	}
}
