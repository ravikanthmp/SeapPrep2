package leetcode.arrays.tree;

import java.util.LinkedList;
import java.util.List;

public class q102 {

  public List<List<Integer>> levelOrder(TreeNode root) {

    List<TreeNode> list = new LinkedList<>();
    List<List<Integer>> ansList = new LinkedList<>();

    List<Integer> childIntList = new LinkedList<>();

    if (root != null) {
      list.add(root);
      childIntList.add(root.val);
      ansList.add(childIntList);
    }

    List<TreeNode> parentList, childList;

    parentList = list;

    while (parentList != null && !parentList.isEmpty()) {

      childList = new LinkedList<>();
      childIntList = new LinkedList<>();

      for (TreeNode treeNode : parentList) {
        if (treeNode.left != null) {
          childList.add(treeNode.left);
          childIntList.add(treeNode.left.val);
        }
        if (treeNode.right != null) {
          childList.add(treeNode.right);
          childIntList.add(treeNode.right.val);
        }
      }

      ansList.add(childIntList);

      parentList = childList;
    }

    return ansList;
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
