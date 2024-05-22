package pa;

public class Confort {
  private int[][] patrolTimes;
  private int numPatrols;
  private int numSystems;

  public Confort(int[][] patrolTimes, int numPatrols, int numSystems) {
    this.patrolTimes = patrolTimes;
    this.numPatrols = numPatrols;
    this.numSystems = numSystems;
  }

  // Método para calcular t_min
  private double calculateTmin() {
    double tmin = 0;
    for (int j = 0; j < numSystems; j++) {
      int minTime = Integer.MAX_VALUE;
      for (int i = 0; i < numPatrols; i++) {
        minTime = Math.min(minTime, patrolTimes[i][j]);
      }
      tmin += minTime;
    }
    return tmin / numPatrols;
  }

  // Método para calcular o conforto phi(z)
  public double calculateComfort(int[] individualPatrolTimes) {
    double tmin = calculateTmin();
    int tz = 0;
    for (int time : individualPatrolTimes) {
      tz += time;
    }
    return tmin / tz;
  }
}
