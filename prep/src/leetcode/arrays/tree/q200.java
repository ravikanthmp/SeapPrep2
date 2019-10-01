package leetcode.arrays.tree;

public class q200 {

  public int numIslands(char[][] grid) {

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j]) {
          count++;
          dfs(grid, i, j, visited);
        }
      }
    }
    return count;
  }

  private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
    visited[i][j] = true;

    if (isValid(grid, i, j + 1, visited)) {
      dfs(grid, i, j + 1, visited);
    }

    if (isValid(grid, i + 1, j, visited)) {
      dfs(grid, i + 1, j, visited);
    }

    if (isValid(grid, i, j - 1, visited)) {
      dfs(grid, i, j - 1, visited);
    }

    if (isValid(grid, i - 1, j, visited)) {
      dfs(grid, i - 1, j, visited);
    }
  }

  private boolean isValid(char[][] grid, int i, int j, boolean[][] visited) {
    int ROWS = grid.length;
    int COLS = grid[0].length;

    return (i >= 0 && i < ROWS) && (j >= 0 && j < COLS && grid[i][j] == '1' && !visited[i][j]);
  }
}
