package main;

import pa.*;
import ev.Population;

public class Main {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    Args params = new Args(args);
    // Retrieve the values from the arguments object
    int n = params.n;
    int m = params.m;
    double tau = params.tau;
    int nu = params.nu;
    int numax = params.numax;
    double mu = params.mu;
    double rho = params.rho;
    double delta = params.delta;

    Cost costMatrix = params.costMatrix;
    // Use the values as needed
    System.out.printf("n: %d, m: %d, τ: %.2f, ν: %d, νmax: %d, µ: %.2f, ρ: %.2f, δ: %.2f%n",
        n, m, tau, nu, numax, mu, rho, delta);
    costMatrix.printMatrix();

    Empire empire = new Empire(costMatrix.getMatrix());

    empire.printPatrols();
    empire.printSystems();

    Population population = new Population(costMatrix.getMatrix(), numax);
    population.createInitialPopulation(nu);

    population.printPopulation();
    System.out.println("Done!");
  }

}
