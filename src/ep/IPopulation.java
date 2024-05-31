package ep;

import java.util.List;

import dss.IEvent;

/**
 * The IPopulation interface provides a contract for a population of individuals
 * in a simulation.
 */
public interface IPopulation {

  public void createInitialPopulation(int numIndividuals);

  public void printPopulation();

  public List<Individual> getPopulation();

  public void addIndividual(Individual individual);

  public void removeIndividual(Individual individual);

  public void forceAdd(Individual individual);

  public void IncrementEpidemic();

  public int getNumIndividuals();

  public int getEpidemicCounter();

  public int getNumEvents();

  public void countEvent();

  public int getMaxPopulationSize();

  public List<IEvent> getEvents();

  public Best_Fitted_Individual getBestIndividual();
}
