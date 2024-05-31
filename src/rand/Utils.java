package rand;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * The Utils class provides utility methods for random number generation.
 */
public class Utils {
  private static final Random random = new Random(); // Initialize Random object

  /**
   * Generic method to get a random element from a list
   *
   * @param bound the upper bound (exclusive)
   * @return a random integer
   */
  public static <T> T getRandomElement(List<T> list) {
    if (list == null || list.isEmpty()) {
      throw new IllegalArgumentException("The list must not be null or empty");
    }
    int randomIndex = random.nextInt(list.size()); // Get a random index
    return list.get(randomIndex); // Return the element at the random index
  }

  /**
   * Generic method to get a random integer
   *
   * @param bound the upper bound (exclusive)
   * @return a random integer
   */
  public static <T> T getRandomElementFromSet(Set<T> set) {
    int index = random.nextInt(set.size());
    Iterator<T> iter = set.iterator();
    for (int i = 0; i < index; i++) {
      iter.next();
    }
    return iter.next();
  }
}
