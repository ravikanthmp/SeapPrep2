package leetcode.arrays.linkedlist;

import java.util.PriorityQueue;

public class q23 {

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Pair> minPQ = new PriorityQueue<>();

    // init
    for (int i = 0; i < lists.length; i++) {
      ListNode list = lists[i];
      if (list != null) {
        minPQ.add(new Pair(list));
      }
    }

    // keep removing
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (!minPQ.isEmpty()) {
      Pair min = minPQ.remove();
      curr.next = new ListNode(min.currNode.val);
      curr = curr.next;
      if (min.currNode.next != null) {
        minPQ.add(new Pair(min.currNode.next));
      }
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

  class Pair implements Comparable<Pair> {

    ListNode currNode;

    public Pair(ListNode list) {
      currNode = list;
    }

    @Override
    public int compareTo(Pair o) {
      return Integer.compare(currNode.val, o.currNode.val);
    }
  }

}
