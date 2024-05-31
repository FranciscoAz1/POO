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
  private FileWriter fileWriter;
  private StringBuilder sb;

  /**
   * Constructs a ContinuousFileWriter object with the specified base file name.
   * 
   * @param baseFileName the base name of the file to write to
   */
  public ContinuousFileWriter(String baseFileName) {
    try {
      // Generate a unique file name by appending the current timestamp
      String uniqueFileName = generateUniqueFileName(baseFileName);
      // Initialize FileWriter in write mode (new file)
      fileWriter = new FileWriter(uniqueFileName, false);
      sb = new StringBuilder();
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
  private String generateUniqueFileName(String baseFileName) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    String timestamp = sdf.format(new Date());
    return baseFileName + "_" + timestamp + ".txt";
  }

  /**
   * Method to write to the file.
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
   * Method to close the FileWriter when done.
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
  // ContinuousFileWriter writer = new ContinuousFileWriter("output");
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
