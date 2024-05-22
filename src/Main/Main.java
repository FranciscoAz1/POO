package main;

import pa.*;

// build program
// javac -d bin src/main/Args.java src/main/Main.java
// run program
// java -cp bin main.Main -r 3 6 10 10 100 10 1 1

public class Main {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    // get parameters from file or text
    Args params = new Args(args);
    // Retrieve the values from the params object
    int n = params.n;
    int m = params.m;
    double tau = params.tau;
    double nu = params.nu;
    double numax = params.numax;
    double mu = params.mu;
    double rho = params.rho;
    double delta = params.delta;

    // Use the values as needed
    System.out.printf("n: %d, m: %d, τ: %.2f, ν: %.2f, νmax: %.2f, µ: %.2f, ρ: %.2f, δ: %.2f%n",
        n, m, tau, nu, numax, mu, rho, delta);
    System.out.println("end Program");
  }

}
