package rand;

import java.util.Random;

/**
 * The CustomRandom class provides a custom random number generator.
 */
public class CustomRandom {
  private Random random;


  /**
   * Constructs a CustomRandom object.
   */
  public CustomRandom() {
    random = new Random();
  }


  /**
   * Method to get the next random integer.
   *
   * @return the next random integer
   */
  public double nextExponential(double mean) {
    return -mean * Math.log(random.nextDouble());
  }

  // Outros métodos personalizados podem ser adicionados aqui
}
