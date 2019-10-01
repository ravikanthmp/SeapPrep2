package leetcode.arrays.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class q94 {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    if (root == null) {
      return list;
    }
    TreeNode curr = root;
    Deque<TreeNode> stack = new ArrayDeque();

    while (curr != null) {
      stack.push(curr);
      curr = curr.left;
    }

    while (true) {
      if (stack.isEmpty()) {
        break;
      }
      TreeNode nodeUnderProcessing = stack.pop();
      list.add(nodeUnderProcessing.val);
      if (nodeUnderProcessing.right != null) {
        curr = nodeUnderProcessing.right;
        while (curr != null) {
          stack.push(curr);
          curr = curr.left;
        }
      }
    }

    return list;
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
