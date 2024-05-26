package ep;

import rand.myMath;

public interface IPopulation {

  public void createInitialPopulation(int aNumIndividuals);

  public void performMutation();

  public void performDeath();

  public void evaluateFitness();

  public void checkTerminationCondition();

  public void Epidemics();

  public void printPopulation();

}
