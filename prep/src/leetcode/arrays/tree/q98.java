package leetcode.arrays.tree;

public class q98 {

  public static void main(String[] args) {

    q98 test = new q98();
    TreeNode root = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));
    System.out.println(test.isValidBST(root));
  }

  public boolean isValidBST(TreeNode root) {

    if (root == null) {
      return false;
    }

    return isValidBST(root.left, null, root.val) &&
        isValidBST(root.right, root.val, null);

  }

  private boolean isValidBST(TreeNode root, Integer min, Integer max) {

    if (root == null) {
      return true;
    }

    Integer rootVal = root.val;

    if (greaterThan(rootVal, min) && lessThan(rootVal, max)) {

      return isValidBST(root.left, min, rootVal) && isValidBST(root.right, rootVal, max);

    } else {
      return false;
    }

  }

  private boolean lessThan(Integer val, Integer max) {
    if (max == null) {
      return true;
    }
    return val.compareTo(max) < 0;
  }

  private boolean greaterThan(Integer val, Integer min) {
    if (min == null) {
      return true;
    }
    return val.compareTo(min) > 0;
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    public TreeNode(int i, TreeNode left, TreeNode right) {
      val = i;
      this.left = left;
      this.right = right;
    }
  }
}
