package leetcode.arrays.dp;

public class q53 {

  public static void main(String[] args) {
    int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    q53 test = new q53();
    int ans = test.maxSubArray(a);
    System.out.println(ans);
  }

  public int maxSubArray(int[] nums) {

    int maxSoFar = 0;
    int max = 0;
    boolean allNegative = false;
    int maxNumber = nums[0];

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 0) {
        allNegative = false;
      } else {
        maxNumber = Math.max(nums[i], maxNumber);
      }
      maxSoFar = Math.max(0, maxSoFar + nums[i]);
      max = Math.max(max, maxSoFar);
    }

    return allNegative ? maxNumber : max;
  }
}
