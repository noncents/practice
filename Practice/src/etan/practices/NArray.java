// $Id$
package etan.practices;

/**
 * <br>
 * <br>
 * Copyright (c) 2013 MICROS Corporation
 * 
 * @author etan
 * @created Sep 21, 2013
 * @version $Revision$
 */
public class NArray {

  public static int intArr[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

  /**
   * @param args
   */
  public static void main(String[] args) {

    printNArray(intArr);
  }

  public static void printNArray(int arr[][]) {

    int x = (arr[0].length / 2) - 1;
    int y = x;

    int multiplier = 1;

    System.out.print(arr[x][y] + " ");

    for (int i = 1; i <= arr[0].length; i++ ) {

      for (int j = 1; j <= i; j++ ) {
        x = x + (multiplier);
        System.out.print(arr[x][y] + " ");
      }

      if (i < arr[0].length) {
        for (int j = 1; j <= i; j++ ) {
          y = y + (multiplier);
          System.out.print(arr[x][y] + " ");

        }
      }
      multiplier *= -1;
    }
  }
}
