package ep;

import java.util.List;

import dss.IEvent;

import java.util.ArrayList;

import pa.AEmpire;

/**
 * The Population class extends the AEmpire class and implements the IPopulation
 * interface. It manages a population of individuals in the simulation.
 */
public class Population extends AEmpire implements IPopulation {

  private int numIndividuals = 0;
  private int eventsPerformed = 0;
  private int epidemicCounter = 0;
  private int MaxPopulationSize;
  private List<Individual> population = new ArrayList<>();
  private Best_Fitted_Individual bestIndividual = new Best_Fitted_Individual();

  /**
   * Constructs a Population object with the given matrix and maximum population
   * size.
   * 
   * @param matrix            The matrix of planetary systems.
   * @param MaxPopulationSize The maximum population size.
   */
  public Population(int[][] matrix, int MaxPopulationSize) {
    super(matrix);
    this.MaxPopulationSize = MaxPopulationSize;
  }

  /**
   * Constructs a Population object with the given matrix, maximum population
   * size, and number of individuals.
   * 
   * @param matrix            The matrix of planetary systems.
   * @param MaxPopulationSize The maximum population size.
   * @param numIndividuals    The number of individuals.
   */
  public Population(int[][] matrix, int MaxPopulationSize, int numIndividuals) {
    super(matrix);
    this.MaxPopulationSize = MaxPopulationSize;
    this.numIndividuals = numIndividuals;
    createInitialPopulation(numIndividuals);
  }

  /**
   * Creates the initial population of individuals.
   * 
   * @param numIndividuals The number of individuals.
   */
  public void createInitialPopulation(int numIndividuals) {
    this.numIndividuals += numIndividuals;
    for (int i = 0; i < numIndividuals; i++) {
      addIndividual(new Individual(this, patrols, planetarySystems));
    }
    population = bestIndividual.getSorted(population);
  }

  /**
   * Returns the list of individuals in the population.
   * 
   * @return The list of individuals in the population.
   */
  @Override
  public List<Individual> getPopulation() {
    return population;
  }

  /**
   * Increments the count of events performed.
   */
  public void countEvent() {
    this.eventsPerformed++;
  }

  /**
   * Returns the number of events performed.
   * 
   * @return The number of events performed.
   */
  public int getNumEvents() {
    return eventsPerformed;
  }

  /**
   * Returns the epidemic counter.
   * 
   * @return The number of epidemics.
   */
  public int getEpidemicCounter() {
    return epidemicCounter;
  }

  /**
   * Increments the count of epidemics.
   */
  public void IncrementEpidemic() {
    this.epidemicCounter++;
  }

  /**
   * Adds an individual to the population.
   * 
   * @param individual The individual to add.
   */
  public void addIndividual(Individual individual) {
    int attempts = 0;
    int maxAttempts = 100; // number of times we try to avoid duplicates
    while (attempts < maxAttempts) {
      boolean isDuplicate = false;
      for (Individual existingIndividual : population) {
        if (Individual.equalsByDistribution(individual, existingIndividual)) {
          isDuplicate = true;
          break;
        }
      }
      if (!isDuplicate) {
        if (population.add(individual)) {
          this.numIndividuals += 1;
        }
        return;
      } else {
        individual = new Individual(this, patrols, planetarySystems);
        attempts++;
      }
    }
    population.add(individual);
    System.out.println("Unique Individual could not be found");
  }

  /**
   * Forces the addition of an individual to the population.
   * 
   * @param individual The individual to add.
   */
  public void forceAdd(Individual individual) {
    population.add(individual);
  }

  /**
   * Removes an individual from the population.
   * 
   * @param individual The individual to remove.
   */
  public void removeIndividual(Individual individual) {
    if (this.population.remove(individual)) {
      this.numIndividuals -= 1;
    }
  }

  /**
   * Prints the details of the population, including each individual and their
   * events.
   */
  @Override
  public void printPopulation() {
    for (int i = 0; i < population.size(); i++) {

      // Linha que indica o indivíduo com uma linha em branco antes
      System.out.println();
      System.out.println("Individual " + i + ":");

      Individual individual = population.get(i);
      System.out.println("Troop Distribution for Individual " + i + ":");
      System.out.printf("Confort: %.2f\n", individual.getConfort());
      individual.printTroopDistribution();

      // Imprimir os eventos do indivíduo
      List<IEvent> events = individual.getEvents();
      for (IEvent event : events) {
        System.out.println(event);
      }
    }

    /*
     * System.out.println("\nLista ordenada de todos os indivíduos:");
     * Best_Fitted_Individual.sortPopulation(population);
     * for (Individual individual : population) {
     * System.out.printf("Conforto: %.2f - %s\n", individual.getConfort(),
     * individual);
     * }
     * 
     * System.out.println("\nOs 5 melhores indivíduos:");
     * List<Individual> best5 = Best_Fitted_Individual.getBest5(population);
     * for (Individual individual : best5) {
     * System.out.printf("Conforto: %.2f - %s\n", individual.getConfort(),
     * individual);
     * }
     * // Imprimir o melhor indivíduo rastreado
     * Individual bestIndividual = Best_Fitted_Individual.getBestIndividual();
     * if (bestIndividual != null) {
     * System.out.println("\nMelhor indivíduo rastreado:");
     * System.out.printf("Conforto: %.2f - %s\n", bestIndividual.getConfort(),
     * bestIndividual);
     * } else {
     * System.out.println("\nNenhum indivíduo rastreado como o melhor.");
     * }
     */
  }

  /**
   * Returns a list of all events in the population.
   *
   * @return A list of all events.
   */
  public List<IEvent> getEvents() {
    List<IEvent> AllEvents = new ArrayList<>();
    for (Individual individual : population) {
      AllEvents.addAll(individual.getEvents());
    }
    return AllEvents;
  }

  /**
   * Returns the number of individuals in the population.
   * 
   * @return The number of individuals.
   */
  public int getNumIndividuals() {
    return numIndividuals;
  }

  /**
   * Returns the maximum population size.
   * 
   * @return The maximum population size.
   */
  public int getMaxPopulationSize() {
    return MaxPopulationSize;
  }

  /**
   * Returns the best-fitted individual in the population.
   * 
   * @return The best-fitted individual.
   */
  public Best_Fitted_Individual getBestIndividual() {
    return bestIndividual;
  }
}
