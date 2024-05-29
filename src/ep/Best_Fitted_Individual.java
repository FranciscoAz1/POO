package ep;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Best_Fitted_Individual {
  private static Individual bestIndividual;

  // Método para classificar a população de acordo com o conforto dos indivíduos
  public static void sortPopulation(List<Individual> population) {
    Collections.sort(population, Comparator.comparingDouble(Individual::getConfort).reversed());

    // Verificar se o melhor indivíduo mudou e atualizar, se necessário
    if (!population.isEmpty()
        && (bestIndividual == null || population.get(0).getConfort() > bestIndividual.getConfort())) {
      bestIndividual = population.get(0);
    }
  }

  // Método para obter o melhor indivíduo
  public static Individual getBestIndividual() {
    return bestIndividual;
  }

  // Método para obter os 5 melhores indivíduos
  public static List<Individual> getBest5(List<Individual> population) {
    sortPopulation(population);
    return population.stream().limit(5).collect(Collectors.toList());
  }

  public static List<Individual> getSorted(List<Individual> population) {
    sortPopulation(population);
    return population.stream().collect(Collectors.toList());
  }
}
