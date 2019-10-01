package leetcode.arrays.backtracking;

public class q44 {

  public static void main(String[] args) {
    q44 test = new q44();
    System.out.println(test.isMatch("aa", "a"));
  }

  public boolean isMatch(String s, String p) {
    return isMatch(s, p, 0, 0);
  }

  private boolean isMatch(String s, String p, int sIdx, int pidx) {
    if (pidx == p.length()) {
      return sIdx == s.length();
    }

    boolean match = false;

    char patternChar = p.charAt(pidx);
    char textChar = s.charAt(sIdx);

    if (textChar == s.length()) {
      if (patternChar == '*') {
        return isMatch(s, p, sIdx, pidx + 1);
      } else {
        return false;
      }
    }

    if (patternChar == '*') {
      for (int i = sIdx + 1; i < s.length(); i++) {
        match = isMatch(s, p, sIdx + 1, pidx + 1);
        if (match) {
          return true;
        }
      }
    } else if (patternChar == '?') {
      return isMatch(s, p, sIdx + 1, pidx + 1);
    } else if (textChar == patternChar) {
      return isMatch(s, p, sIdx + 1, pidx + 1);
    }

    return false;
  }
}
