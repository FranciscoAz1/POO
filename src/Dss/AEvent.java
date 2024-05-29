package dss;

import java.util.ArrayList;
import java.util.List;

public abstract class AEvent implements IEvent {
  private double eventTime;
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
  public void UpdateSimulation() {
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
