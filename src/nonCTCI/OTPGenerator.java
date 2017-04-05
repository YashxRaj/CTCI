package nonCTCI;

import java.util.Random;
import java.util.Vector;

public class OTPGenerator {
	public static String generateOTP() {
		Vector<Character> set = generateBaseSet(); // Because I'm lazy.
		Random r = new Random();
		char[] otp = new char[6];
		for (int i = 0; i < otp.length; i++)
			otp[i] = set.get(r.nextInt(set.size()));
		return new String(otp);
	}

	private static Vector<Character> generateBaseSet() {
		Vector<Character> set = new Vector<Character>();
		int num = 48, alphaS = 97, alphaB = 65, i;
		for (i = num; i < num + 10; i++)
			set.add((char) i++);
		for (i = alphaS; i < alphaS + 26; i++)
			set.add((char) i++);
		for (i = alphaB; i < alphaB + 26; i++)
			set.add((char) i++);
		return set;
	}

}
