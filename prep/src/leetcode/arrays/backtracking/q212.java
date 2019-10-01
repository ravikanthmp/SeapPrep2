package leetcode.arrays.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q212 {

  public static void main(String[] args) {
    q212 test = new q212();
    char[][] board = {{'a', 'a'}};
    String[] words = {"aaa"};
    List<String> words1 = test.findWords(board, words);
  }

  public List<String> findWords(char[][] board, String[] words) {
    List<String> results = new ArrayList<>();

    Set<String> set = new HashSet<>();
    for (String word : words) {
      set.add(word);
    }

    String[] words2 = new String[set.size()];
    int k = 0;
    for (String s : set) {
      words2[k++] = s;
    }

    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        findWords(board, i, j, null, words2, results, visited);
      }
    }
    return results;
  }

  private void findWords(char[][] board, int row, int col, Trie trie, String[] words,
      List<String> results, boolean[][] visited) {
    for (String word : words) {
      findWord(board, row, col, trie, word, 0, results, visited);
    }
  }

  private boolean findWord(char[][] board, int row, int col, Trie trie, String word, int idx,
      List<String> results, boolean[][] visited) {

    if (row < 0 || row >= visited.length || col < 0 || col >= visited[0].length
        || visited[row][col]) {
      return false;
    }

    visited[row][col] = true;

    char c = word.charAt(idx);
    boolean found = false;

    if (board[row][col] == c) {

      if (idx == word.length() - 1) {
        if (!results.contains(word)) {
          results.add(word);
        }
        visited[row][col] = false;
        return true;
      }

      // right
      found = findWord(board, row, col + 1, trie, word, idx + 1, results, visited);

      // down
      if (!found) {
        found = findWord(board, row + 1, col, trie, word, idx + 1, results, visited);
      }

      // left
      if (!found) {
        found = findWord(board, row, col - 1, trie, word, idx + 1, results, visited);
      }

      // top
      if (!found) {
        found = findWord(board, row - 1, col, trie, word, idx + 1, results, visited);
      }

    } else {
      visited[row][col] = false;
      return false;
    }

    visited[row][col] = false;
    return found;
  }

  public class Trie {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
      root = new Node();
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

}
