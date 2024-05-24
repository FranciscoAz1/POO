
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

  public Cost(int n, int m) {
    this.n = n;
    this.m = m;
    matrix = new int[n][m];
    fillRandom();
  }

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

  private void fillRandom() {
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = random.nextInt(10) + 1; // Random number from 1 to 10
      }
    }
  }

  public void setValue(int row, int col, int value) {
    matrix[row][col] = value;
  }

  public int[][] getMatrix() {
    return matrix;
  }

  public int getValue(int row, int col) {
    return matrix[row][col];
  }

  public void printMatrix() {
    System.out.println("Matrix:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void setMatrix(int[][] matrix2) {
    // TODO Auto-generated method stub
    this.matrix = matrix2;
  }

}
