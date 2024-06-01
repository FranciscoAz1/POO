package rand;

import java.util.Random;

/**
 * The RandomSingleton class provides a singleton random number generator.
 */
public class RandomSingleton {
  private static RandomSingleton instance = null;
  private Random random;

  /**
   * Constructs a RandomSingleton object.
   */
  private RandomSingleton() {
    random = new Random();
  }

  /**
   * Returns the instance of the RandomSingleton object.
   *
   * @return The instance of the RandomSingleton object.
   */
  public static RandomSingleton getInstance() {
    if (instance == null) {
      instance = new RandomSingleton();
    }
    return instance;
  }

  /**
   * Returns the random number generator.
   *
   * @return The random number generator.
   */
  public Random getRandom() {
    return random;
  }
}
