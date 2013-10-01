package plt.puzzles;

public class Permutations {

	public static void main(String[] args) {

		test_printTelephoneWords();
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

}
