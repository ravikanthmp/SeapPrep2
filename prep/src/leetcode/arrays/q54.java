package leetcode.arrays;

import java.util.List;

public class q54 {

  public static void main(String[] args) {
    int[][] ans = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    q54 test = new q54();
    List<Integer> integers = test.spiralOrder(ans);
    for (Integer i : integers) {
      System.out.println(i);
    }
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    return null;

  }


  enum Direction {

  }

  class SpiralTraverser {

    int topLimit, bottomLimit, leftLimit, rightLimit;
    int[][] matrix;
    Direction dir;

    public SpiralTraverser(int[][] matrix) {
      this.topLimit = 0;
      this.bottomLimit = matrix.length - 1;
      this.leftLimit = 0;
      this.rightLimit = matrix[0].length - 1;
    }

    public int nextElement() {
      return 0;
    }
  }

}
