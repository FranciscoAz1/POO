package ep;

/**
 * The Confort class provides functionality for calculating the minimum time
 * for a given matrix.
 */
public class Confort {

  private int[][] array;
  public static double tmin;

  /**
   * Constructs a Confort object with the specified matrix.
   * it iniitiates static variable tmin
   *
   * @param matrix the matrix to calculate t_min
   */
  public Confort(int[][] matrix) {
    this.array = matrix;
    Confort.tmin = calculateTmin();
  }

  /**
   * Method to get the minimum time for the matrix
   *
   * @return the minimum time for the matrix
   */
  private double calculateTmin() {
    int numRows = array.length;
    int numCols = array[0].length;
    int sumOfMins = 0;

    // Iterate over each column
    for (int col = 0; col < numCols; col++) {
      int min = array[0][col];

      // Find the minimum value in the current column
      for (int row = 1; row < numRows; row++) {
        if (array[row][col] < min) {
          min = array[row][col];
        }
      }

      // Add the minimum value to the sum
      sumOfMins += min;
    }

    // Calculate the average
    double average = (double) sumOfMins;
    return average;
  }
}
