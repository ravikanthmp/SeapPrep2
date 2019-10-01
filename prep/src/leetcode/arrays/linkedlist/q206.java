package leetcode.arrays.linkedlist;

public class q206 {

  public static void main(String[] args) {

  }

  public ListNode reverseList(ListNode head) {

    ListNode dummy = new ListNode(0);

    for (ListNode curr = head; curr != null; ) {
      ListNode temp = curr.next;
      curr.next = dummy.next;
      dummy.next = curr;

      curr = temp;
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
