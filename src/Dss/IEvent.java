package dss;

import java.util.List;

public interface IEvent {

  public void NewEvent();

  public void UpdateSimulation();

  public boolean HandleEvent();

  public void addEvent(IEvent event);

  public List<IEvent> getEvents();

  public double getEventTime(); // Declare the method in the interface
}
