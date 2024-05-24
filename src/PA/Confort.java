package pa;

public class Confort {
  private int[][] matrix;

  public static int tmin;

  public Confort(int[][] matrix) {
    this.matrix = matrix;
    Confort.tmin = calculateTmin();
  }

  // Método para calcular t_min
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
