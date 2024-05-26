package rand;

public class myMath {

  private static CustomRandom customRandom = new CustomRandom();
  private static double mu;
  private static double rho;
  private static double delta;

  public myMath(double mu, double rho, double delta) {
    myMath.mu = mu;
    myMath.rho = rho;
    myMath.delta = delta;
  }

  // Exemplo de método para a lei de morte
  public static double deathRate(double confort) {
    return customRandom.nextExponential((1 - Math.log(1 - confort)) * mu);
  }

  // Exemplo de método para a lei de reprodução
  public static double reproductionRate(double confort) {
    return customRandom.nextExponential((1 - Math.log(confort)) * rho);
  }

  // Exemplo de método para a lei de mutação
  public static double mutationRate(double confort) {
    return customRandom.nextExponential((1 - Math.log(confort)) * delta);
  }
}
