package leetcode.arrays.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class q103 {

  public List<List<Integer>> levelOrder(TreeNode root) {

    Deque<TreeNode> parentLevel = new ArrayDeque<>(), childLevel = new ArrayDeque<>();
    List<Integer> levelAnsList = new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<>();

    TreeNode currNode;
    boolean isReverse = false;

    while (!parentLevel.isEmpty()) {

      while (!parentLevel.isEmpty()) {

        currNode = parentLevel.pop();
        levelAnsList.add(currNode.val);

        if (isReverse) {

          if (currNode.right != null) {
            childLevel.push(currNode.right);
          }

          if (currNode.left != null) {
            childLevel.push(currNode.left);
          }

        } else {

          if (currNode.left != null) {
            childLevel.push(currNode.left);
          }

          if (currNode.right != null) {
            childLevel.push(currNode.right);
          }

        }
      }

      ans.add(levelAnsList);
      parentLevel = childLevel;
      childLevel = new ArrayDeque<>();
      isReverse = !isReverse;

    }

    return ans;
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
