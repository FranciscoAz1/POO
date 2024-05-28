package dss;

import java.util.List;

import ep.Death;
import ep.Mutation;
import ep.Reproduction;

public class Simulate implements ISimulate {
  private IPEC pec;
  private double simulationTime;
  private IEvent currentEvent;
  private double currentTime;
  public IEvent unnamed_IEvent_;

  public Simulate(double simulationTime) {
    this.simulationTime = simulationTime;
    this.currentTime = 0;
    this.pec = new PEC();
  }

  @Override
  public void AddToPEC(IEvent aEvent) {
    pec.addEvent(aEvent);
  }

  @Override
  public void setup( List<T> individuals ) {
    // Add initial events for each individual
    for (T individual : individuals) {
      IEvent reproductionEvent = new Reproduction(individual);
      AddToPEC(reproductionEvent);

      IEvent mutationEvent = new Mutation(individual);
      AddToPEC(mutationEvent);

      IEvent deathEvent = new Death(individual);
      AddToPEC(deathEvent);
    }

  @Override
  public void run() {
    while (this.currentTime < this.simulationTime && !pec.isEmpty()) {
      this.currentEvent = pec.nextEvent();
      // updates the current time if handling event was successful
      if (currentEvent.HandleEvent()) {
        this.currentTime = this.currentEvent.getEventTime();
      }
      List<IEvent> events = currentEvent.getNewEvents();
      for (IEvent e : event) {
        pec.addEvent(e);
      }

      currentTime = currentEvent.getEventTime();
      if (currentTime > simulationTime) {
        break;
      }
      // check for event death or event is successful
    }
  }
}
}