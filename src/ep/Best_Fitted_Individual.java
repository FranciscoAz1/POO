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

    return sortedPopulation;
  }

  /**
   * Method to find the individual with the best confort value
   * 
   * @return the individual with the best confort value
   */
  public Individual getBestIndividual(List<Individual> population) {
    List<Individual> sortedPopulation = getSorted(population);

    // Find the best individual ever and update it if it's better than the current
    // best
    if (!sortedPopulation.isEmpty()) {
      Individual currentBest = sortedPopulation.get(0);
      // System.out.printf("O atual melhor é: %s (conforto: %.2f) e o melhor até agora
      // é: %s (conforto: %.2f)%n",

      if (bestIndividual == null || currentBest.getConfort() > bestIndividual.getConfort()) {
        // System.out.printf("O atual melhor é: %s (conforto: %.2f) e o melhor até agora
        // é: %s (conforto: %.2f)%n",
        // currentBest,
        // currentBest.getConfort(),
        // bestIndividual,
        // bestIndividual != null ? bestIndividual.getConfort() : 0);
        // bestIndividual = new Individual(currentBest); // Use copy constructor
        if (bestIndividual == null) {
          bestIndividual = new Individual(currentBest);
        }
        bestIndividual.updateFrom(currentBest);

        // System.out.printf("\n Está na hora de trocar %s (%.2f)
        // \n",bestIndividual,bestIndividual.getConfort());
      }
    }

    return bestIndividual;
  }

  public double getBestConfort() {
    return bestIndividual != null ? bestIndividual.getConfort() : 0;
  }

  /**
   * Method to get the 5 best individuals
   *
   * @param population the population to get the best 5 individuals from
   * @return the best 5 individuals
   */
  public List<Individual> getBest5(List<Individual> population) {
    List<Individual> sortedPopulation = getSorted(population);
    return sortedPopulation.stream().limit(5).collect(Collectors.toList());
  }
}
