package leetcode.arrays;

public class q48 {

  public static void main(String[] args) {
    int[][] ans = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    q48 test = new q48();
    test.rotate(ans);
  }

  public void rotate(int[][] matrix) {

    transformMatrix(matrix);
    rotateRows(matrix);
  }

  private void rotateRows(int[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
      reverseRow(matrix[i]);
    }

  }

  private void reverseRow(int[] matrix) {
    int i = 0, j = matrix.length - 1;
    while (i < j) {
      exch(matrix, i++, j--);
    }

  }

  private void transformMatrix(int[][] matrix) {
    int row = 0, col = 0;
    int ROWS = matrix.length;
    int COLS = matrix[0].length;

    for (int i = 0; i < ROWS; i++) {
      for (int j = i + 1; j < COLS; j++) {
        exch(matrix, i, j);
      }
    }
  }

  private void exch(int[][] matrix, int i, int j) {
    int temp = matrix[i][j];

    matrix[i][j] = matrix[j][i];

    matrix[j][i] = temp;
  }

  private void exch(int[] row, int i, int j) {
    int temp = row[i];
    row[i] = row[j];
    row[j] = temp;
  }
}
