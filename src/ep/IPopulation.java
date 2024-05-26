package ep;

import rand.myMath;

public interface IPopulation {

  public void createInitialPopulation(int aNumIndividuals);

  public void performReproduction();

  public void performMutation();

  public void performDeath();

  public void evaluateFitness();

  public void checkTerminationCondition();

  public void Epidemics();

  public void printPopulation(myMath mathUtils, double rho, double delta, double mu);
}
