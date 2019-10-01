package leetcode.arrays.sortingandsearching;

import java.util.Arrays;

public class q26 {

  public static void main(String[] args) {
    int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    q26 test = new q26();
    int i = test.removeDuplicates(a);
    System.out.println(i);
    System.out.println(Arrays.toString(a));
  }

  public int removeDuplicates(int[] nums) {

    int j = 0;
    for (int i = 1; i < nums.length; ) {
      if (nums[i] == nums[j]) {
        i++;
      } else {
        exch(nums, i++, ++j);
      }
    }

    return j + 1;
  }

  private void exch(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
