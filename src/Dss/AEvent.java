package dss;

import java.util.ArrayList;
import java.util.List;

/**
 * The AEvent class is an abstract class that implements the IEvent interface.
 * It provides common functionality for event objects in a simulation.
 * 
 * 
 * Note: This class assumes the existence of the IEvent interface
 * Implementations of the IEvent interface are not provided here
 * 
 */

public abstract class AEvent implements IEvent {
  protected double eventTime;
  private List<IEvent> listEvent;
  protected List<IEvent> newEvent = new ArrayList<>();

  public AEvent(double eventTime) {
    this.eventTime = eventTime;
    this.listEvent = new ArrayList<>();
  }

  @Override
  public void NewEvent() {
    // Implement logic for creating new Event
  }

  @Override
  public boolean UpdateSimulation() {
    return true;
    // Implement logic for updating the simulation
  }

  @Override
  public boolean HandleEvent() {
    throw new IllegalStateException("This is an abstract method.");
  }

  @Override
  public void addEvent(IEvent event) {
    listEvent.add(event);
  }

  @Override
  public List<IEvent> getEvents() {
    return listEvent;
  }

  @Override
  public void addEvents(List<IEvent> events) {
    listEvent.addAll(events);
  }

  @Override
  public double getEventTime() {
    return this.eventTime;
  }
}
