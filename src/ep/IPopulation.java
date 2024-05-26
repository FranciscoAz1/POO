package ep;

public interface IPopulation {

  public void createInitialPopulation(int aNumIndividuals);

  public void evaluateFitness();

  public void checkTerminationCondition();

  public void Epidemics();

  public void printPopulation();

}
