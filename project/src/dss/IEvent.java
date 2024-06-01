package dss;

import java.util.List;

/**
 * The IEvent interface provides a contract for event objects in a simulation.
 * It defines methods for handling, updating, and managing events.
 */
public interface IEvent {

  public void NewEvent();

  public boolean UpdateSimulation();

  public void HandleEvent();

  public void addEvents(List<IEvent> events);

  public void addEvent(IEvent event);

  public List<IEvent> getEvents();

  public double getEventTime(); // Declare the method in the interface
}
