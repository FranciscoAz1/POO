package ep;

import dss.pec.AEvent;
import rand.myMath;

public class Reproduction extends AEvent {
  private Individual individual;

  public Individual getIndividual() {
    return individual;
  }

  public Reproduction(Individual individual) {
    super(myMath.reproductionRate(individual.getConfort()));
    this.individual = individual;
  }

  @Override
  public void HandleEvent() {
    // Implementar a lógica de reprodução
  }

  @Override
  public String toString() {
    return "Reproduction Event{time=" + getActionInstant() + "}";
  }
}
