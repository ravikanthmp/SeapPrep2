package leetcode.arrays.sortingandsearching;

public class q153 {


  public static void main(String[] args) {
    q153 test = new q153();
    System.out.println(test.findMin(new int[]{3, 1, 2}));
  }

  public int findMin(int[] nums) {
    if (nums[0] < nums[nums.length - 1]) {
      return nums[0];
    }
    return nums[findMin(nums, 0, nums.length - 1)];
  }

  private int findMin(int[] nums, int lo, int hi) {

    int size = (hi - lo + 1);
    if (size == 1) {
      return lo;
    } else if (size == 2) {
      return (nums[lo] <= nums[hi]) ? lo : hi;
    } else {
      int mid = lo + (hi - lo) / 2;
      if (mid < hi && nums[mid] > nums[mid + 1]) {
        return mid + 1;
      } else if (mid > lo && nums[mid] < nums[mid - 1]) {
        return mid;
      } else {
        return nums[lo] < nums[mid] ? findMin(nums, mid + 1, hi) : findMin(nums, lo, mid - 1);
      }
    }
  }

}
