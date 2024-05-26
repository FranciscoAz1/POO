package dss;

public interface IEvent {

  public void NewEvent();

  public void UpdateSimulation();

  public void HandleEvent();

  public double getActionInstant(); // Declare the method in the interface
}
