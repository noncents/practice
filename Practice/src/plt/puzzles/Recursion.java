package plt.puzzles;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

	public static void main(String[] args) {

		test_powerset();

		test_subsetSum();

		test_permuteString();

		test_permuteBrackets();

		test_NQueens();

		test_substringSearch();

	}

	/*
	 ************************************************************************** 
	 */

	public static void test_powerset() {

		// Test Recursive solution
		List<Integer> theSet = new ArrayList<Integer>();
		theSet.add(0);
		theSet.add(1);
		theSet.add(2);
		// theSet.add(3);

		System.out.println("");
		System.out.print("The powerset of { ");
		for (Integer item : theSet) {
			System.out.print(item + ",");
		}
		System.out.println(" } are");

		List<List<Integer>> powerset = getSubsets(theSet, 0);

		assert (powerset.size() == (1 << theSet.size()));

		for (List<Integer> subset : powerset) {
			System.out.print("[");
			for (Integer item : subset) {
				System.out.print(item + ",");
			}
			System.out.println("]");
		}

		// -------------------------------------------------

		// Test Iterative solution

		System.out.println("");
		System.out.print("The powerset of { ");
		for (Integer item : theSet) {
			System.out.print(item + ",");
		}
		System.out.println(" } are");

		powerset = getSubsets(theSet);	// Iterative

		assert (powerset.size() == (1 << theSet.size()));

		for (List<Integer> subset : powerset) {
			System.out.print("[");
			for (Integer item : subset) {
				System.out.print(item + ",");
			}
			System.out.println("]");
		}

	}

	public static void test_subsetSum() {

	}

	public static void test_permuteString() {

		String input = "abcd";

		System.out.println("");
		System.out.println("The permutations of " + input + " are: ");

		List<String> perms = permuteString(input);

		for (String perm : perms) {
			System.out.println(perm);
		}

	}

	public static void test_permuteBrackets() {

		int input = 4;

		System.out.println("");
		System.out.println("The bracket permutations of n=" + input + " are: ");

		List<String> perms = permuteBrackets(input);

		for (String perm : perms) {
			System.out.println(perm);
		}

	}

	public static void test_NQueens() {

		List<Integer[]> results = new ArrayList<Integer[]>();

		results = nQueens(8);

		printBoards(results);
		System.out.println(results.size());
	}

	public static void test_substringSearch() {

	}

	/*
	 ************************************************************************** 
	 */

	public static List<List<Integer>> getSubsets(List<Integer> theSet, int index) {

		if (index == theSet.size()) {
			List<Integer> emptyList = new ArrayList<Integer>();
			List<List<Integer>> subSets = new ArrayList<List<Integer>>();
			subSets.add(emptyList);
			return subSets;
		}
		List<List<Integer>> theSubsets = getSubsets(theSet, index + 1);

		Integer item = theSet.get(index);

		List<List<Integer>> newSubsets = new ArrayList<List<Integer>>();
		for (List<Integer> subset : theSubsets) {
			// make sure to make a new list here and not use the subset
			List<Integer> newSet = new ArrayList<Integer>();
			newSet.addAll(subset);
			newSet.add(item);
			newSubsets.add(newSet);
		}
		theSubsets.addAll(newSubsets);

		return theSubsets;
	}

	public static List<List<Integer>> getSubsets(List<Integer> theSet) {

		int numSubsets = 1 << theSet.size();

		List<List<Integer>> theSubsets = new ArrayList<List<Integer>>();

		for (int i = 0; i < numSubsets; i++) {
			theSubsets.add(getSubset(theSet, i));
		}

		return theSubsets;
	}

	private static List<Integer> getSubset(List<Integer> theSet, int n) {

		List<Integer> subset = new ArrayList<Integer>();

		int index = 0;

		/*
		 * n=0, returns empty subset
		 * n=1, returns theSet[0]
		 * n=2, returns theSet[1]
		 * n=3, returns theSet[0],[1]
		 * n=4, returns theSet[2]
		 * n=5, returns theSet[0],[2]
		 * n=6, returns theSet[1],[2]
		 * n=7, returns theSet[0],[1],[2]
		 */
		for (int i = n; i > 0; i >>= 1) {

			if ((i & 1) == 1) {
				subset.add(theSet.get(index));
			}
			index++;
		}

		return subset;
	}

	public static List<String> permuteString(String strInput) {

		if (strInput == null) {
			return null;
		}

		if (strInput.length() == 1) {
			List<String> perms = new ArrayList<String>();
			perms.add(strInput);
			return perms;
		}

		List<String> perms = permuteString(strInput.substring(1));

		char ch = strInput.charAt(0);

		List<String> newperms = new ArrayList<String>();

		for (String perm : perms) {

			for (int i = 0; i <= perm.length(); i++) {
				newperms.add(perm.substring(0, i) + String.valueOf(ch) + perm.substring(i, perm.length()));
			}
		}

		return newperms;

	}

	public static List<String> permuteBrackets(int n) {

		List<String> perms = new ArrayList<String>();

		permuteBrackets(perms, "", 0, 0, n);

		return perms;
	}

	private static void permuteBrackets(List<String> perms, String str, int open, int close, int n) {

		if (open == close && close == n) {
			perms.add(str);
		}

		if (open < n) {
			permuteBrackets(perms, str + "(", open + 1, close, n);
		}

		if (close < open) {
			permuteBrackets(perms, str + ")", open, close + 1, n);
		}
	}

	/**
	 * Write an algorithm that prints all ways of arranging N Queens in an
	 * NxN chessboard
	 * 
	 * @param n
	 */
	public static List<Integer[]> nQueens(int n) {

		List<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] prevQueenLocs = new Integer[n];

		nQueens(prevQueenLocs, n, 0, results);

		return results;
	}

	private static void nQueens(Integer[] prevQueenLocs, int n, int currRow, List<Integer[]> results) {

		if (currRow == n) {
			results.add(prevQueenLocs.clone());
		}

		for (int col = 0; col < n; col++) {
			if (checkValid(prevQueenLocs, currRow, col)) {
				prevQueenLocs[currRow] = col;
				nQueens(prevQueenLocs, n, currRow + 1, results);
			}
		}
	}

	private static boolean checkValid(Integer[] prevQueenLocs, int currRow, int currCol) {

		for (int i = 0; i < currRow; i++) {

			// check if same col
			if (prevQueenLocs[i] == currCol) {
				return false;
			}

			/* check if diagonals intersect
			 * (x1,y1) vs (x2,y2)
			 * if abs(x1-x2) == abs(y1-y2)
			 * then the diagonals intersect
			 */

			int colDiff = Math.abs(prevQueenLocs[i] - currCol);
			int rowDiff = currRow - i;

			if (colDiff == rowDiff)
				return false;
		}

		return true;
	}

	private static void printBoards(List<Integer[]> boards) {

		for (int i = 0; i < boards.size(); i++) {
			Integer[] board = boards.get(i);
			printBoard(board, 8);
		}
	}

	public static void printBoard(Integer[] columns, int n) {

		drawLine(8);
		for (int i = 0; i < n; i++) {
			System.out.print("|");
			for (int j = 0; j < n; j++) {
				if (columns[i] == j) {
					System.out.print("Q|");
				}
				else {
					System.out.print(" |");
				}
			}
			System.out.print("\n");
			drawLine(8);
		}
		System.out.println("");
	}

	private static void drawLine(int n) {

		StringBuilder line = new StringBuilder();
		for (int i = 0; i < n * 2 + 1; i++)
			line.append('-');
		System.out.println(line.toString());
	}

}
