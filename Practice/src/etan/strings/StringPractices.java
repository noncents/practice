// $Id$
package etan.strings;

import java.util.HashMap;

/**
 * <br>
 * <br>
 * Copyright (c) 2013 MICROS Corporation
 * 
 * @author etan
 * @created Sep 22, 2013
 * @version $Revision$
 */
public class StringPractices {

  public static final int MAX_DIGITS = 10;

  // Convert signed integer to String
  public static String convIntToString(int argInt) {

    // Java library to convert int to string - easiest way
    // return String.valueOf(argInt);
    char[] strChar = new char[MAX_DIGITS];
    boolean isNeg = false;
    int i = 0;
    StringBuilder str = new StringBuilder();

    if (argInt < 0) {
      isNeg = true;
      argInt *= -1;
    }
    do {
      strChar[i++ ] = (char) ((argInt % 10) + '0');
      argInt /= 10;
    }
    while (argInt != 0);

    StringBuilder strBuild = new StringBuilder();

    if (isNeg) {
      strBuild.append("-");
    }
    while (i > 0) {
      strBuild.append(strChar[ --i]);
    }

    return strBuild.toString();
  }

  // Convert String to signed integer
  public static int convStringToInt(String argStr) {
    // Java library to convert string to int - easiest way
    // return Integer.parseInt(argStr);

    int i = 0;
    int total = 0;
    boolean isNeg = false;

    if (argStr.charAt(i) == '-') {
      isNeg = true;
      ++i;
    }
    while (i < argStr.length()) {
      total *= 10;
      total += (argStr.charAt(i) - '0');
      ++i;
    }
    if (isNeg) {
      total *= -1;
    }

    return total;
  }

  public static void main(String[] args) {
    // Remove a character from a String
    // String str = "Hello Dear";
    // System.out.println(removeChar(str, 'e'));

    // Remove set of characters from String
    // String str = "Battle of the Vowels:Hawaii vs. Grozny";
    // String remove = "aeiuo";
    // System.out.println(removeChars(str, remove));

    // Remove set of characters from String
    // String str = "Battle of the Vowels:Hawaii vs. Grozny";
    // System.out.println(removeChar2(str, 'e'));

    // Get the first nonrepeated character in a String
    // String strFirst = "aaaabbbcccddddxdd";
    // Character a = getFirstNonRepeatedChar("aaaabbbcccddddxdd");
    // String b = a == null ? "No NonRepeated Char" : a.toString();
    // System.out.println(b);

    // String str = "Battle of the Vowels:Hawaii vs. Grozny";
    // // System.out.println(reverseWords(str.toCharArray()));
    // System.out.println(reverseWordsInPlace(str.toCharArray()));

    // Convert String to signed int and vice versa
    String strStr = "-1234";
    int strInt = 0;
    System.out.println(convStringToInt(strStr));
    System.out.println(convIntToString(strInt));
  }

  public static String removeChar(String argStr, char argChar) {
    // If parameter is Character
    // return argStr.replaceAll(argChar.toString(), "");

    StringBuilder newString = new StringBuilder();

    int len = argStr.length();
    for (int i = 0; i < len; i++ ) {
      if (argStr.charAt(i) != argChar) {
        newString.append(argStr.charAt(i));
      }
    }

    return newString.toString();
  }

  public static String removeChar2(String argStr, char argChar) {
    int dst = 0;
    int src = 0;

    char[] strChar = argStr.toCharArray();

    while (src < argStr.length()) {
      if (argStr.charAt(src) != argChar) {
        strChar[dst++ ] = strChar[src];
      }
      ++src;
    }

    return new String(strChar, 0, dst);
  }

  // Remove set of chars from string
  public static String removeChars(String str, String remove) {
    char[] s = str.toCharArray();
    char[] r = remove.toCharArray();
    boolean[] flags = new boolean[128];
    int len = r.length;
    int src, dst;

    // Set flags for characters to be removed
    for (src = 0; src < len; src++ ) {
      flags[r[src]] = true;
    }

    src = 0;
    dst = 0;

    // Now loop through all the characters, copying only if they aren;t flagged.
    while (src < s.length) {
      if (!flags[s[src]]) {
        s[dst++ ] = s[src];
      }
      ++src;
    }

    return new String(s, 0, dst);
  }

  public static void reverseString(final char[] str, int start, int end) {
    char temp;
    while (start < end) {
      temp = str[start];
      str[start] = str[end];
      str[end] = temp;
      ++start;
      --end;
    }
  }

  // Reverse the words using extra memory buffer
  public static String reverseWords(char[] str) {
    StringBuilder strBuild = new StringBuilder();
    int i = str.length - 1;

    while (i >= 0) {
      int end = 0;
      int start = i;
      while (i > -1 && str[i] != ' ') {
        --i;
        ++end;
      }
      start = i + 1;
      if (start >= 0) {
        strBuild.append(new String(str, start, end));
        strBuild.append(' ');
        i-- ;
      }
    }
    return strBuild.toString();
  }

  // Reverse the words in place
  public static String reverseWordsInPlace(char[] str) {
    reverseString(str, 0, str.length - 1);

    int i = 0;
    int start = 0;
    while (i < str.length - 1) {
      if (str[i] == ' ') {
        reverseString(str, start, i - 1);
        ++i;
        start = i;
      }
      else {
        ++i;
      }
    }
    reverseString(str, start, i);

    return new String(str);
  }

  // Print the first nonRepated character in a string.
  private static Character getFirstNonRepeatedChar(String argString) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int length = argString.length();

    for (int i = 0; i < length; i++ ) {
      Integer charCnt = map.get(argString.charAt(i));
      if (charCnt == null) {
        map.put(argString.charAt(i), 1);
      }
      else {
        map.put(argString.charAt(i), charCnt + 1);
      }
    }

    for (int i = 0; i < length; i++ ) {
      Integer count = map.get(argString.charAt(i));
      if (count == 1) {
        return argString.charAt(i);
      }
    }

    return null;
  }

  // Simplified version of Print the first nonRepated character in a string.
  private static Character getFirstNonRepeatedChar2(String argString) {
    HashMap<Character, Object> map = new HashMap<Character, Object>();
    Object seenOnce = new Object();
    Object seenTwice = new Object();

    for (int i = 0; i < argString.length(); i++ ) {
      if (map.get(argString.charAt(i)) == null) {
        map.put(argString.charAt(i), seenOnce);
      }
      else {
        map.put(argString.charAt(i), seenTwice);
      }
    }

    for (int i = 0; i < argString.length(); i++ ) {
      if (map.get(argString.charAt(i)) == seenTwice) {
        return argString.charAt(i);
      }
    }

    return null;
  }
}
