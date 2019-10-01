package leetcode.arrays.linkedlist;

public class q141 {

  public boolean hasCycle(ListNode head) {

    ListNode slow = head, fast = head.next;

    while (slow != null && fast.next != null) {

      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }

    }

    return false;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }


}
