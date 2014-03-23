package plt.fb;

import java.util.ArrayList;
import java.util.List;

public class FBPractice {

	public static void main(String[] args) {

		// find3IntsSumToN(6);
		// find3IntsSumToN(8);
		// find3IntsSumToN(20);
		// find3IntsSumToN(27);
		// find3IntsSumToN(17);
		// find3IntsSumToN(0);
		// find3IntsSumToN(1);
		// find3IntsSumToN(2);
		// find3IntsSumToN(3);
		// find3IntsSumToN(4);
		// find3IntsSumToN(5);

		// System.out.println(divide(127, 9));

		convertIntToEnglish(19987611312L);

		longestIncreasingSequence(new int[] { -3, -2, -1, 0, 1, 0, 1, 2, 3, });
		longestIncreasingSequence(new int[] { -3, -2, -1, 0, 1, 0, 1, 2, 4, });
		longestIncreasingSequence(new int[] { -3, -2, -1, 0, 1, 0, 1, 2, 4, 5 });
		longestIncreasingSequence(new int[] { 0, 1, 2, 1, 4, 0, 3, 4, 5 });
	}

	public static int[] find3IntsSumToN(int n) {

		// assume array is already sorted
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i = 0, j = i + 1, k = arr.length - 1; i < j && j < k;) {

			if (arr[i] + arr[k] > n) {
				k--;
				continue;
			}

			for (; j < k; j++) {

				if (arr[i] + arr[j] + arr[k] == n) {
					System.out.println("3 integers summing to " + n + " are: " + arr[i] + " " + arr[j] + " "
							+ arr[k]);
					return (new int[] { arr[i], arr[j], arr[k] });
				}

				if (arr[i] + arr[j] + arr[k] < n) {
					if (j == k - 1) {
						i++;
						break;
					}
					else {
						continue;
					}
				}

				if (arr[i] + arr[j] + arr[k] > n) {
					k--;
					break;
				}
			}
		}

		System.out.println("3 integers summing to " + n + " not found!");
		return null;
	}

	public static int divide(int dividend, int divisor) {

		int denom = divisor;
		int current = 1;
		int answer = 0;

		if (denom > dividend)
			return 0;

		if (denom == dividend)
			return 1;

		while (denom <= dividend) {
			denom <<= 1;
			current <<= 1;
		}

		System.out.println(denom);
		System.out.println(current);

		denom >>= 1;
		current >>= 1;

		System.out.println(denom);
		System.out.println(current);

		while (current != 0) {
			if (dividend >= denom) {
				dividend -= denom;
				answer |= current;
				System.out.println(answer);
			}
			current >>= 1;
			denom >>= 1;
		}
		return answer;
	}

	public static void convertIntToEnglish(long input) {

		String[] _digits = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] _teens = { "ten", "eleven", "twleve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		String[] _tensPlaces = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		String[] _commasPlaces = { "thousand", "million", "billion", "trillion" };

		System.out.println();
		System.out.println(input);

		int place = 1;
		int prevValue = 0;

		List<String> words = new ArrayList<String>();

		while (input > 0) {

			int value = (int) (input % 10);

			if (isCommasPlace(place)) {
				words.add(_commasPlaces[(place / 3) - 1]);
			}

			if (isSingles(place) && value > 0) {
				words.add(_digits[value - 1]);
			}
			else if (isTeens(value, place)) {

				if (prevValue != 0) {
					words.remove(words.size() - 1);
				}
				words.add(_teens[prevValue]);
			}
			else if (isTensPlace(place)) {
				words.add(_tensPlaces[value - 2]);
			}
			if (isHundredPlace(place)) {
				words.add("hundred");
				words.add(_digits[value - 1]);
			}

			input = input / 10;
			prevValue = value;
			place++;
		}

		for (int i = words.size() - 1; i >= 0; i--) {

			System.out.print(words.get(i) + " ");
		}

	}

	private static boolean isSingles(int place) {

		return (place - 1) % 3 == 0 ? true : false;
	}

	private static boolean isTeens(int value, int place) {

		if ((place - 2) % 3 == 0 && value == 1) {
			return true;
		}

		return false;
	}

	private static boolean isTensPlace(int place) {

		if ((place - 2) % 3 == 0) {
			return true;
		}

		return false;
	}

	private static boolean isHundredPlace(int place) {

		return place % 3 == 0 ? true : false;
	}

	private static boolean isCommasPlace(int place) {

		if ((place - 4) % 3 == 0 && place >= 4) {
			return true;
		}

		return false;
	}

	/*
	 * Return the length (or the sequence itself) of the 
	 * longest sequence of increasing numbers in an unsorted array
	 */
	public static void longestIncreasingSequence(int[] arr) {

		List<Integer> currentSeq = new ArrayList<Integer>();
		List<Integer> longestSeqSoFar = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (currentSeq.size() > 0) {
				// not increasing anymore
				if (arr[i] <= currentSeq.get(currentSeq.size() - 1)) {
					// compare currentSeq vs longestSeqSoFar
					if (currentSeq.size() > longestSeqSoFar.size()) {
						longestSeqSoFar.clear();
						longestSeqSoFar.addAll(currentSeq);
					}
					currentSeq.clear();
				}
			}
			currentSeq.add(arr[i]);
		}

		if (currentSeq.size() > longestSeqSoFar.size()) {
			longestSeqSoFar = currentSeq;
		}

		System.out.println("");
		System.out.println("longest sequence count = " + longestSeqSoFar.size());

		for (int i = 0; i < longestSeqSoFar.size(); i++) {
			System.out.print(longestSeqSoFar.get(i) + " ");
		}

	}
}
