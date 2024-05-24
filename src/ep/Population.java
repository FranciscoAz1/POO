package ep;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import rand.Utils;
import pa.AEmpire;
import pa.Patrol;
import pa.PlanetarySystem;

public class Population extends AEmpire implements IPopulation {

  private int numIndividuals = 0;
  private int MaxPopulationSize;
  private List<Individual> population = new ArrayList<>();

  public Population(int[][] matrix, int MaxPopulationSize) {
    super(matrix);
    this.MaxPopulationSize = MaxPopulationSize;
  }

  public Population(int[][] matrix, int MaxPopulationSize, int numIndividuals) {
    super(matrix);
    this.MaxPopulationSize = MaxPopulationSize;
    this.numIndividuals = numIndividuals;
    createInitialPopulation(numIndividuals);
  }

  public void createInitialPopulation(int numIndividuals) {
    this.numIndividuals += numIndividuals;
    for (int i = 1; i < numIndividuals; i++) {

      population.add(new Individual(i, patrols, planetarySystems));
    }
  }

  @Override
  public void performReproduction() {
    // TODO - implement Population.performCrossover
    throw new UnsupportedOperationException();
  }

  @Override
  public void performMutation() {
    // TODO - implement Population.performMutation
    throw new UnsupportedOperationException();
  }

  @Override
  public void performDeath() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void evaluateFitness() {
    // TODO - implement Population.evaluateFitness
    throw new UnsupportedOperationException();
  }

  @Override
  public void checkTerminationCondition() {
    // TODO - implement Population.checkTerminationCondition
    throw new UnsupportedOperationException();
  }

  @Override
  public void Epidemics() {
    // TODO - implement Population.Epidemics
    throw new UnsupportedOperationException();
  }

  @Override
  public void printPopulation() {
    for (int i = 0; i < population.size(); i++) {
      System.out.println("Troop Distribution for Individual " + i + ":");
      System.out.printf("Confort: %.2f\n", population.get(i).getConfort());

      population.get(i).printTroopDistribution();
    }
  }
}
