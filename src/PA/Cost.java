
package pa;

import java.util.Random;
import java.util.Scanner;

/**
 * The CostMatrix class represents an n*m matrix for cost values.
 */
public class Cost {
  private int[][] matrix;
  private int n;
  private int m;

  /**
   * Constructs a CostMatrix object with the specified dimensions.
   *
   * @param n the number of rows
   * @param m the number of columns
   */
  public Cost(int n, int m) {
    this.n = n;
    this.m = m;
    matrix = new int[n][m];
    fillRandom();
  }

  /**
   * Constructs a CostMatrix object with the specified dimensions and values.
   *
   * @param n the number of rows
   * @param m the number of columns
   * @param matrix the matrix of cost values
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
   * @param row the row index
   * @param col the column index
   * @param value the value to set
   */
  public void setValue(int row, int col, int value) {
    matrix[row][col] = value;
  }

  /**
   * Returns the matrix.
   *
   * @return the matrix
   */
  public int[][] getMatrix() {
    return matrix;
  }

  /**
   * Returns the value of the matrix at the specified row and column.
   *
   * @param row the row index
   * @param col the column index
   * @return the value at the specified row and column
   */
  public int getValue(int row, int col) {
    return matrix[row][col];
  }

  /**
   * Prints the matrix.
   */
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
   * @param matrix2 the matrix to set
   */
  public void setMatrix(int[][] matrix2) {
    this.matrix = matrix2;
  }

}
