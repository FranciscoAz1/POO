package ep;

import ep.Death;

import java.util.List;

import dss.AEvent;

public class Epidemic {
  private int counter;

  public Epidemic() {
    this.counter = 0;
  }

  public void MayOccur(Population pop) {
    if (pop.getNumIndividuals() >= pop.getMaxPopulationSize()) {
      doEpidemic(pop);
      counter++;
    }
  }

  private void doEpidemic(Population pop) {
    List<Individual> individuals = Best_Fitted_Individual.getOrdered(pop.getPopulation());
    if (individuals.size() < 5) {
      return;
    }
    for (int i = 5; i < individuals.size(); i++) {
      Individual individual = individuals.get(i);
      // Kill with randomness
      double randomNumber = Math.random();
      double individualScore = randomNumber * individual.getConfort();
      if (individualScore > 2 / 3) {
        Death death = new Death(individual);
        death.HandleEvent();
      }
    }

  }
}
