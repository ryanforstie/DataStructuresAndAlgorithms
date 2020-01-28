
public class Memoization {

  // Fibonacci w/out memoization
  // Time - O(2^n)
  // Space - O(n)
  public static int fib(int n) {
    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fib(n - 1) + fib(n - 2);
    }
  }

  // Fibonacci w/ memoization
  // Time - O(n)
  // Space - O(n)
  public static int memoFib(int n, int[] memo) {
    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (memo[n]) {
      memo[n] = memoFib(n - 1, memo) + memoFib(n - 2, memo);
    }
    return memo[n];
  }

  // Count number of paths recursive
  // Time - O(2^(n^2))
  int countPaths(boolean[][] grid, int row, int col) {
    if (!validSquare(grid, row, col))
      return 0;
    if (isAtEnd(grid, row, col))
      return 1;
    return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
  }

  // Count number of paths memoization
  // Time O(n^2)
  int countPathsMemo(boolean[][] grid, int row, int col, int[][] paths) {
    if (!validSqaure(grid, row, col))
      return 0;
    if (isAtEnd(grid, row, col))
      return 1;
    if (paths[row][col] == 0) {
      paths[row][col] = countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
    }
    return paths[row][col];
  }

}