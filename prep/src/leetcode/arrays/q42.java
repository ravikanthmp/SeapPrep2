package leetcode.arrays;

public class q42 {

  public static void main(String[] args) {
    int[] a = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    q42 test = new q42();
    int trap = test.trap(a);
    System.out.println(trap);
  }

  public int trap(int[] height) {
    int[] leftMaxHeights = leftMaxHeights(height);
    int[] rightMaxHeights = rightMaxHeights(height);
    int sum = 0;

    for (int i = 0; i < height.length; i++) {
      int currTrap = Math.max(0, Math.min(leftMaxHeights[i], rightMaxHeights[i]) - height[i]);
      sum += currTrap;
    }

    return sum;
  }

  private int[] leftMaxHeights(int[] a) {
    int[] leftMaxHeights = new int[a.length];

    int maxSoFar = 0;
    for (int i = 0; i < a.length; i++) {
      leftMaxHeights[i] = maxSoFar;
      maxSoFar = Math.max(maxSoFar, a[i]);
    }

    return leftMaxHeights;
  }

  private int[] rightMaxHeights(int[] a) {
    int[] rightMaxHeights = new int[a.length];

    int maxSoFar = 0;
    for (int i = a.length - 1; i >= 0; i--) {
      rightMaxHeights[i] = maxSoFar;
      maxSoFar = Math.max(maxSoFar, a[i]);
    }

    return rightMaxHeights;
  }

}
