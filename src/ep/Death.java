package ep;

import java.util.List;

import dss.AEvent;
import rand.myMath;

public class Death extends AEvent {
  private Individual individual;

  public Individual getIndividual() {
    return individual;
  }

  public Death(Individual individual) {
    super(myMath.deathRate(individual.getConfort()));
    this.individual = individual;
  }

  @Override
  public boolean HandleEvent() {
    // check death of individual
    if (individual == null) {
      return false;
    }
    if (individual.getPopulation().getPopulation().contains(individual)) {
      return false;
    }
    Population pop = individual.getPopulation();
    List<Individual> individuals = pop.getPopulation();
    individuals.remove(individual);
    pop.setPopulation(individuals);

    return true;
    // Implementar a lógica de morte
  }

  @Override
  public String toString() {
    return "Death Event{time=" + getEventTime() + "}";
  }
}
