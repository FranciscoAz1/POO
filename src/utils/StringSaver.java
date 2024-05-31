package utils;

public class StringSaver {
  private static String savedString;

  /**
   * Sets the string.
   * 
   * @param str the string to save
   */
  public static void setString(String str) {
    savedString = str;
  }

  /**
   * Gets the saved string.
   * 
   * @return the saved string
   */
  public static String getString() {
    return savedString;
  }
}
