package anagram;

import java.util.ArrayList;

/**
 * This utility class can test with two strings are anagrams.
 *
 * @author Claude Anderson.
 */
public class Anagram {

	/**
	 * We say that two strings are anagrams if one can be transformed into the
	 * other by permuting the characters (and ignoring case).
	 * 
	 * @param s1
	 *            first string
	 * @param s2
	 *            second string
	 * @return true iff s1 is an anagram of s2
	 */
	@SuppressWarnings("boxing")
	public static boolean isAnagram(String s1, String s2) {
		// TODO: implement this method

		// some prep before comparing strings
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		int s1Size = s1.length();
		int s2Size = s2.length();
		// check if the strings are the same size
		if (s1Size - s2Size != 0) {
			return false;
		}

		ArrayList<Character> string1 = new ArrayList<>();
		ArrayList<Character> string2 = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			string1.add(s1.charAt(i));
			string2.add(s2.charAt(i));
		}

		// test to see if each letter in s1 is in s2
		for (int i = 0; i < string1.size(); i++) {
			char currentLetter1 = string1.get(i);
			for (int j = 0; j < string2.size(); j++) {
				char currentLetter2 = string2.get(j);
				if (currentLetter1 == currentLetter2) {
					string2.remove(j);
					break;
				}
			}
		}
		if (string2.size() == 0) {
			return true;
		}

		return false;
	}
}
