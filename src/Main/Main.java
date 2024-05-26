package main;

import pa.Cost;

import ep.Population;

import ep.Confort;

import dss.Simulate;

import rand.myMath;

public class Main {

  /**
   * 
   * @param args
   */

  public static void main(String[] args) {
    Args params = new Args(args);
    // Retriepe the values from the arguments object
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

    // Exemple matrix
    int[][] matrix = {
        { 1, 2, 1, 1, 1, 1 },
        { 2, 1, 2, 2, 2, 2 },
        { 3, 3, 3, 3, 3, 3 },
        { 4, 4, 3, 4, 4, 1 },
    };
    costMatrix.setMatrix(matrix);

    // Calculate tmin
    Confort confort = new Confort(costMatrix.getMatrix());

    // Population population = new Population(costMatrix.getMatrix(), numax);
    Population population = new Population(costMatrix.getMatrix(), numax);
    population.printPatrols();
    population.printSystems();
    // Create initial population
    population.createInitialPopulation(nu);

    // Criação da instância de myMath antes do loop
    myMath mathUtils = new myMath(mu, rho, delta);
    // Imprime a população, incluindo o conforto e os eventos de cada indivíduo
    population.printPopulation();

    Simulate simulation = new Simulate(tau);

    System.out.println("It is Done!");
  }

}
