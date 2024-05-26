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

  public void addEvent(IEvent event) {
    listEvent.add(event);
  }

  public List<IEvent> getEvent() {
    return listEvent;
  }

  @Override
  public double getActionInstant() {
    return this.eventTime;
  }
}
