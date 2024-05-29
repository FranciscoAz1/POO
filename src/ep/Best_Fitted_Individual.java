package ep;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Best_Fitted_Individual {
    private static Individual bestIndividual;

    // Method to sort population by confort value 
    public static void sortPopulation(List<Individual> population) {
        Collections.sort(population, Comparator.comparingDouble(Individual::getConfort).reversed());

        // Find the best individual ever and check if he has changed 
        if (!population.isEmpty() && (bestIndividual == null || population.get(0).getConfort() > bestIndividual.getConfort())) {
            bestIndividual = population.get(0);
        }
    }

    // Method to find the individual with the best confort value
    public static Individual getBestIndividual() {
        return bestIndividual;
    }

    // Method to get the 5 best individuals 
    public static List<Individual> getBest5(List<Individual> population) {
        sortPopulation(population);
        return population.stream().limit(5).collect(Collectors.toList());
    }
}
