package ep;

import java.util.ArrayList;
import java.util.List;
import dss.IEvent;

/**
 * The AEvent class is an abstract class that implements the IEvent interface.
 * It provides common functionality for event objects in a simulation.
 * 
 * Note: This class assumes the existence of the IEvent interface.
 * Implementations of the IEvent interface are not provided here.
 */
public abstract class AEvent implements IEvent {
  protected double eventTime;
  private List<IEvent> listEvent;
  protected List<IEvent> newEvent = new ArrayList<>();

  /**
   * Constructs an AEvent object with the specified event time.
   * 
   * @param eventTime The time at which the event occurs.
   */
  public AEvent(double eventTime) {
    this.eventTime = eventTime;
    this.listEvent = new ArrayList<>();
  }

  /**
   * Creates a new event. Implementation should define the logic for creating a
   * new event.
   */
  @Override
  public void NewEvent() {
    // Implement logic for creating new Event
  }

  /**
   * Updates the simulation. Implementation should define how the simulation is
   * updated.
   * 
   * @return true if the simulation was successfully updated.
   */
  @Override
  public boolean UpdateSimulation() {
    return true;
    // Implement logic for updating the simulation
  }

  /**
   * Handles the event. As this is an abstract class, the implementation should
   * define the specific handling logic.
   * 
   * @throws IllegalStateException if this method is called directly on AEvent.
   */
  @Override
  public void HandleEvent() {
    throw new IllegalStateException("This is an abstract method.");
  }

  /**
   * Adds an event to the list of events.
   * 
   * @param event The event to be added.
   */
  @Override
  public void addEvent(IEvent event) {
    listEvent.add(event);
  }

  /**
   * Returns the list of events.
   * 
   * @return A list of IEvent objects.
   */
  @Override
  public List<IEvent> getEvents() {
    return listEvent;
  }

  /**
   * Adds a list of events to the current list of events.
   * 
   * @param events The list of events to be added.
   */
  @Override
  public void addEvents(List<IEvent> events) {
    listEvent.addAll(events);
  }

  /**
   * Returns the time at which the event occurs.
   * 
   * @return The event time.
   */
  @Override
  public double getEventTime() {
    return this.eventTime;
  }
}
