package main;

import java.util.List;

import dss.IEvent;
import dss.Simulate;
import ep.Confort;
import ep.Population;
import pa.Cost;
import rand.myMath;
import utils.ContinuousFileWriter;

/* 
 * Entrar na pasta certa:
 * cd src 
 * 
 * Compilar tudo e Criar o executável:
 *  javac $(find . -name "*.java") && jar cmf manif.txt project.jar $(find . -name "*.java") $(find . -name "*.class")
 * 
 * Correr o executável:
 * java -jar project.jar
 * 
 * Remover todos .class files:
 * find . -name "*.class" -type f -exec rm -f {} +
 * (linux)
 * 
 * */

/**
 * The Main class provides a main method that runs the simulation.
 * 
 * @author Henrique João
 * @author Tiago Nascimento
 * @author Ricardo Nobre
 * @author Francisco Azeredo
 */
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
        { 1, 2, 1, 1, 1, 2, 2, 1, 2, 1, 1, 1, 2, 2 },
        { 2, 1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 1, 2, 2 },
        { 1, 2, 1, 1, 1, 2, 2, 2, 1, 2, 2, 2, 1, 1 },
        { 2, 1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 1, 2, 2 },
        { 1, 2, 1, 1, 1, 2, 2, 1, 2, 1, 1, 1, 2, 2 },
        { 2, 1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 1, 2, 2 },
        { 5, 5, 5, 1, 1, 2, 2, 2, 1, 2, 2, 2, 1, 1 },
        { 2, 1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 1, 2, 2 },
    };

    // Calculate tmin
    Confort confort = new Confort(costMatrix.getMatrix());

    // Population population = new Population(costMatrix.getMatrix(), numax);
    Population population = new Population(costMatrix.getMatrix(), numax);

    // population.printPatrols();
    // population.printSystems();

    // Create initial population
    population.createInitialPopulation(nu);

    // Criação da instância de myMath antes do loop
    myMath mathUtils = new myMath(mu, rho, delta);

    Simulate simulation = new Simulate(tau, population);

    // Initiate pec
    List<IEvent> events = population.getEvents();
    for (IEvent e : events) {
      simulation.AddToPEC(e);
    }
    // simulation.getPec().printPEC();
    simulation.run();
    // ContinuousFileWriter.close();
    System.out.println("It is Done!");
  }

}
