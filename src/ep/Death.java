package ep;

import dss.AEvent;
import rand.myMath;

/**
 * The Death class represents an event in the simulation where an individual
 * dies. It extends the AEvent class and overrides the HandleEvent method.
 * It does not remove events from PEC; that must be done in PEC.
 */
public class Death extends AEvent implements Ideath {
  private Individual individual;

  /**
   * Gets the individual that dies in this event.
   *
   * @return The individual that dies.
   */
  public Individual getIndividual() {
    return individual;
  }

  /**
   * Constructs a Death object with a specified individual.
   *
   * @param individual The individual that dies.
   */
  public Death(Individual individual) {
    super(myMath.deathRate(individual.getConfort()));
    this.individual = individual;
  }

  /**
   * Constructs a Death object with a specified individual and time.
   *
   * @param individual The individual that dies.
   * @param time       The time of the event.
   */
  public Death(Individual individual, double time) {
    super(time);
    this.individual = individual;
  }

  /**
   * Handles the event by removing the individual from the population.
   */
  @Override
  public void HandleEvent() {
    Population pop = individual.getPopulation();
    pop.removeIndividual(individual);
    pop.countEvent();
  }

  /**
   * Returns a string representation of the Death event.
   *
   * @return A string representation of the Death event.
   */
  @Override
  public String toString() {
    return "Death Event{time=" + getEventTime() + "Individual" + getIndividual() + "}";
  }
}
