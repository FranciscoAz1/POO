package ep;

/**
 * The IPopulation interface provides a contract for a population of individuals in a simulation.
 */
public interface IPopulation {

  public void createInitialPopulation(int aNumIndividuals);

  public void printPopulation();

}
