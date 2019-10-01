package leetcode.arrays.linkedlist;


public class q445 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int num1 = getNumber(l1);
    int num2 = getNumber(l2);
    int sum = num1 + num2;
    ListNode ans = toList(sum);
    return reverse(ans);

  }

  private ListNode reverse(ListNode ans) {

    ListNode dummyHead = new ListNode(0);

    while (ans != null) {

      int digit = ans.val % 10;

      ListNode newNode = new ListNode(digit);

      newNode.next = dummyHead.next;
      dummyHead.next = newNode;

      ans = ans.next;
    }
    return dummyHead.next;
  }

  private ListNode toList(int sum) {
    ListNode ans = new ListNode(0);
    ListNode dummy = ans;

    while (sum > 0) {
      ans.next = new ListNode(sum % 10);
      sum /= 10;
    }

    return dummy.next;
  }

  private int getNumber(ListNode node) {
    if (node == null) {
      return 0;
    }
    int total = 0;

    while (node != null) {
      total = total * 10 + node.val;
    }

    return total;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

}
