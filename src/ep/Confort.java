package ep;

/**
 * The Confort class provides functionality for calculating the minimum time
 * for a given matrix.
 */
public class Confort {
  
  private int[][] matrix;
  public static int tmin;

  /**
   * Constructs a Confort object with the specified matrix.
   *
   * @param matrix the matrix to calculate t_min
   */
  public Confort(int[][] matrix) {
    this.matrix = matrix;
    Confort.tmin = calculateTmin();
  }

  /**
   * Method to get the minimum time for the matrix
   *
   * @return the minimum time for the matrix
   */
  private int calculateTmin() {
    int tmin = 0;
    for (int j = 0; j < matrix.length; j++) {
      int minTime = Integer.MAX_VALUE;
      for (int i = 0; i < matrix[j].length; i++) {
        minTime = Math.min(minTime, matrix[j][i]);
      }
      tmin += minTime;
    }
    return tmin / matrix.length;
  }
}
