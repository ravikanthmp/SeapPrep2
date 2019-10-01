package leetcode.arrays.sortingandsearching;

import java.util.Arrays;

public class q75 {

  public static void main(String[] args) {
    q75 test = new q75();
    int[] a = {1, 3, 4, 5, 6, 1, 2, 3, 4};
    test.sortColors(a);
    System.out.println(Arrays.toString(a));
  }

  public void sortColors(int[] nums) {
    sortColors(nums, 0, nums.length - 1);
  }

  private void sortColors(int[] nums, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int k = partition(nums, lo, hi);
    sortColors(nums, lo, k - 1);
    sortColors(nums, k + 1, hi);
  }

  private int partition(int[] nums, int lo, int hi) {
    int lim = lo, i = lo + 1, pivot = nums[lo];
    while (i <= hi) {
      if (nums[i] <= pivot) {
        exch(nums, i++, ++lim);
      } else {
        i++;
      }
    }

    exch(nums, lo, lim);
    return lim;
  }

  private void exch(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
