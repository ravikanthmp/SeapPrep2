package leetcode.arrays.sortingandsearching;

import java.util.Arrays;

public class q33 {

  public int search(int[] nums, int target) {
    int pivot = findPivot(nums);

    if (pivot == 0) {
      return Arrays.binarySearch(nums, target);
    } else {
      int found = Arrays.binarySearch(nums, 0, pivot - 1, target);
      if (found == -1) {
        found = Arrays.binarySearch(nums, pivot, nums.length - 1, target);
      }
      return found;
    }

  }

  private int findPivot(int[] nums) {
    if (nums[0] < nums[nums.length - 1]) {
      return 0;
    } else {
      return findPivot(nums, 0, nums.length - 1);
    }

  }

  private int findPivot(int[] nums, int lo, int hi) {
    int size = (hi - lo + 1);
    if (size == 1) {
      return nums[lo];
    } else if (size == 2) {
      return nums[lo] < nums[hi] ? lo : hi;
    } else {
      int mid = lo + (hi - lo) / 2;
      if (mid < hi && nums[mid] > nums[mid + 1]) {
        return mid;
      } else if (lo < mid && nums[mid - 1] > nums[mid]) {
        return mid - 1;
      } else if (nums[lo] < nums[mid]) {
        return findPivot(nums, lo, mid - 1);
      } else {
        return findPivot(nums, mid + 1, hi);
      }
    }
  }
}
