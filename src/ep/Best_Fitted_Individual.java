package ep;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The Best_Fitted_Individual class provides functionality for
 * finding the best fitted individual in a population.
 */
public class Best_Fitted_Individual {
  private Individual bestIndividual;

  /**
   * Constructs a Best_Fitted_Individual object with a null best individual.
   */
  public Best_Fitted_Individual() {
  }

  /**
   * Sorts the population by comfort value and returns the sorted list.
   *
   * @param population The population to sort.
   * @return The sorted population.
   */
  public List<Individual> getSorted(List<Individual> population) {
    List<Individual> sortedPopulation = population.stream()
        .sorted(Comparator.comparingDouble(Individual::getConfort).reversed())
        .collect(Collectors.toList());

    // Find the best individual ever and update it if it's better than the current
    // best
    if (!sortedPopulation.isEmpty()) {
      Individual currentBest = sortedPopulation.get(0);
      if (bestIndividual == null || currentBest.getConfort() > bestIndividual.getConfort()) {
        bestIndividual = new Individual(currentBest); // Use copy constructor
      }
    }

    return sortedPopulation;
  }

  /**
   * Finds the individual with the best comfort value.
   * 
   * @return The individual with the best comfort value.
   */
  public Individual getBestIndividual() {
    return bestIndividual;
  }

  /**
   * Gets the best comfort value.
   * 
   * @return The best comfort value.
   */
  public double getBestConfort() {
    return bestIndividual != null ? bestIndividual.getConfort() : 0;
  }


  /**
   * Gets the top 5 best individuals from the population.
   *
   * @param population The population to get the top 5 individuals from.
   * @return The top 5 individuals.
   */
  public List<Individual> getBest5(List<Individual> population) {
    List<Individual> sortedPopulation = getSorted(population);
    return sortedPopulation.stream().limit(5).collect(Collectors.toList());
  }
}
