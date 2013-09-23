package plt.puzzles;

public class BinaryPuzzles {

	/*
	 * READ THIS!!!
	 * 
	 * http://graphics.stanford.edu/~seander/bithacks.html
	 * 
	 */

	public static void main(String[] args) {

		test_findOnesInBinaryNumber();
	}

	public static void test_findOnesInBinaryNumber() {

		findOnesInBinaryNumber(0);
		findOnesInBinaryNumber(1);
		findOnesInBinaryNumber(2);
		findOnesInBinaryNumber(3);
		findOnesInBinaryNumber(7);
		findOnesInBinaryNumber(2147483647);

		findOnesInBinaryNumber_naive(0);
		findOnesInBinaryNumber_naive(1);
		findOnesInBinaryNumber_naive(2);
		findOnesInBinaryNumber_naive(3);
		findOnesInBinaryNumber_naive(7);
		findOnesInBinaryNumber_naive(2147483647);

	}

	/**
	 * http://graphics.stanford.edu/~seander/bithacks.html#CountBitsSetKernighan
	 * 
	 * @param number
	 */
	public static void findOnesInBinaryNumber(int number) {

		int n = number;
		int c;

		for (c = 0; number > 0; c++) {
			number = number & number - 1;
		}

		System.out.println("There are [" + c + "] 1s in the number " + n);

	}

	/**
	 * Assumes number is a 32-bit signed integer
	 * 
	 * @param number
	 */
	public static void findOnesInBinaryNumber_naive(int number) {

		int onesCount = 0;
		int n = number;

		while (number != 0) {

			if ((number & 1) == 1) {
				onesCount++;
			}
			number >>= 1;
		}

		System.out.println("There are [" + onesCount + "] 1s in the number " + n);

	}

}
