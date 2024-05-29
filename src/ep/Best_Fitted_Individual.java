package ep;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Best_Fitted_Individual {
  // Método para classificar a população de acordo com o conforto dos indivíduos
  public static void sortPopulation(List<Individual> population) {
    Collections.sort(population, Comparator.comparingDouble(Individual::getConfort).reversed());
  }

  // Método para obter os 5 melhores indivíduos
  public static List<Individual> getBest5(List<Individual> population) {
    return population.stream().limit(5).collect(Collectors.toList());
  }

  public static List<Individual> getOrdered(List<Individual> population) {
    return population.stream().collect(Collectors.toList());
  }
}
