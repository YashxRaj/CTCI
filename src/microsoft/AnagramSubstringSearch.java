package microsoft;

import java.util.*;

public class AnagramSubstringSearch {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String text = s.nextLine().trim(), pat = s.nextLine().trim();
		s.close();
		Integer[] indices = searchRabinKarpAlgorithm(text.toCharArray(), pat.toCharArray());
		for (int index : indices)
			System.out.println("Found at Index " + index);
	}

	private static void shiftAndUpdateMap(char[] buffer, char newChar, HashMap<Character, Integer> bufferMap) {
		int i = 0;
		char oldChar = buffer[0];
		while (i < buffer.length - 1)
			buffer[i] = buffer[++i];
		buffer[i] = newChar;

		bufferMap.put(oldChar, bufferMap.get(oldChar) - 1);
		bufferMap.put(newChar, bufferMap.containsKey(newChar) ? bufferMap.get(newChar) + 1 : 1);
	}

	private static boolean isAnagram(HashMap<Character, Integer> bufferMap, HashMap<Character, Integer> pattern) {
		for (Character x : pattern.keySet())
			if (pattern.get(x) != bufferMap.get(x))
				return false;
		return true;
	}

	// My twist on Rabin-Karp Algorithm to make it simpler.
	private static Integer[] searchRabinKarpAlgorithm(char[] txt, char[] pat) {
		char[] buffer = new char[pat.length];
		Vector<Integer> vi = new Vector<Integer>();
		HashMap<Character, Integer> pattern = new HashMap<Character, Integer>();
		HashMap<Character, Integer> bufferMap = new HashMap<Character, Integer>();

		for (int i = 0; i < pat.length; i++) {
			buffer[i] = txt[i];
			pattern.put(pat[i], pattern.containsKey(pat[i]) ? pattern.get(pat[i]) + 1 : 1);
			bufferMap.put(buffer[i], bufferMap.containsKey(buffer[i]) ? bufferMap.get(buffer[i]) + 1 : 1);
		}

		for (int i = 0; i < txt.length - buffer.length + 1; i++) {
			if (isAnagram(bufferMap, pattern))
				vi.add(i);
			if (i != txt.length - buffer.length)
				shiftAndUpdateMap(buffer, txt[buffer.length + i], bufferMap);
		}
		return vi.toArray(new Integer[vi.size()]);
	}
}