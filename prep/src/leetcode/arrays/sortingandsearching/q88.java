package leetcode.arrays.sortingandsearching;

import java.util.Arrays;

public class q88 {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0, 0, 0, 0, 0};
    int m = 3;
    int[] nums2 = {2, 5, 6};
    int n = 3;

    q88 test = new q88();
    test.merge(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int i = m - 1, j = n - 1, k = nums1.length - 1;
    int cmp = 0;
    while (i >= 0 || j >= 0) {
      if (i < 0) {
        nums1[k] = nums2[j];
        j--;
      } else if (j < 0) {
        nums1[k] = nums1[i];
        i--;
      } else if (Integer.compare(nums1[i], nums2[j]) >= 0) {
        nums1[k] = nums1[i];
        i--;
      } else {
        nums1[k] = nums2[j];
        j--;
      }
      k--;
    }

    shift(nums1, 0, nums1.length - 1, nums1.length - m - n);
  }

  private void shift(int[] nums, int lo, int hi, int k) {

    reverse(nums, lo, hi);
    reverse(nums, lo, hi - k);
    reverse(nums, hi - k + 1, hi);

  }

  private void reverse(int[] nums, int lo, int hi) {
    int i = lo, j = hi;
    while (i < j) {
      exch(nums, i++, j--);
    }
  }

  private void exch(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
