package ctci;

public class Chapter1 {

	public static void main(String[] args) {

		testQ1_5_compressString();
	}

	public static void testQ1_5_compressString() {

		assert (Q1_5_compressString("abcde").equals("abcde"));
		assert (Q1_5_compressString("aabbbccccdddee").equals("a2b3c4d3e2"));
		assert (Q1_5_compressString("abbcddeff").equals("abbcddeff"));
		assert (Q1_5_compressString("aabbccddeeffgg").equals("aabbccddeeffgg"));
		assert (Q1_5_compressString("aabbccddeeffggg").equals("a2b2c2d2e2f2g3"));

		System.out.println("testQ1_5 = OKAY");
	}

	public static String Q1_5_compressString(String str) {

		if (str == null || str.length() == 1) {
			return str;
		}

		StringBuilder sb = new StringBuilder();

		char ch = str.charAt(0);
		int count = 1;
		int len = str.length();

		for (int i = 1; i < len; i++) {

			if (str.charAt(i) == ch) {
				count++;
			}
			else {
				sb.append(ch);
				sb.append(count);

				ch = str.charAt(i);
				count = 1;
			}
		}

		sb.append(ch);
		sb.append(count);

		String newString = sb.toString();

		if (newString.length() < len) {
			return newString;
		}

		return str;

	}

	// TODO
	public static void Q1_7_ZeroMxN_Matrix(int arr[][]) {

	}
}
