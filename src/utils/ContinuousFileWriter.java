
package utils;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The ContinuousFileWriter class provides a utility for writing to a file
 * continuously.
 */
public class ContinuousFileWriter {
  private FileWriter fileWriter;
  private StringBuilder sb;

  /**
   * Constructs a ContinuousFileWriter object with the specified file name.
   * 
   * @param fileName the name of the file to write to
   */
  public ContinuousFileWriter(String fileName) {
    try {
      // Initialize FileWriter in append mode
      fileWriter = new FileWriter(fileName, true);
      sb = new StringBuilder();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method to write to the file
   * 
   * @param text the text to write to the file
   */
  public void writeToFile(String text) {
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
   * Method to close the FileWriter when done
   */
  public void close() {
    try {
      if (fileWriter != null) {
        fileWriter.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  // public static void main(String[] args) {
  // // Create an instance of ContinuousFileWriter
  // fileWriter writer = new fileWriter("output.txt");
  //
  // // Simulate some events that cause writing to the file
  // writer.writeToFile("Event 1 occurred.\n");
  // writer.writeToFile("Event 2 occurred.\n");
  // writer.writeToFile("Event 3 occurred.\n");
  //
  // // Close the writer when done
  // writer.close();
  // }
}
