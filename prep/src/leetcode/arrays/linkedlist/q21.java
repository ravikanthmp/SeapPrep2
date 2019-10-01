package leetcode.arrays.linkedlist;

public class q21 {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (l1 != null || l2 != null) {

      if (l1 == null) {
        curr.next = new ListNode(l2.val);
        l2 = l2.next;
      } else if (l2 == null) {
        curr.next = new ListNode(l1.val);
        l1 = l1.next;
      } else if (l1.val <= l2.val) {
        curr.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        curr.next = new ListNode(l2.val);
        l2 = l2.next;
      }

      curr = curr.next;
    }

    return dummy.next;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }


}
