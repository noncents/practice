package plt.sort;

public class Sorters {

	public Sorters() {

	}

	/**
	 * Accepts an array of unsorted integers, sorts it in ascending order,
	 * and returns it in an array
	 * 
	 * @param toSort - an unsorted array of integers
	 * @return - a sorted array of integers
	 */
	public int[] mergeSort(int[] toSort) {

		// if 0 or 1 item, no need to sort
		if (toSort != null && toSort.length <= 1) {
			return toSort;
		}

		int middle = toSort.length / 2;

		int[] left = new int[middle];
		int[] right = new int[toSort.length - middle];

		for (int i = 0; i < middle; i++) {
			left[i] = toSort[i];
		}

		for (int i = middle; i < toSort.length; i++) {
			right[i - middle] = toSort[i];
		}

		// System.out.println("");
		System.out.println("* * * * * * * * * *");

		System.out.print("Left:  ");
		for (int i = 0; i < left.length; i++) {
			System.out.print(left[i] + ", ");
		}

		System.out.println("");
		System.out.print("Right: ");
		for (int i = 0; i < right.length; i++) {
			System.out.print(right[i] + ", ");
		}
		System.out.println("");

		left = mergeSort(left);
		right = mergeSort(right);

		return merge(left, right);

	}

	private int[] merge(int[] left, int[] right) {

		int[] result = new int[left.length + right.length];

		int i = 0;	// left list counter
		int j = 0;	// right list counter

		while (i < left.length || j < right.length) {

			if (i < left.length && j < right.length) {
				if (left[i] > right[j]) {
					result[i + j] = right[j];
					j++;
				}
				else {
					result[i + j] = left[i];
					i++;
				}
			}
			else {
				if (i < left.length) {
					result[i + j] = left[i];
					i++;
				}
				else {
					result[i + j] = right[j];
					j++;
				}
			}
		}

		return result;
	}

	public void quickSort(int[] toSort) {

		quick_sort(toSort, 0, toSort.length - 1);

	}

	private void quick_sort(int[] toSort, int startIdx, int endIdx) {

		if (endIdx > 0) {
			System.out.println("\nSorting... Pivot = [" + toSort[endIdx] + "]");
		}

		printArray(toSort, startIdx, endIdx);

		// for (int i = startIdx; i <= endIdx; i++) {
		// System.out.print(toSort[i] + " ");
		// }
		//
		// System.out.println("");

		int start = startIdx;
		int end = endIdx - 1;

		if (endIdx <= startIdx) {
			return;
		}

		int pivotValue = toSort[endIdx];

		while (true) {
			while (toSort[start] < pivotValue && start < endIdx) {
				start++;
			}

			while (pivotValue < toSort[end] && end > startIdx) {
				end--;
			}

			if (start == end || start >= end) {
				break;
			}

			swap(toSort, start, end);
			printArray(toSort, startIdx, endIdx);
		}

		swap(toSort, start, endIdx);

		printArray(toSort, startIdx, endIdx);

		System.out.println("Array now looks like:");
		printArray(toSort);

		quick_sort(toSort, startIdx, start - 1);
		quick_sort(toSort, start + 1, endIdx);

	}

	private void swap(int[] arr, int idxA, int idxB) {

		System.out.println("Swapping " + arr[idxA] + " and " + arr[idxB]);
		int temp = arr[idxB];
		arr[idxB] = arr[idxA];
		arr[idxA] = temp;
	}

	private void printArray(int[] toSort) {

		printArray(toSort, 0, toSort.length - 1);
	}

	private void printArray(int[] toSort, int startIdx, int endIdx) {

		// System.out.println("");
		for (int i = startIdx; i <= endIdx; i++) {
			System.out.print(toSort[i]);

			if (i == endIdx) {
				System.out.println("");
			}
			else {
				System.out.print(", ");
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// int i = 1;
		//
		// if (i > 0) {
		// System.out.println("Greater than 0");
		// }
		// else if (i != 0) {
		// System.out.println("Not Equal 0");
		// }

		testMergeSort();
		// testQuickSort();
	}

	public static void testMergeSort() {

		int[] toSort1 = new int[] { 7, 4, 9, 5, 1, 3, 2, 6, 10, 8 };
		int[] toSort2 = new int[] { 1, 2 };
		int[] toSort3 = new int[] { 1 };

		Sorters sorter = new Sorters();

		int[] result1 = sorter.mergeSort(toSort1);
		System.out.print("\nResult1 = ");
		for (int i = 0; i < toSort1.length; i++) {
			System.out.print(result1[i]);

			if (i == toSort1.length - 1) {
				System.out.println("");
			}
			else {
				System.out.print(", ");
			}
		}

		int[] result2 = sorter.mergeSort(toSort2);
		System.out.print("\nResult2 = ");
		for (int i = 0; i < toSort2.length; i++) {
			System.out.print(result2[i]);

			if (i == toSort2.length - 1) {
				System.out.println("");
			}
			else {
				System.out.print(", ");
			}
		}

		int[] result3 = sorter.mergeSort(toSort3);
		System.out.print("\nResult3 = ");
		for (int i = 0; i < toSort3.length; i++) {
			System.out.print(result3[i]);

			if (i == toSort3.length - 1) {
				System.out.println("");
			}
			else {
				System.out.print(", ");
			}
		}
	}

	public static void testQuickSort() {

		// int[] toSort1 = new int[] { 7, 4, 9, 5, 1, 3, 2, 6, 10, 8 };
		int[] toSort1 = new int[] { 1, 2 };

		Sorters sorter = new Sorters();

		sorter.quickSort(toSort1);

	}

}
