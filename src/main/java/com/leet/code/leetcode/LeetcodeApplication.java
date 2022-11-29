package com.leet.code.leetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class LeetcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int result = lengthOfLongestSubstring("dvdf");
		System.out.println(result);
	}

	private static int lengthOfLongestSubstring(String s) {
		HashMap<String, Integer> newMap = new HashMap<>();
		int largestSize = 0;

		for (int i = 0; i < s.length(); i++) {
			String stringChar = String.valueOf(s.charAt(i));
			if (newMap.containsKey(stringChar)) {
				largestSize = getLargestSize(newMap, largestSize);
				newMap.clear();
				addToMap(newMap, stringChar);
			} else {
				addToMap(newMap, stringChar);
			}
		}
		largestSize = getLargestSize(newMap, largestSize);
		return largestSize;
	}

	private static int getLargestSize(HashMap<String, Integer> newMap, int largestSize) {
		if (largestSize < newMap.size()) {
			largestSize = newMap.size();
		}
		return largestSize;
	}

	private static void addToMap(HashMap<String, Integer> newMap, String stringChar) {
		newMap.put(stringChar, newMap.size() + 1);
	}

	private static boolean isPalindrome(int x) {
		String converted = String.valueOf(x);
		StringBuffer sb = new StringBuffer(converted);
		boolean isPalindrome = false;
		for (int i = 0; i < converted.length(); i++) {
			char first = sb.charAt(i);
			char second = sb.charAt(converted.length() - (i+1));
			if (sb.charAt(i) == sb.charAt(converted.length() - (i+1))) {
				isPalindrome = true;
			} else {
				return false;
			}
		}
		return isPalindrome;
	}

	private static String reverseWords(String s) {
		StringBuffer sb = new StringBuffer();
		String noSpace = s.trim();
		String[] split = noSpace.split(" ");

		// Reverse flow
		for (int i = split.length - 1; i >= 0; i--) {
			if (!split[i].equals("")) {
				sb.append(split[i].trim());
				sb.append(" ");
			}
		}

		return sb.toString().trim();
	}

	private static int[] getInts() {
		int[] myIntArray = {2,7,11,15};
		int[] result = twoSum(myIntArray, 9);
		return result;
	}

	private static int[] twoSum(int[] nums, int target) {
		int[] twoSums = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int u = 0; u < nums.length; u++) {
				if (i != u) {
					if ((nums[i] + nums[u]) == target) {
						twoSums[0] = i;
						twoSums[1] = u;
						return twoSums;
					}
				}
			}
		}
		return twoSums;
	}

	private static boolean backSpaceCompare(String s, String t) {
		StringBuffer newStringForS = new StringBuffer();
		StringBuffer newStringForT = new StringBuffer();

		extracted(s, newStringForS);
		extracted(t, newStringForT);
		return newStringForT.toString().equals(newStringForS.toString());
	}

	private static void extracted(String forTesting, StringBuffer newStringBuffer) {
		StringBuffer tempString = new StringBuffer(forTesting);
		char backSpaceCharacter = '#';
		for (int i = 0; i < tempString.length(); i++) {
			if (backSpaceCharacter == tempString.charAt(i)) {
				if (newStringBuffer.length() > 0) {
					newStringBuffer.deleteCharAt(newStringBuffer.length() - 1);
				}
			} else {
				newStringBuffer.append(tempString.charAt(i));
			}
		}
	}

	private static String removeStars(String s) {
		char starSymbol = '*';
		StringBuffer tempString = new StringBuffer(s);
		StringBuffer newString = new StringBuffer();

		for (int i = 0; i < tempString.length() ; i++) {
			if (starSymbol == tempString.charAt(i)) {
				if (tempString.length() > 0) {
					newString.deleteCharAt(newString.length() - 1);
				}
			} else {
				newString.append(tempString.charAt(i));
			}
		}

		return newString.toString();
	}

	private static String removeDuplicates(String s) {
		StringBuffer tempString = new StringBuffer(s);
		StringBuffer newString;

		char savedCharacter = '0';
		newString = new StringBuffer();
		for (int i = 0; i < tempString.length() ; i++) {
			if (savedCharacter == (tempString.charAt(i))) {
				newString.deleteCharAt(newString.length() - 1);
				savedCharacter = '0';
			} else {
				if (newString.length() > 0 && newString.charAt(newString.length() - 1) == tempString.charAt(i)) {
					newString.deleteCharAt(newString.length() - 1);
					savedCharacter = '0';
				} else {
					savedCharacter = tempString.charAt(i);
					newString.append(savedCharacter);
				}
			}
		}
		return newString.toString();
	}

}
