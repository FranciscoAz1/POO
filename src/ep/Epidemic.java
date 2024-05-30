package ep;

import java.util.ArrayList;
import java.util.List;

import dss.IEvent;

public class Epidemic {

  public static List<IEvent> MayOccur(final Population pop) {
    if (pop.getNumIndividuals() >= pop.getMaxPopulationSize()) {
      return doEpidemic(pop);
    }
    return new ArrayList<>();
  }

  private static List<IEvent> doEpidemic(final Population pop) {
    final List<Individual> individuals = pop.getBestIndividual().getSorted(pop.getPopulation());
    final List<IEvent> deaths = new ArrayList<>();
    if (individuals.size() < 5) {
      return deaths;
    }
    for (int i = 5; i < individuals.size(); i++) {
      final Individual individual = individuals.get(i);
      // Kill with randomness
      final double randomNumber = Math.random();
      final double individualScore = randomNumber * individual.getConfort();
      if (individualScore < (2.0 / 3.0)) {
        final Death death = new Death(individual);
        deaths.add(death);
      }
    }
    pop.IncrementEpidemic();
    return deaths;
  }
}
