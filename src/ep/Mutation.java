package ep;

import dss.pec.AEvent;
import rand.myMath;

public class Mutation extends AEvent {
  private Individual individual;

  public Individual getIndividual() {
    return individual;
  }

  public Mutation(Individual individual) {
    super(myMath.mutationRate(individual.getConfort()));
    this.individual = individual;
  }

  @Override
  public void HandleEvent() {
    // Implementar a lógica de mutação
  }

  @Override
  public String toString() {
    return "Mutation Event{time=" + getActionInstant() + "}";
  }
}
