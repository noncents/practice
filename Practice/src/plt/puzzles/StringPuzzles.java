package plt.puzzles;

public class StringPuzzles {

	public static void main(String[] args) {

		// test_findFirstNonRepeatingChar();
		// test_permute();
		// permutation("abc");

		System.out.println(removeCharsFromString("patrick tan", "ai"));
		System.out.println(removeCharsFromString("pavelitomeow", "aeiou"));

		System.out.println(reverseWordsInAReversedString("this is a new four letter word"));
		System.out.println(reverseWordsInAReversedString("patrick"));
		System.out.println(reverseWordsInAReversedString("patrick tan"));
		System.out.println(reverseWordsInAReversedString("patrick tan is a horny chinese mafia.."));

		// String str = "patrick tan is a horny chinese mafia..";
		// System.out.println(reverseWords(str.toCharArray()));

		permutation("abcd");

		System.out.println("\nisNumberPalindrome(12345) " + isNumberPalindrome(12345));
		System.out.println("isNumberPalindrome(12321) " + isNumberPalindrome(12321));
		System.out.println("isNumberPalindrome(0) " + isNumberPalindrome(0));
		System.out.println("isNumberPalindrome(565) " + isNumberPalindrome(565));
		System.out.println("isNumberPalindrome(8888) " + isNumberPalindrome(8888));
		System.out.println("isNumberPalindrome(100) " + isNumberPalindrome(100));

		System.out.println("\nisNumberPalindrome(12345) " + isPalindrome(12345));
		System.out.println("isNumberPalindrome(12321) " + isPalindrome(12321));
		System.out.println("isNumberPalindrome(0) " + isPalindrome(0));
		System.out.println("isNumberPalindrome(565) " + isPalindrome(565));
		System.out.println("isNumberPalindrome(8888) " + isPalindrome(8888));
		System.out.println("isNumberPalindrome(100) " + isPalindrome(100));

	}

	public static void test_findFirstNonRepeatingChar() {

		findFirstNonRepeatingChar("typewriter");
		findFirstNonRepeatingChar("abcde");
		findFirstNonRepeatingChar("teeth");
		findFirstNonRepeatingChar(null);
		findFirstNonRepeatingChar("");

	}

	/**
	 * Assumes string only contains a-z
	 * 
	 * @param str
	 */
	public static void findFirstNonRepeatingChar(String str) {

		if (str == null || str.trim().isEmpty()) {
			System.out.println("Are you stoooopid?");
			return;
		}

		int[] charsetCount = new int[26];

		// construct our histogram
		for (int i = 0; i < str.length(); i++) {

			char ch = Character.toUpperCase(str.charAt(i));
			charsetCount[ch - 'A'] = charsetCount[ch - 'A'] + 1;
		}

		for (int i = 0; i < str.length(); i++) {

			char ch = Character.toUpperCase(str.charAt(i));

			if (charsetCount[ch - 'A'] == 1) {
				System.out.println("'" + str.charAt(i) + "'"
						+ " is the first non-repeating letter for string [" + str + "]");
				break;
			}
		}

	}

	public static void test_permute() {

		permute("abc");
		// permute("12345");
	}

	public static void permute(String str) {

		int length = str.length();
		boolean[] used = new boolean[length];
		StringBuffer out = new StringBuffer();
		char[] in = str.toCharArray();
		doPermute(in, out, used, length, 0);
	}

	public static void doPermute(char[] in, StringBuffer out, boolean[] used, int length, int level) {

		if (level == length) {
			System.out.println(out.toString());
			return;
		}
		for (int i = 0; i < length; ++i) {
			if (used[i]) {
				continue;
			}
			out.append(in[i]);
			used[i] = true;
			doPermute(in, out, used, length, level + 1);
			used[i] = false;
			out.setLength(out.length() - 1);
		}
	}

	/**
	 * Pavel's version
	 * 
	 * @param str
	 */
	public static void permutation(String str) {

		System.out.println();
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {

		// System.out.println("[" + prefix + "] " + "[" + str + "] ");

		int n = str.length();
		if (n == 0) {
			System.out.print(prefix + " ");
		}
		else {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

	/**
	 * Assumes ASCII only for src and charsToRemove
	 * 
	 * @param src
	 * @param charsToRemove
	 * @return
	 */

	public static String removeCharsFromString(String str, String charsToRemove) {

		boolean flags[] = new boolean[128];

		char s[] = str.toCharArray();
		char r[] = charsToRemove.toCharArray();

		for (int i = 0; i < r.length; i++) {
			flags[r[i]] = true;
		}

		int len = s.length;
		int dst = 0;

		for (int i = 0; i < len; i++) {

			if (!flags[s[i]]) {	// if not flagged as existing in charsToRemove
				s[dst++] = s[i];
			}

		}

		return new String(s, 0, dst);

	}

	public static String reverseWordsInAReversedString(String str) {

		if (str == null) {
			return null;
		}

		char[] s = str.toCharArray();

		reverseCharArray(s, 0, s.length - 1);

		int start = 0;

		for (int i = 0; i < s.length; i++) {

			if (s[i] == ' ' && start != i) {
				reverseCharArray(s, start, i - 1);
				start = i + 1;
			}
		}

		reverseCharArray(s, start, s.length - 1);

		return new String(s, 0, s.length);

	}

	public static void reverseCharArray(char[] s, int start, int end) {

		if (s == null || s.length == 0) {
			return;
		}

		int halflen = (end + 1 - start) / 2;

		for (int i = 0; i < halflen; i++) {
			char temp = s[start + i];
			s[start + i] = s[end - i];
			s[end - i] = temp;
		}

	}

	/*
		public static char[] reverseWords(char[] sentence) {

			reverseString(sentence, 0, sentence.length);
			int wordStart = 0, i = 0;
			while (i < sentence.length) {
				if (sentence[i] == ' ') {
					reverseString(sentence, wordStart, i);
					wordStart = ++i;
				}
				else if (i == sentence.length - 1) {
					reverseString(sentence, wordStart, i + 1);
					i++;
				}
				else {
					i++;
				}
			}

			return sentence;
		}

		public static char[] reverseString(char[] string, int start, int end) {

			for (int i = start; i < (start + end) / 2; i++) {
				swap(string, i, start + end - i - 1);
			}

			return string;
		}

		private static void swap(char[] array, int a, int b) {

			char temp = array[a];
			array[a] = array[b];
			array[b] = temp;
		}
	*/

	public static boolean isNumberPalindrome_Iterative(long number) {

		long converted = 0;
		long divider = 1;

		while (number / divider != 0) {

			converted = converted * 10 + number / divider % 10;
			divider *= 10;
		}

		return converted == number;
	}

	public static boolean isNumberPalindrome(long number) {

		return number == isNumberPalindrome_(number, 0);
	}

	public static long isNumberPalindrome_(long number, long currentVal) {

		long amount = number % 10;

		if (number / 10 != 0) {
			amount = isNumberPalindrome_(number / 10, currentVal * 10 + amount);
		}
		else {
			return currentVal * 10 + amount;
		}

		return amount;

	}

	public static boolean isPalindromeRecursive(int x, int y) {

		if (x < 0) {
			return false;
		}
		if (x == 0) {
			return true;
		}
		if (isPalindromeRecursive(x / 10, y) && x % 10 == y % 10) {
			y /= 10;
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isPalindromeRecursive_pf(int x) {

		return isPalindromeRecursive(x, x);
	}

	public static boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		}
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
		while (x != 0) {
			int l = x / div;
			int r = x % 10;
			if (l != r) {
				return false;
			}
			x = x % div / 10;
			div /= 100;
		}
		return true;
	}
}
