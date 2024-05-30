package dss;

import java.util.List;

import ep.Population;
import ep.Death;
import ep.Observation;

public class Simulate implements ISimulate {
  private IPEC pec;
  private double simulationTime;
  private IEvent currentEvent;
  private double currentTime;
  public IEvent unnamed_IEvent_;

  public Simulate(double simulationTime, Population population) {
    this.simulationTime = simulationTime;
    this.currentTime = 0;
    this.pec = new PEC();

    // Schedule the 20 initial observation events
    for (int i = 1; i <= 20; i++) {
      double observationTime = i * this.simulationTime / 20;
      AddToPEC(new Observation(observationTime, this.simulationTime, population, i));
    }
    if (checkSimulationStateBegginning(population)) {
      System.out.println("Solution Found");
    }
  }

  @Override
  public void AddToPEC(IEvent aEvent) {
    pec.addEvent(aEvent);
  }

  @Override
  public void run() {
    while (this.currentTime < this.simulationTime && !pec.isEmpty()) {
      this.currentEvent = pec.nextEvent();
      // updates the current time if handling event was successful
      if (currentEvent.HandleEvent()) {
        this.currentTime = this.currentEvent.getEventTime();
      }
      List<IEvent> events = currentEvent.getEvents();
      for (IEvent e : events) {
        pec.addEvent(e);
      }
      currentTime = currentEvent.getEventTime();
      if (currentTime > simulationTime) {
        break;
      }

      // check if solution has been found
      if (currentEvent instanceof Observation) {
        if (!currentEvent.UpdateSimulation()) {
          break;
        }
      }

      // remove dead individuals from pec
      if (currentEvent instanceof Death) {
        Death death = (Death) currentEvent;
        pec.removeIndividual(death.getIndividual());
      }
      // if (isSolutionFound(currentEvent)) {
      // break;
      // }
      // check for event death or event is successful
    }
  }

  private boolean checkSimulationStateBegginning(Population population) { // iterate
    // throuth individuals in population, cheking if any has confort 1
    for (var individual : population.getPopulation()) {
      if (individual.getConfort() >= 1) {
        return true;
      }
    }
    return false;

  }
}
