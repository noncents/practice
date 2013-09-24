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

  public static void main(String[] args) {
    // Remove a character from a String
    // String str = "Hello Dear";
    // System.out.println(removeChar(str, 'e'));

    // Remove set of characters from String
    // String str = "Battle of the Vowels:Hawaii vs. Grozny";
    // String remove = "aeiuo";
    // System.out.println(removeChars(str, remove));

    // Remove set of characters from String
    String str = "Battle of the Vowels:Hawaii vs. Grozny";
    System.out.println(removeChar2(str, 'e'));

    // Get the first nonrepeated character in a String
    // Character a = getFirstNonRepeatedChar("aaaabbbcccddddxdd");
    // String b = a == null ? "No NonRepeated Char" : a.toString();
    // System.out.println(b);

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

  public static String reverseWords(char str[]) {
    return null;
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
