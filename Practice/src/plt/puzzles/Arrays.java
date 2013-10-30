package plt.puzzles;

public class Arrays {

	public static void main(String[] args) {

		// spiralPrintNxNArray();
		// test_findIndexOfItem();

		test_rotateNxN_Matrix();
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

	public static void test_findIndexOfItem() {

		int[] arr1 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Index of 5 should be 5: >> " + findIndexOfItem(arr1, 0, arr1.length - 1, 5));

		int[] arr2 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Index of 0 should be 0: >> " + findIndexOfItem(arr2, 0, arr2.length - 1, 0));

		int[] arr3 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Index of 10 should be 10: >> " + findIndexOfItem(arr3, 0, arr3.length - 1, 10));

		int[] arr4 = new int[] { 0, 1, 2, 3, 4, 5 };
		System.out.println("Index of 4 should be 4: >> " + findIndexOfItem(arr4, 0, arr4.length - 1, 4));

		int[] arr5 = new int[] { 0, 1, 2, 3, 4, 5 };
		System.out.println("Index of 2 should be 2: >> " + findIndexOfItem(arr5, 0, arr5.length - 1, 2));

		int[] arr6 = new int[] { 0, 1, 2, 3, 4, 5 };
		System.out.println("Index of 6 should be -1: >> " + findIndexOfItem(arr6, 0, arr6.length - 1, 6));

		int[] arr7 = new int[] { 0, 1 };
		System.out.println("Index of 0 should be 0: >> " + findIndexOfItem(arr7, 0, arr7.length - 1, 0));

		int[] arr8 = new int[] { 0, 1 };
		System.out.println("Index of 1 should be 1: >> " + findIndexOfItem(arr8, 0, arr8.length - 1, 1));

		System.out.println();

		// System.out.println("Index of 5 should be 5: >> "
		// + findIndexOfItem_Iterative(arr1, 0, arr1.length - 1, 5));
		// System.out.println("Index of 0 should be 0: >> "
		// + findIndexOfItem_Iterative(arr2, 0, arr2.length - 1, 0));
		System.out.println("Index of 10 should be 10: >> "
				+ findIndexOfItem_Iterative(arr3, 0, arr3.length - 1, 10));
		System.out.println("Index of 4 should be 4: >> "
				+ findIndexOfItem_Iterative(arr4, 0, arr4.length - 1, 4));
		System.out.println("Index of 2 should be 2: >> "
				+ findIndexOfItem_Iterative(arr5, 0, arr5.length - 1, 2));
		System.out.println("Index of 6 should be -1: >> "
				+ findIndexOfItem_Iterative(arr6, 0, arr6.length - 1, 6));
		System.out.println("Index of 0 should be 0: >> "
				+ findIndexOfItem_Iterative(arr7, 0, arr7.length - 1, 0));
		System.out.println("Index of 1 should be 1: >> "
				+ findIndexOfItem_Iterative(arr8, 0, arr8.length - 1, 1));
	}

	/**
	 * Finds the index of the item in sorted array
	 * 
	 * @return
	 */
	public static int findIndexOfItem(int[] arr, int low, int high, int value) {

		int index = -1;

		if (arr.length == 0) {
			return -1;
		}

		if (high - low == 0 && arr[low] != value) {
			return -1;
		}

		if (arr[0] > arr[arr.length - 1]) {
			return -1;
		}

		int mid = low + (high - low) / 2;

		if (value < arr[mid]) {
			index = findIndexOfItem(arr, low, mid - 1, value);
		}
		else if (value > arr[mid]) {
			index = findIndexOfItem(arr, mid + 1, high, value);
		}
		else {
			if (arr[mid] == value) {
				return mid;
			}
		}

		return index;
	}

	/**
	 * Finds the index of the item in sorted array, ITERATIVE way
	 * 
	 * @return
	 */
	public static int findIndexOfItem_Iterative(int[] arr, int low, int high, int value) {

		int index = -1;

		// array is empty
		if (arr.length == 0) {
			return -1;
		}

		// array only has 1 item
		if (high - low == 0 && arr[low] != value) {
			return -1;
		}

		// array is not sorted
		if (arr[0] > arr[arr.length - 1]) {
			return -1;
		}

		while (true) {

			if (high - low == 0 && arr[low] != value) {
				break;	// -1
			}

			if (arr[low] > arr[high]) {
				break; // -1
			}

			int mid = low + (high - low) / 2;

			if (value < arr[mid]) {
				high = mid - 1;
			}
			else if (value > arr[mid]) {
				low = mid + 1;
			}
			else {
				if (arr[mid] == value) {
					index = mid;
				}
				break;
			}

		}

		return index;
	}

	public static void test_rotateNxN_Matrix() {

		// int arrayNxN[][] = {//
		// { 1, 2 }, //
		// { 3, 4 }, //
		// };

		int arrayNxN[][] = {//
		{ 1, 2, 3, 4, 5 }, 		// 0,0 0,1 0,2 0,3 0,4
		{ 6, 7, 8, 9, 10 }, 	// 1,0 1,1 1,2 1,3 1,4
		{ 11, 12, 13, 14, 15 }, // 2,0 2,1 2,2 2,3 2,4
		{ 16, 17, 18, 19, 20 }, // 3.0 3,1 3,2 3,3 3,4
		{ 21, 22, 23, 24, 25 }, // 4,0 4,1 4,2 4,3 4,4
		};

		// int arrayNxN[][] = {//
		// { 1, 2, 3, 4 }, //
		// { 5, 6, 7, 8 }, //
		// { 9, 10, 11, 12 }, //
		// { 13, 14, 15, 16 }, //
		// };

		System.out.println("Before Rotate");
		for (int i = 0; i < arrayNxN.length; i++) {
			System.out.println("");
			for (int j = 0; j < arrayNxN[0].length; j++) {
				System.out.print(arrayNxN[i][j] + "\t");
			}
		}

		// rotate_NxN_Matrix(arrayNxN, arrayNxN.length);

		rotate_NxN_Matrix_ctci(arrayNxN, arrayNxN.length);

		System.out.println("\nAfter Rotate");
		for (int i = 0; i < arrayNxN.length; i++) {
			System.out.println("");
			for (int j = 0; j < arrayNxN[0].length; j++) {
				System.out.print(arrayNxN[i][j] + "\t");
			}
		}

	}

	public static void rotate_NxN_Matrix(int[][] arr, int n) {

		int temp = 0;

		int x = 0, prevX = 0, startX = 0;
		int y = 0, prevY = 0, startY = 0;

		int adjust = 0;
		if (n % 2 == 0) {
			adjust = 1;
		}

		// how many circular loops
		for (int i = (n / 2); i > 0; i--) {

			for (int j = 0; j < (i * 2) - adjust; j++) {	// how many items to move
				x = prevX = startX;
				y = prevY = startY + j;

				for (int k = 0; k < 3; k++) {	// 4 sides to move
					switch (k) {
					case 0:
						temp = arr[x][y];
						y = y + ((i * 2) - adjust - j);
						x = x + j;
						break;
					case 1:
						y = y - j;
						x = x + ((i * 2) - adjust - j);
						break;
					case 2:
						y = y - ((i * 2) - adjust - j);
						x = x - j;
						break;
					}

					arr[prevX][prevY] = arr[x][y];
					prevX = x;
					prevY = y;

				}
				arr[x][y] = temp;

			}

			startX++;
			startY++;

		}
	}

	public static void rotate_NxN_Matrix_ctci(int[][] matrix, int n) {

		for (int layer = 0; layer < n / 2; ++layer) {

			int first = layer;
			int last = n - 1 - layer;
			System.out.println("");
			for (int i = first; i < last; ++i) {
				int offset = i - first;

				// System.out.println("Copy " + first + "," + i + " to temp");
				// System.out.println("Copy " + (last - offset) + "," + first + " to " + first + "," + i);
				// System.out.println("Copy " + last + "," + (last - offset) + " to " + (last - offset) + ","
				// + first);
				// System.out.println("Copy " + i + "," + last + " to " + last + "," + (last - offset));
				// System.out.println("Copy temp to " + i + "," + last);

				int top = matrix[first][i];

				matrix[first][i] = matrix[last - offset][first];

				matrix[last - offset][first] = matrix[last][last - offset];

				matrix[last][last - offset] = matrix[i][last];

				matrix[i][last] = top;

			}
		}
	}

}
