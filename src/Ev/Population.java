package ev;

import java.util.List;

public class Population {

  private int populationSize;
  private int MaxPopulationSize;
  private List<Individual> population;

  public Population(int populationSize, int MaxPopulationSize) {
    this.populationSize = populationSize;
    this.MaxPopulationSize = MaxPopulationSize;
  }

  public void selectIndividuals() {
    // TODO - implement Population.selectIndividuals
    throw new UnsupportedOperationException();
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

}
