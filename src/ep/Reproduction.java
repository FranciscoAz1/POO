package ep;

import dss.AEvent;
import rand.myMath;

public class Reproduction extends AEvent implements Ireproduction {
  private Individual individual;
  private Population pop;

  public Individual getIndividual() {
    return individual;
  }

  public Reproduction(Individual individual) {
    super(myMath.reproductionRate(individual.getConfort()));
    this.individual = individual;
  }

  @Override
  public void HandleEvent() {
    pop.createInitialPopulation(1);
  }

  @Override
  public String toString() {
    return "Reproduction Event{time=" + getActionInstant() + "}";
  }
}
