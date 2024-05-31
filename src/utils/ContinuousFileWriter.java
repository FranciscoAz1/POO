package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The ContinuousFileWriter class provides a utility for writing to a file
 * continuously.
 */
public class ContinuousFileWriter {
  private static FileWriter fileWriter;
  private static StringBuilder sb = new StringBuilder();

  /**
   * Initializes the ContinuousFileWriter with the specified base file name.
   * 
   * @param baseFileName the base name of the file to write to
   */
  public static void initialize(String baseFileName) {
    try {
      // Generate a unique file name by appending the current timestamp
      String uniqueFileName = generateUniqueFileName(baseFileName);
      // Initialize FileWriter in write mode (new file)
      fileWriter = new FileWriter(uniqueFileName, false);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method to generate a unique file name by appending the current timestamp.
   * 
   * @param baseFileName the base name of the file
   * @return the unique file name
   */
  private static String generateUniqueFileName(String baseFileName) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    String timestamp = sdf.format(new Date());
    return baseFileName + "_" + timestamp + ".txt";
  }

  /**
   * Method to write to the file.
   * 
   * @param text the text to write to the file
   */
  public static void writeToFile(String text) {
    sb.append(text);
    try {
      fileWriter.write(sb.toString());
      fileWriter.flush(); // Ensure data is written to the file immediately
      sb.setLength(0); // Clear the StringBuilder
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method to close the FileWriter when done.
   */
  public static void close() {
    try {
      if (fileWriter != null) {
        fileWriter.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // public static void main(String[] args) {
  // // Initialize the ContinuousFileWriter
  // ContinuousFileWriter.initialize("output");
  //
  // // Simulate some events that cause writing to the file
  // ContinuousFileWriter.writeToFile("Event 1 occurred.\n");
  // ContinuousFileWriter.writeToFile("Event 2 occurred.\n");
  // ContinuousFileWriter.writeToFile("Event 3 occurred.\n");
  //
  // // Close the writer when done
  // ContinuousFileWriter.close();
  // }
}
