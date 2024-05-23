package main;

import pa.*;
import ev.Individual;
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
    int[][] matrix = {
        { 1, 2, 1, 1, 1, 1 },
        { 2, 1, 2, 2, 2, 2 },
        { 3, 3, 3, 3, 3, 3 }
    };

    // Calculate tmin
    Confort confort = new Confort(costMatrix.getMatrix());
    // Population population = new Population(costMatrix.getMatrix(), numax);
    Population population = new Population(costMatrix.getMatrix(), numax);
    population.printPatrols();
    population.printSystems();
    // Create an individual and print its troop distribution
    population.createInitialPopulation(nu);

    population.printPopulation();
    System.out.println("Done!");
  }

}
