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
   * Sorts the population by confort value and returns the sorted list.
   *
   * @param population the population to sort
   * @return the sorted population
   */
  public List<Individual> getSorted(List<Individual> population) {
    List<Individual> sortedPopulation = population.stream()
        .sorted(Comparator.comparingDouble(Individual::getConfort).reversed())
        .collect(Collectors.toList());

    // Find the best individual ever and check if he has changed
    if (!sortedPopulation.isEmpty()
        && (bestIndividual == null || sortedPopulation.get(0).getConfort() > bestIndividual.getConfort())) {
      bestIndividual = sortedPopulation.get(0);
    }

    return sortedPopulation;
  }

  /**
   * Method to find the individual with the best confort value
   * 
   * @return the individual with the best confort value
   */
  public Individual getBestIndividual() {
    return bestIndividual;
  }

  /**
   *  Method to get the 5 best individuals
   *
   * @param population the population to get the best 5 individuals from
   * @return the best 5 individuals
   */
  public List<Individual> getBest5(List<Individual> population) {
    List<Individual> sortedPopulation = getSorted(population);
    return sortedPopulation.stream().limit(5).collect(Collectors.toList());
  }
}
