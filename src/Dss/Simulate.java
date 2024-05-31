package dss;

import java.util.List;

import ep.Population;
import ep.Death;
import ep.Observation;

/**
 * The Simulate class implements the ISimulate interface. It provides
 * functionality for
 * running a simulation using a priority event container.
 */
public class Simulate implements ISimulate {
  private IPEC pec;
  private double simulationTime;
  private IEvent currentEvent;
  private double currentTime;
  public IEvent unnamed_IEvent_;

  /**
   * Constructs a Simulate object with the specified simulation time and
   * population.
   *
   * @param simulationTime the time to run the simulation
   * @param population     the population to simulate
   */
  public Simulate(double simulationTime, Population population) {
    this.simulationTime = simulationTime;
    this.currentTime = 0;
    this.pec = new PEC();

    // Schedule the 20 initial observation events
    for (int i = 0; i <= 20; i++) {
      double observationTime = i * this.simulationTime / 20;
      AddToPEC(new Observation(observationTime, this.simulationTime, population, i));
    }/* 
    if (checkSimulationStateBegginning(population)) {
      System.out.println("Solution Found");
    }*/
  }

  /**
   * Adds an event to the priority event container.
   *
   * @param aEvent the event to add
   */
  @Override
  public void AddToPEC(IEvent aEvent) {
    pec.addEvent(aEvent);
  }

  /**
   * Runs the simulation until the simulation time is reached or the priority
   * event container is
   * empty.
   */
  @Override
  public void run() {
    System.out.println("start run");
    while (this.currentTime < this.simulationTime && !pec.isEmpty()) {
      this.currentEvent = pec.nextEvent();
      // updates the current time if handling event was successful
      currentEvent.HandleEvent();
      this.currentTime = this.currentEvent.getEventTime();
      // Add new events to pec
      pec.addEvents(currentEvent.getEvents());

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

  /**
   * Checks if the simulation has reached a solution.
   *
   * @param event the event to check
   * @return true if the simulation has reached a solution, false otherwise
   */
  /* 
  @Override
  private boolean checkSimulationStateBegginning(Population population) { // iterate
    // throuth individuals in population, cheking if any has confort 1
    for (var individual : population.getPopulation()) {
      if (individual.getConfort() >= 1) {
        return true;
      }
    }
    return false;

  }*/
}
