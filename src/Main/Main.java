package main;

import pa.Patrol;

public class Main {

  /**
   * 
   * @param args
   */
  public void main(String[] args) {
    Args params = new Args(args);
    // Retrieve the values from the arguments object
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
  }

}
