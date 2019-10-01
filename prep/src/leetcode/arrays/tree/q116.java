package leetcode.arrays.tree;

public class q116 {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right = new Node(3);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    q116 test = new q116();
    test.connect(root);


  }

  ;

  public Node connect(Node root) {

    Node parent = root;
    Node childHead = null;
    Node child = null;

    while (parent != null) {

      while (parent != null) {

        if (parent.left != null) {

          if (childHead == null) {
            childHead = parent.left;
            child = childHead;
          } else {
            child.next = parent.left;
            child = child.next;
          }

        }

        if (parent.right != null) {

          if (childHead == null) {
            childHead = parent.right;
            child = childHead;
          } else {
            child.next = parent.right;
            child = child.next;
          }
        }

        parent = parent.next;

      }

      parent = childHead;
      childHead = null;

    }

    return root;

  }

  static class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
      this.val = val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

}
