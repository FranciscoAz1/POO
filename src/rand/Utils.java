package rand;

import java.util.List;
import java.util.Random;

public class Utils {
  private static final Random random = new Random(); // Initialize Random object

  // Generic method to get a random element from a list
  public static <T> T getRandomElement(List<T> list) {
    if (list == null || list.isEmpty()) {
      throw new IllegalArgumentException("The list must not be null or empty");
    }
    int randomIndex = random.nextInt(list.size()); // Get a random index
    return list.get(randomIndex); // Return the element at the random index
  }
}
