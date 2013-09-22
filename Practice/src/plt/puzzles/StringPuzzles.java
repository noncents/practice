package plt.puzzles;

public class StringPuzzles {

	public static void main(String[] args) {

		// test_findFirstNonRepeatingChar();
		// test_permute();
		permutation("abc");
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

	public static void permutation(String str) {

		permutation("", str);
	}

	private static void permutation(String prefix, String str) {

		int n = str.length();
		if (n == 0) {
			System.out.println(prefix);
		}
		else {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}
}
