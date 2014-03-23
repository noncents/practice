package plt.puzzles;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	static int counter = 0;

	public static void main(String[] args) {

		test_permutations();

		// test_printTelephoneWords();

		// combine("abcde", new StringBuffer(), 0);
	}

	public static void test_permutations() {

		counter = 0;
		permutations("abc");

		// permuteIterative("abc".toCharArray());
		// permuteIterative("abcd".toCharArray());
		// permuteIterative("abcde".toCharArray());

		// perm2(new String("abc").toCharArray(), 3);
	}

	public static void test_printTelephoneWords() {

		printTelephoneWords(new int[] { 8, 7, 4 });
	}

	public static void printTelephoneWords(int[] phoneNo) {

		char[] result = new char[phoneNo.length];

		doPrintTelephoneWords(phoneNo, 0, result);
	}

	private static void doPrintTelephoneWords(int[] phoneNo, int currDigit, char[] result) {

		if (currDigit == phoneNo.length) {
			System.out.println(new String(result));
			return;
		}

		for (int i = 0; i < 3; i++) {
			result[currDigit] = getPhoneCharKey(phoneNo[currDigit], i);
			doPrintTelephoneWords(phoneNo, currDigit + 1, result);
			if (phoneNo[currDigit] == 0 || phoneNo[currDigit] == 1) {
				return;
			}
		}
	}

	public static char getPhoneCharKey(int telephoneKey, int place) {

		char arr[][] = {	//
		{ '0' },			// 0
		{ '1' },			// 1
		{ 'A', 'B', 'C' },	// 2
		{ 'D', 'E', 'F' },	// 3
		{ 'G', 'H', 'I' },	// 4
		{ 'J', 'K', 'L' },	// 5
		{ 'M', 'N', 'O' },	// 6
		{ 'P', 'R', 'S' },	// 7
		{ 'T', 'U', 'V' },	// 8
		{ 'W', 'X', 'Y' }	// 9
		};

		return arr[telephoneKey][place];
	}

	public static void permutations(String str) {

		if (str == null) {
			return;
		}

		permute("", str);

		System.out.println("counter = " + counter);

	}

	private static void permute(String prefix, String str) {

		if (str.length() == 0) {
			// System.out.println(++counter);
			System.out.println(prefix);
		}
		else {

			for (int i = 0; i < str.length(); i++) {

				permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));
				counter++;
			}
		}

	}

	private static void perm2(char[] str, int n) {

		if (n == 1) {
			System.out.println(str);
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(str, i, n - 1);
			perm2(str, n - 1);
			swap(str, i, n - 1);
		}
	}

	// swap the characters at indices i and j
	private static void swap(char[] a, int i, int j) {

		char c;
		c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void combine(String instr, StringBuffer outstr, int index) {

		for (int i = index; i < instr.length(); i++) {
			outstr.append(instr.charAt(i));
			System.out.println(outstr);
			combine(instr, outstr, i + 1);
			outstr.deleteCharAt(outstr.length() - 1);
			System.out.println("  " + outstr);
		}
	}

	public static void permuteIterative(char[] str) {

		List<String> perms = new ArrayList<String>();
		List<String> newPerms;

		perms.add(String.valueOf(str[0]));

		int bigO = 0;

		for (int i = 1; i < str.length; i++) {

			newPerms = new ArrayList<String>();

			for (String subStr : perms) {

				// newPerms.add(str[i] + subStr);

				for (int j = 0; j <= subStr.length(); j++) {
					newPerms.add(subStr.substring(0, j) + str[i] + subStr.substring(j, subStr.length()));
					bigO++;

				}
			}

			perms = newPerms;
		}

		for (String perm : perms) {

			System.out.println(perm);
		}

		System.out.println("bigO = " + bigO);
	}

}
