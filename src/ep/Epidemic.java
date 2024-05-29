package ep;

import java.util.List;

public class Epidemic {
  private int counter;

  public Epidemic() {
    this.counter = 0;
  }

  public int getCounter() {

    return counter;
  }

  public void MayOccur(Population pop) {
    if (pop.getNumIndividuals() >= pop.getMaxPopulationSize()) {
      doEpidemic(pop);
      counter++;
    }
  }

  private void doEpidemic(Population pop) {
    List<Individual> individuals = pop.getBestIndividual().getSorted(pop.getPopulation());
    if (individuals.size() < 5) {
      return;
    }
    for (int i = 5; i < individuals.size(); i++) {
      Individual individual = individuals.get(i);
      // Kill with randomness
      double randomNumber = Math.random();
      double individualScore = randomNumber * individual.getConfort();
      if (individualScore < (2.0 / 3.0)) {
        Death death = new Death(individual);
        death.HandleEvent();
      }
    }

  }
}
