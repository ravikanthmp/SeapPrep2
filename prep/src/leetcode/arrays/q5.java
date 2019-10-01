package leetcode.arrays;

public class q5 {

  public static void main(String[] args) {
    q5 test = new q5();
    //String answer = test.longestPalindrome("ccc");
    System.out.println(test.longestPalindrome("aaaa"));
  }

  public String longestPalindrome(String s) {
    if (s.isEmpty()) {
      return "";
    }
    if (s.length() == 1) {
      return s;
    }
    Soln soln = lpsInternal(s);
    return s.substring(soln.start, soln.end + 1);
  }

  private Soln lpsInternal(String s) {
    int maxSoFar = 1;

    Soln soln = new Soln(0, 0);

    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int expandSingle = (expand(s, i));
      int expandDouble = expand(s, i, i + 1);

      if (expandSingle > maxSoFar) {
        soln.start = i - ((expandSingle - 1) / 2);
        soln.end = i + ((expandSingle - 1) / 2);
        soln.size = expandSingle;
        maxSoFar = expandSingle;
      }

      if (expandDouble > maxSoFar) {
        soln.start = i - ((expandDouble - 2) / 2);
        soln.end = i + 1 + ((expandDouble - 2) / 2);
        soln.size = expandDouble;
        maxSoFar = expandDouble;
      }

    }

    return soln;
  }

  private int expand(String s, int i, int j) {
    if (isInRange(s, i) && isInRange(s, j) && (s.charAt(i) == s.charAt(j))) {

      int max = 2;

      int right = j + 1, left = i - 1;
      while (left >= 0 && right < s.length()) {
        if (s.charAt(left) == s.charAt(right)) {
          max += 2;
          right++;
          left--;
        } else {
          break;
        }
      }
      return max;


    } else {
      return 0;
    }
  }

  private int expand(String s, int i) {
    int max = 1;
    int right = i + 1, left = i - 1;
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) == s.charAt(right)) {
        max += 2;
        right++;
        left--;
      } else {
        break;
      }
    }
    return max;
  }

  private boolean isInRange(String s, int i) {
    return (i >= 0 && i < s.length());
  }

  class Soln {

    int start, end, size;

    public Soln(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
