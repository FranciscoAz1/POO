package ep;

import java.util.ArrayList;
import java.util.List;

import dss.IEvent;

/**
 * The Epidemic class provides functionality for simulating an epidemic in a
 * population.
 */
public class Epidemic {

  /**
   * Determines if an epidemic may occur in the population.
   *
   * @param pop  The population to check.
   * @param time The current time.
   * @return A list of events that may occur.
   */
  public static List<IEvent> MayOccur(Population pop, double time) {
    if (pop.getNumIndividuals() > pop.getMaxPopulationSize()) {
      return doEpidemic(pop, time);
    }
    return new ArrayList<>();
  }

  /**
   * Simulates an epidemic in the population.
   *
   * @param pop  The population to simulate.
   * @param time The current time, used to generate deaths at this time.
   * @return A list of events that occurred.
   */
  public static List<IEvent> doEpidemic(Population pop, double time) {

    List<Individual> individuals = pop.getBestIndividual().getSorted(pop.getPopulation());
    List<IEvent> deaths = new ArrayList<>();
    if (individuals.size() < 6) {
      return deaths;
    }
    for (int i = 0; i < individuals.size() - 6; i++) {
      Individual individual = individuals.get(i);
      // Kill with randomness
      double randomNumber = Math.random();
      double individualScore = randomNumber * individual.getConfort();
      if (individualScore < (2.0 / 3.0)) {
        Death death = new Death(individual, time);
        deaths.add(death);
      }
    }
    pop.IncrementEpidemic();
    return deaths;
  }
}