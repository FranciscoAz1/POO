package dss.pec;

public interface IEvent {

	public void NewEvent();

	public void UpdateSimulation();

	public void HandleEvent();

	public int getActionInstant(); // Declare the method in the interface
}