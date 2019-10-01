package leetcode.arrays.tree;

public class q105 {

  public static void main(String[] args) {

  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart,
      int inEnd) {
    if (preStart == preEnd) {
      return new TreeNode(preorder[preStart]);
    } else {
      // find where root is ??
      int root = preorder[preStart];

      int rootIndexInorder = find(inorder, inStart, inEnd, root);

      // left subtree size
      int leftSubTreeSize = rootIndexInorder - preStart + 1;

      // right subtree size
      int rightSubTreeSiz = (inEnd - inStart + 1) - 1 - leftSubTreeSize;

      // build root
      TreeNode treeNode = new TreeNode(root);

      // recursively build left subtree
      treeNode.left = build(preorder, inorder, preStart + 1, preStart + 1 + leftSubTreeSize,
          inStart, rootIndexInorder - 1);

      // recursively build right subtree
      treeNode.right = build(preorder, inorder, preEnd - rightSubTreeSiz + 1, preEnd,
          rootIndexInorder + 1, inEnd);

      return treeNode;

    }
  }

  private int find(int[] inorder, int inStart, int inEnd, int root) {
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == root) {
        return i;
      }
    }
    // should not reach here
    return -1;
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
