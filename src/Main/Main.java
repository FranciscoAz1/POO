package main;

import java.util.List;

import pa.Cost;

import ep.Population;
import ep.Confort;

import dss.IEvent;
import dss.Simulate;

import rand.myMath;

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
 * @autor Henrique João
 * @autor Tiago Nascimento
 * @autor Ricardo Nobre
 * @autor Francisco Azeredo
 */
public class Main {

  /**
   * The main method that runs the simulation.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    // read arguments
    Args params = new Args(args);

    Cost costMatrix = params.costMatrix;

    int[][] matrix = { { 1, 2, 1, 1, 2, 1 }, { 2, 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3, 3 } };
    costMatrix.setMatrix(matrix);
    // Calculate tmin
    Confort confort = new Confort(costMatrix.getMatrix());

    // Population population = new Population(costMatrix.getMatrix(), numax);
    Population population = new Population(costMatrix.getMatrix(), params.numax);
    // Create initial population
    population.createInitialPopulation(params.nu);

    // initiate parameters to calculate the interval time of events
    myMath mathUtils = new myMath(params.mu, params.rho, params.delta);

    // Setup Simulation
    Simulate simulation = new Simulate(params.tau, population);

    // Initiate pec
    List<IEvent> events = population.getEvents();
    for (IEvent e : events) {
      simulation.AddToPEC(e);
    }
    simulation.run();
  }

}
