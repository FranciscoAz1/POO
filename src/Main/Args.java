package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import pa.Cost;

/**
 * The Args class parses and stores the command line arguments passed to the
 * program.
 */
public class Args {

  public int n, m;
  public double tau, nu, numax, mu, rho, delta;
  public String file;
  public String mode;
  public Cost costMatrix;

  // Default values
  private static final int DEFAULT_N = 3;
  private static final int DEFAULT_M = 6;
  private static final double DEFAULT_TAU = 10.0;
  private static final double DEFAULT_NU = 10.0;
  private static final double DEFAULT_NUMAX = 100.0;
  private static final double DEFAULT_MU = 10.0;
  private static final double DEFAULT_RHO = 1.0;
  private static final double DEFAULT_DELTA = 1.0;

  /**
   * Constructs an Args object and processes the command line arguments.
   *
   * @param args the command line arguments
   */
  public Args(String[] args) {
    if (args.length < 2) {
      // No arguments provided, use default values
      System.out.println("Not enough command line arguments. Using default vaules");
      this.file = "";
      this.mode = "generate";
      this.n = DEFAULT_N;
      this.m = DEFAULT_M;
      this.tau = DEFAULT_TAU;
      this.nu = DEFAULT_NU;
      this.numax = DEFAULT_NUMAX;
      this.mu = DEFAULT_MU;
      this.rho = DEFAULT_RHO;
      this.delta = DEFAULT_DELTA;

      this.costMatrix = new Cost(this.n, this.m);
      return;
    }

    String option = args[0];
    if (option.equals("-r")) {
      if (args.length < 9) {
        System.out.println("Not enough command line arguments.");
        System.exit(0);
      }
      this.readFromArgs(args);
      // Read the matrix values and store in Cost object
    } else if (option.equals("-f")) {
      this.file = args[1];
      this.mode = "read file";
      this.readFromFile(args);
    } else {
      System.out.println("Invalid command line arguments.");
      System.exit(0);
    }
  }

  /**
   * Reads the command line arguments and initializes the values accordingly.
   *
   * @param args the command line arguments
   */
  private void readFromArgs(String[] args) {
    this.file = "";
    this.mode = "generate";
    this.n = Integer.parseInt(args[1]);
    this.m = Integer.parseInt(args[2]);
    this.tau = Double.parseDouble(args[3]);
    this.nu = Double.parseDouble(args[4]);
    this.numax = Double.parseDouble(args[5]);
    this.mu = Double.parseDouble(args[6]);
    this.rho = Double.parseDouble(args[7]);
    this.delta = Double.parseDouble(args[8]);

    this.costMatrix = new Cost(this.n, this.m);
  }

  /**
   * Reads the values from a file and initializes the values accordingly.
   *
   * @param args the command line arguments
   */
  private void readFromFile(String[] args) {
    try {
      String filePath = args[1];

      // Check if the file path is a relative path
      if (filePath.startsWith("./") || filePath.startsWith(".\\")) {
        // Prepend it with the current directory path
        String currentDir = System.getProperty("user.dir");
        filePath = currentDir + File.separator + filePath.substring(2);
      }

      File file = new File(filePath);
      Scanner scanner = new Scanner(file);

      // Read the variables
      this.n = scanner.nextInt();
      this.m = scanner.nextInt();
      this.tau = scanner.nextDouble();
      this.nu = scanner.nextDouble();
      this.numax = scanner.nextDouble();
      this.mu = scanner.nextDouble();
      this.rho = scanner.nextDouble();
      this.delta = scanner.nextDouble();

      this.costMatrix = new Cost(scanner, n, m);
      // Close the scanner
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.exit(0);
    }
  }

  public boolean fileMode() {
    return this.mode.equals("file");
  }

  public boolean readMode() {
    return this.mode.equals("read");
  }
}
