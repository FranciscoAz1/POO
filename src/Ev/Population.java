package ev;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import rand.Utils;
import pa.Empire;

public class Population extends Empire {

  private int numIndividuals = 0;
  private int MaxPopulationSize;
  private List<Individual> population = new ArrayList<>();

  public Population(int[][] matrix, int MaxPopulationSize) {
    super(matrix);
    this.MaxPopulationSize = MaxPopulationSize;

  }

  public void createInitialPopulation(int numIndividuals) {
    this.numIndividuals += numIndividuals;
    for (int i = 1; i < numIndividuals; i++) {

      population.add(new Individual(i, patrols, planetarySystems));
    }
  }

  public void performReproduction() {
    // TODO - implement Population.performCrossover
    throw new UnsupportedOperationException();
  }

  public void performMutation() {
    // TODO - implement Population.performMutation
    throw new UnsupportedOperationException();
  }

  public void performDeath() {
    throw new UnsupportedOperationException();
  }

  public void evaluateFitness() {
    // TODO - implement Population.evaluateFitness
    throw new UnsupportedOperationException();
  }

  public void checkTerminationCondition() {
    // TODO - implement Population.checkTerminationCondition
    throw new UnsupportedOperationException();
  }

  public void Epidemics() {
    // TODO - implement Population.Epidemics
    throw new UnsupportedOperationException();
  }

  public void printPopulation() {
    for (int i = 0; i < population.size(); i++) {
      System.out.println("Troop Distribution for Individual " + i + ":");
      System.out.printf("Confort: %.2f\n", population.get(i).getConfort());

      population.get(i).printTroopDistribution();
    }
  }

}
