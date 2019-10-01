package leetcode.arrays;

import java.util.Arrays;
import java.util.List;

public class Trie {

  private Node root;

  /**
   * Initialize your data structure here.
   */
  public Trie() {
    root = new Node();
  }

  public static void main(String[] args) {
    Trie trie2 = new Trie();
    List<String> list = Arrays.asList("ravi", "kanye", "rav", "kan", "ta", "tata", "tao");
    for (String s : list) {
      trie2.insert(s);
    }

    System.out.println(trie2.search("ravji"));
    System.out.println(trie2.startsWith("ta"));
    System.out.println(trie2.startsWith("tat"));

  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    root = insert(root, word, 0);
  }

  private Node insert(Node root, String word, int idx) {
    if (root == null) {
      root = new Node();
    }

    if (idx == word.length()) {
      root.value = 1;
    } else {
      char ch = word.charAt(idx);
      root.next[ch - 'a'] = insert(root.next[ch - 'a'], word, idx + 1);
    }

    return root;

  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    int idx = 0;
    for (Node curr = root; curr != null; ) {
      if (idx == word.length()) {
        return (curr.value == 1);
      } else {
        curr = curr.next[word.charAt(idx) - 'a'];
        idx++;
      }
    }
    return false;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    int idx = 0;
    for (Node curr = root; curr != null; ) {
      if (idx == prefix.length()) {
        return true;
      } else {
        curr = curr.next[prefix.charAt(idx) - 'a'];
        idx++;
      }
    }
    return false;
  }

  class Node {

    Node[] next;
    int value;

    public Node() {
      next = new Node[26];
    }
  }
}

