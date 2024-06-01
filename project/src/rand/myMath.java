package rand;

/**
 * The myMath class provides a custom math library.
 */
public class myMath {

  private static CustomRandom customRandom = new CustomRandom();
  private static double mu;
  private static double rho;
  private static double delta;

  /**
   * Constructs a myMath object with specified parameters.
   *
   * @param mu    The death rate.
   * @param rho   The reproduction rate.
   * @param delta The mutation rate.
   */
  public myMath(double mu, double rho, double delta) {
    myMath.mu = mu;
    myMath.rho = rho;
    myMath.delta = delta;
  }

  /**
   * Gets the death rate for an individual based on their comfort level.
   *
   * @param confort The comfort of the individual.
   * @return The death rate for the individual.
   */
  public static double deathRate(double confort) {
    return customRandom.nextExponential((1 - Math.log(1 - confort)) * mu);
  }

  /**
   * Gets the reproduction rate for an individual based on their comfort level.
   *
   * @param confort The comfort of the individual.
   * @return The reproduction rate for the individual.
   */
  public static double reproductionRate(double confort) {
    return customRandom.nextExponential((1 - Math.log(confort)) * rho);
  }

  /**
   * Gets the mutation rate for an individual based on their comfort level.
   *
   * @param confort The comfort of the individual.
   * @return The mutation rate for the individual.
   */
  public static double mutationRate(double confort) {
    return customRandom.nextExponential((1 - Math.log(confort)) * delta);
  }
}
