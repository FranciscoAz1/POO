package ep;

import java.util.ArrayList;
import java.util.List;

import dss.IEvent;

public class Epidemic {

  public static List<IEvent> MayOccur(Population pop, double time) {
    if (pop.getNumIndividuals() >= pop.getMaxPopulationSize()) {
      return doEpidemic(pop, time);
    }
    return new ArrayList<>();
  }

  private static List<IEvent> doEpidemic(Population pop, double time) {
    List<Individual> individuals = pop.getBestIndividual().getSorted(pop.getPopulation());
    List<IEvent> deaths = new ArrayList<>();
    if (individuals.size() < 5) {
      return deaths;
    }
    for (int i = 5; i < individuals.size(); i++) {
      final Individual individual = individuals.get(i);
      // Kill with randomness
      final double randomNumber = Math.random();
      final double individualScore = randomNumber * individual.getConfort();
      if (individualScore < (2.0 / 3.0)) {
        final Death death = new Death(individual, time);
        deaths.add(death);
      }
    }
    pop.IncrementEpidemic();
    return deaths;
  }
}
