package dss;

/**
 * The ISimulate interface provides a contract for simulation objects. It defines
 * methods for adding events to the Priority Event Container and running the simulation.
 */

public interface ISimulate {

  public void AddToPEC(IEvent aEvent);

  public void run();
}
