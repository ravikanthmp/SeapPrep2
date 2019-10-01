package leetcode.arrays.tree;

public class q235 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    return lca(root, p, q);
  }

  private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

    if (isBetween(root, p, q)) {
      return root;
    } else if (isRootLess(root, p, q)) {
      return lca(root.right, p, q);
    } else if (isRootMore(root, p, q)) {
      return lca(root.left, p, q);
    } else {
      return root;
    }
  }

  private boolean isRootLess(TreeNode root, TreeNode p, TreeNode q) {
    return root.val < p.val && root.val < q.val;
  }

  private boolean isRootMore(TreeNode root, TreeNode p, TreeNode q) {
    return root.val > p.val && root.val > q.val;
  }

  private boolean isBetween(TreeNode root, TreeNode p, TreeNode q) {
    return p.val < root.val && root.val < q.val;
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

  class IntHolder {

    int count = 0;
  }


}
