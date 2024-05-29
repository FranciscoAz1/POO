package ep;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Best_Fitted_Individual {
  private Individual bestIndividual;

  public Best_Fitted_Individual() {
  }

  // Method to sort population by confort value and return the sorted list
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

  // Method to find the individual with the best confort value
  public Individual getBestIndividual() {
    return bestIndividual;
  }

  // Method to get the 5 best individuals
  public List<Individual> getBest5(List<Individual> population) {
    List<Individual> sortedPopulation = getSorted(population);
    return sortedPopulation.stream().limit(5).collect(Collectors.toList());
  }
}
