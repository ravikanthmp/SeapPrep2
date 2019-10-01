package leetcode.arrays;

import java.util.Arrays;

public class q73 {

  public static void main(String[] args) {
    int[][] ans = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    q73 test = new q73();
    test.setZeroes(ans);
  }

  public void setZeroes(int[][] matrix) {

    int row = 0, col = 0;
    int ROWS = matrix.length;
    int COLS = matrix[0].length;

    boolean shouldEraseFirstRow = matrix[0][0] == 0;
    boolean shouldEraseFirstColumn = matrix[0][0] == 0;

    for (int j = 1; j < COLS; j++) {
      if (matrix[0][j] == 0) {
        shouldEraseFirstRow = true;
      }
    }

    for (int i = 1; i < ROWS; i++) {
      if (matrix[i][0] == 0) {
        shouldEraseFirstColumn = true;
      }
    }

    // Remaining
    for (int i = 1; i < ROWS; i++) {
      for (int j = 1; j < COLS; j++) {

        // check row = 0, col = i
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < ROWS; i++) {
      for (int j = 1; j < COLS; j++) {

        // check row = 0, col = i
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (shouldEraseFirstRow) {
      Arrays.fill(matrix[0], 0);
    }

    if (shouldEraseFirstColumn) {
      for (int i = 0; i < ROWS; i++) {
        matrix[i][0] = 0;
      }
    }


  }

}
