package dss;

public interface IEvent {

  public void NewEvent();

  public void UpdateSimulation();

  public boolean HandleEvent();

  public double getEventTime(); // Declare the method in the interface
}
