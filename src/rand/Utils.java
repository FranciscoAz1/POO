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
   * Returns a random element from a list.
   *
   * @param <T>  The type of elements in the list.
   * @param list The list from which to get a random element.
   * @return A random element from the list.
   * @throws IllegalArgumentException if the list is null or empty.
   */
  public static <T> T getRandomElement(List<T> list) {
    if (list == null || list.isEmpty()) {
      throw new IllegalArgumentException("The list must not be null or empty");
    }
    int randomIndex = random.nextInt(list.size()); // Get a random index
    return list.get(randomIndex); // Return the element at the random index
  }

  
  /**
   * Returns a random element from a set.
   *
   * @param <T> The type of elements in the set.
   * @param set The set from which to get a random element.
   * @return A random element from the set.
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
