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
   * Generates the next random number following an exponential distribution with
   * the specified mean.
   * 
   * @param mean The mean of the exponential distribution.
   * @return The next random number following an exponential distribution.
   */
  public double nextExponential(double mean) {
    return -mean * Math.log(random.nextDouble());
  }

}
