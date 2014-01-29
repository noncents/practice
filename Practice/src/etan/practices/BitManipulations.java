// $Id$
package etan.practices;

/**
 * <br>
 * <br>
 * Copyright (c) 2014 MICROS Corporation
 * 
 * @author etan
 * @created Jan 17, 2014
 * @version $Revision$
 */
public class BitManipulations {

  public static void main(String[] args) {

    System.out.println(Integer.toBinaryString(insertNtoM(0b10000000000, 0b10011, 2, 6)));
  }

  private static int insertNtoM(int N, int M, int iPos, int jPos) {

    int masker = 0b1111111111111111111111111111111;

    masker = masker >> (32 - (jPos - iPos + 1));
    masker = masker << iPos;
    masker = ~masker;

    N = N & masker;

    M = M << iPos;

    N = N | M;

    return N;
  }

}