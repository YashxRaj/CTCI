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

	private static boolean isAnagram(HashMap<Character, Integer> bufferMap, HashMap<Character, Integer> patternMap) {
		for (Character x : patternMap.keySet())
			if (patternMap.get(x) != bufferMap.get(x))
				return false;
		return true;
	}

	// My twist on Rabin-Karp Algorithm to make it simpler.
	private static Integer[] searchRabinKarpAlgorithm(char[] txt, char[] pattern) {
		char[] buffer = new char[pattern.length];
		Vector<Integer> indices = new Vector<Integer>();
		HashMap<Character, Integer> patternMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> bufferMap = new HashMap<Character, Integer>();
		// Preparation.
		for (int i = 0; i < pattern.length; i++) {
			buffer[i] = txt[i];
			patternMap.put(pattern[i], patternMap.containsKey(pattern[i]) ? patternMap.get(pattern[i]) + 1 : 1);
			bufferMap.put(buffer[i], bufferMap.containsKey(buffer[i]) ? bufferMap.get(buffer[i]) + 1 : 1);
		}
		// Search and update.
		for (int i = 0; i < txt.length - buffer.length + 1; i++) {
			if (isAnagram(bufferMap, patternMap))
				indices.add(i);
			if (i != txt.length - buffer.length)
				shiftAndUpdateMap(buffer, txt[buffer.length + i], bufferMap);
		}
		return indices.toArray(new Integer[indices.size()]);
	}
}