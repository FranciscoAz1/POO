package ep;

import dss.AEvent;
import rand.myMath;

/**
 * The Death class represents an event in the simulation where an individual
 * dies.
 * It extends the AEvent class and overrides the HandleEvent method.
 */
public class Death extends AEvent {
  private Individual individual;

  public Individual getIndividual() {
    return individual;
  }

  /**
   * Constructs a Death object with a specified individual.
   *
   * @param individual the individual that dies
   */
  public Death(Individual individual) {
    super(myMath.deathRate(individual.getConfort()));
    this.individual = individual;
  }

  /**
   * Constructs a Death object with a specified individual and time.
   *
   * @param individual the individual that dies
   * @param time       the time of the event
   */
  public Death(Individual individual, double time) {
    super(time);
    this.individual = individual;
  }

  /**
   * Handles the event by removing the individual from the population.
   *
   * @return true if the event was successfully handled
   */
  @Override
  public void HandleEvent() {
    // check death of individual
    // if (individual == null) {
    // return false;
    // }
    // if (individual.getPopulation().getPopulation().contains(individual)) {
    // return false;
    // }
    Population pop = individual.getPopulation();
    pop.removeIndividual(individual);
    pop.countEvent();
  }

  /**
   * Returns a string representation of the Death event.
   *
   * @return a string representation of the Death event
   */
  @Override
  public String toString() {
    return "Death Event{time=" + getEventTime() + "}";
  }
}
