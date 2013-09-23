package plt.puzzles;

public class Arrays {

	public static void main(String[] args) {

		spiralPrintNxNArray();
	}

	public static void spiralPrintNxNArray() {

		int array2x2[][] = {//
		{ 1, 4 },	//
		{ 2, 3 },	//
		};

		int array4x4[][] = {//
		{ 7, 6, 5, 16 },	//
		{ 8, 1, 4, 15 },	//
		{ 9, 2, 3, 14 },	//
		{ 10, 11, 12, 13 },	//
		};

		int array6x6[][] = {//
		{ 21, 20, 19, 18, 17, 36 },	//
		{ 22, 7, 6, 5, 16, 35 },	//
		{ 23, 8, 1, 4, 15, 34 },	//
		{ 24, 9, 2, 3, 14, 33 },	//
		{ 25, 10, 11, 12, 13, 32 },	//
		{ 26, 27, 28, 29, 30, 31 },	//
		};

		int array8x8[][] = {//
		{ 43, 42, 41, 40, 39, 38, 37, 64 },	//
		{ 44, 21, 20, 19, 18, 17, 36, 63 },	//
		{ 45, 22, 7, 6, 5, 16, 35, 62 },	//
		{ 46, 23, 8, 1, 4, 15, 34, 61 },	//
		{ 47, 24, 9, 2, 3, 14, 33, 60 },	//
		{ 48, 25, 10, 11, 12, 13, 32, 59 },	//
		{ 49, 26, 27, 28, 29, 30, 31, 58 },	//
		{ 50, 51, 52, 53, 54, 55, 56, 57 },	//
		};

		spiralPrintNxNArray_(array2x2);
		spiralPrintNxNArray_(array4x4);
		spiralPrintNxNArray_(array6x6);
		spiralPrintNxNArray_(array8x8);

	}

	public static void spiralPrintNxNArray_(int arr[][]) {

		if (arr == null || arr.length == 0 || arr[0].length == 0) {
			System.out.println("spiralPrintNxNArray_: input array is empty");
			return;
		}

		int x = arr[0].length / 2 - 1;
		int y = x;
		int multiplier = 1;

		System.out.print("\n" + arr[x][y] + " ");

		for (int i = 1; i < arr[0].length; i++) {

			for (int j = 0; j < i; j++) {
				x += multiplier;
				System.out.print(arr[x][y] + " ");
			}

			for (int j = 0; j < i; j++) {
				y += multiplier;
				System.out.print(arr[x][y] + " ");
			}

			multiplier *= -1;
		}

		for (int i = 1; i < arr[0].length; i++) {
			x += multiplier;
			System.out.print(arr[x][y] + " ");
		}

	}

}
