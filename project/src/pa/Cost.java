
package pa;

import java.util.Random;
import java.util.Scanner;

/**
 * The Cost class represents an n*m matrix for cost values.
 */
public class Cost implements ICost {
  private int[][] matrix;
  private int n;
  private int m;

  /**
   * Constructs a Cost object with the specified dimensions.
   *
   * @param n The number of rows.
   * @param m The number of columns.
   */
  public Cost(int n, int m) {
    this.n = n;
    this.m = m;
    matrix = new int[n][m];
    fillRandom();
  }

  /**
   * Constructs a Cost object with the specified dimensions and values.
   *
   * @param scanner The scanner to read the matrix values from.
   * @param n       The number of rows.
   * @param m       The number of columns.
   */
  public Cost(Scanner scanner, int n, int m) {
    this.n = n;
    this.m = m;
    matrix = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }
  }

  /**
   * Fills the matrix with random values.
   */
  private void fillRandom() {
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = random.nextInt(10) + 1; // Random number from 1 to 10
      }
    }
  }

  /**
   * Sets the value of the matrix at the specified row and column.
   *
   * @param row   The row index.
   * @param col   The column index.
   * @param value The value to set.
   */
  @Override
  public void setValue(int row, int col, int value) {
    matrix[row][col] = value;
  }

  /**
   * Returns the matrix.
   *
   * @return the matrix
   */
  @Override
  public int[][] getMatrix() {
    return matrix;
  }

  /**
   * Returns the value of the matrix at the specified row and column.
   *
   * @param row The row index.
   * @param col The column index.
   * @return The value at the specified row and column.
   */
  @Override
  public int getValue(int row, int col) {
    return matrix[row][col];
  }

  /**
   * Prints the matrix.
   */
  @Override
  public void printMatrix() {
    System.out.println("Matrix:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * Sets the matrix.
   *
   * @param matrix2 The matrix to set.
   */
  @Override
  public void setMatrix(int[][] matrix2) {
    this.matrix = matrix2;
  }
}
