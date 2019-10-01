package leetcode.arrays.linkedlist;

public class q2 {

  public static void main(String[] args) {
    q2 test = new q2();
    ListNode list = test.createList(100);
    ListNode list1 = test.createList(234);
    ListNode listNode = test.addTwoNumbers(list1, list);
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode dummy = new ListNode(0);
    int carry = 0;

    ListNode prevNode = dummy;

    while (l1 != null && l2 != null) {

      int sum = getVal(l1) + getVal(l2) + carry;

      prevNode.next = new ListNode(sum % 10);

      prevNode = prevNode.next;

      carry = sum / 10;

      l1 = next(l1);

      l2 = next(l2);
    }

    if (carry != 0) {

      prevNode.next = new ListNode(carry);
    }

    return dummy.next;

  }

  private int getVal(ListNode node) {
    return node == null ? 0 : node.val;
  }

  private ListNode next(ListNode node) {
    return node == null ? null : node.next;
  }

  private ListNode createList(int num) {
    ListNode dummy = new ListNode(0);

    while (num > 0) {
      dummy.next = new ListNode(num % 10);
      num /= 10;
      dummy = dummy.next;
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
