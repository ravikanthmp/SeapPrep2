package leetcode.arrays.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q17 {

  public static void main(String[] args) {
    q17 test = new q17();
    List<String> list = test.letterCombinations("23");
    for (String s : list) {
      System.out.println(s);
    }
  }

  public List<String> letterCombinations(String digits) {

    Map<Character, List<Character>> map = new HashMap<>();
    map.put('2', Arrays.asList('a', 'b', 'c'));
    map.put('3', Arrays.asList('d', 'e', 'f'));
    map.put('4', Arrays.asList('g', 'h', 'i'));
    map.put('5', Arrays.asList('j', 'k', 'l'));
    map.put('6', Arrays.asList('m', 'n', 'o'));
    map.put('7', Arrays.asList('p', 'q', 'r', 's'));
    map.put('8', Arrays.asList('t', 'u', 'v'));
    map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

    List<String> results = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return results;
    }
    letterCombinationsUtil(digits, 0, new StringBuilder(), results, map);
    return results;
  }

  private void letterCombinationsUtil(String digits, int idx, StringBuilder stringBuilder,
      List<String> results,
      Map<Character, List<Character>> map) {
    if (idx == digits.length()) {
      results.add(new String(stringBuilder.toString()));
    } else {
      char c = digits.charAt(idx);
      List<Character> characters = map.get(c);

      for (Character character : characters) {
        // choose
        stringBuilder.append(character);

        // recurse
        letterCombinationsUtil(digits, idx + 1, stringBuilder, results, map);

        // unchoose
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

      }

    }
  }
}
