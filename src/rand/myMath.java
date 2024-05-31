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
   * @param mu the death rate
   * @param rho the reproduction rate
   * @param delta the mutation rate
   */
  public myMath(double mu, double rho, double delta) {
    myMath.mu = mu;
    myMath.rho = rho;
    myMath.delta = delta;
  }

  /**
   * Method to get the death rate for an individual.
   *
   * @param confort the confort of the individual
   * @return the death rate for the individual
   */
  public static double deathRate(double confort) {
    return customRandom.nextExponential((1 - Math.log(1 - confort)) * mu);
  }

  /**
   * Method to get the reproduction rate for an individual.
   *
   * @param confort the confort of the individual
   * @return the reproduction rate for the individual
   */
  public static double reproductionRate(double confort) {
    return customRandom.nextExponential((1 - Math.log(confort)) * rho);
  }

  /**
   * Method to get the mutation rate for an individual.
   *
   * @param confort the confort of the individual
   * @return the mutation rate for the individual
   */
  public static double mutationRate(double confort) {
    return customRandom.nextExponential((1 - Math.log(confort)) * delta);
  }
}
