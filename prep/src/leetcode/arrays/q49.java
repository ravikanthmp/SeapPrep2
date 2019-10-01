package leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class q49 {

  public static void main(String[] args) {

    String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
    q49 test = new q49();
    List<List<String>> lists = test.groupAnagrams(words);
    for (List<String> list : lists) {
      for (String s : list) {
        System.out.print(s + " ");
      }
      System.out.println();
    }
  }

  public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      if (!map.containsKey(key)) {
        map.put(key, new LinkedList<>());
      }
      map.get(key).add(str);
    }

    List<List<String>> ans = new LinkedList<>();
    for (String s : map.keySet()) {
      ans.add(map.get(s));
    }
    return ans;
  }

}
