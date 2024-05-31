package ep;

import java.util.List;

/**
 * The IPopulation interface provides a contract for a population of individuals in a simulation.
 */
public interface IPopulation {

  public void createInitialPopulation(int numIndividuals);

  public void printPopulation();

  public List<Individual> getPopulation();

  public void addIndividual(Individual individual);

  public void removeIndividual(Individual individual);

  public int getNumIndividuals();

  public int getMaxPopulationSize();

  public Best_Fitted_Individual getBestIndividual();
}
