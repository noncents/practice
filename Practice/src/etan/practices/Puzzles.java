package etan.practices;

import java.util.HashMap;
import java.util.Map;

public class Puzzles {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // Get the first 2 sum in the array of the number given
    // getFirst2Sum(arr, 10);

    // Print all the proper paired pairs possible
    // bracketsPair(3);

    // Divide a number over the other without using mathematical operations
    int test = divideIT(25, 5);
    System.out.println(test);
  }

  // Print all the combination of n pairs of brackets. Should be balance.
  private static void bracketsPair(int pairs) {
    bracketsPair(" ", 0, 0, 3);
  }

  private static void bracketsPair(String output, int open, int close, int pair) {
    if (open == pair && close == pair) {
      System.out.println(output);
    }
    if (open < pair) {
      bracketsPair(output + "(", open + 1, close, pair);
    }
    if (close < open) {
      bracketsPair(output + ")", open, close + 1, pair);
    }
  }

  private static int divideIT(int argNumber, int argDiv) {
    int quotient = 0;
    if (argNumber < 0) {
      argNumber *= -1;
    }
    if (argNumber < argDiv) {
      return quotient;
    }
    while (argNumber >= argDiv) {
      int no = argDiv;
      int cnt = 0;
      while (argNumber >= no << 1) {
        cnt++ ;
        no = no << 1;
      }
      quotient += 1 << cnt;
      argNumber -= no;
    }

    return quotient;
  }

  // Print all the combination of n pairs of brackets. Should be balance.
  private static void get(int pairs) {
    bracketsPair(" ", 0, 0, 3);
  }

  private static void getAllSum(int[] argArray, int argNumber) {
    int start = 0;
    int end = 0;
    if (argArray.length > 0) {
      start = argArray[0];
      end = argArray.length;
    }

    while ((start + end < argNumber) && (start != end)) {

    }

    for (int i = 0; i < argArray.length; i++ ) {

    }
  }

  // Get the first 2 sum from an array
  private static void getFirst2Sum(int[] argArray, int argNumber) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < argArray.length; i++ ) {
      int diff = argNumber - i;
      if (map.get(diff) != null) {
        System.out.println(diff + " and " + i);
        break;
      }
      else {
        map.put(i, i);
      }
    }
  }
}
