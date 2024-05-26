package ep;

import dss.pec.AEvent;
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
  public void HandleEvent() {
    // Implementar a lógica de morte
  }

  @Override
  public String toString() {
    return "Death Event{time=" + getActionInstant() + "}";
  }
}
