package ev;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import rand.Utils;
import pa.Empire;

public class Population extends Empire {

  private int numIndividuals;
  private int MaxPopulationSize;
  private List<Individual> population = new ArrayList<>();

  public Population(int[][] matrix, int MaxPopulationSize) {
    super(matrix);
    this.MaxPopulationSize = MaxPopulationSize;

  }

  public void createInitialPopulation(int numIndividuals) {
    for (int i = 1; i < numIndividuals; i++) {
      createIndividual(i);
    }
  }

  private void createIndividual(int id) {
    Individual individual = new Individual(id);
    this.numIndividuals = Math.max(id, this.numIndividuals);
    // Randomly distribute planetary systems among patrols
    Collections.shuffle(planetarySystems);
    for (var system : planetarySystems) {
      var patrol = Utils.getRandomElement(patrols);
      individual.assignSystemToPatrol(patrol, system);
    }
    population.add(individual);
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
    for (var individual : population) {
      individual.printTroopDistribution();
    }
  }

}
