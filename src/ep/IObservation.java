package ep;

import dss.IEvent;

/**
 * The IObservation interface provides a contract for observation events in a simulation.
 */
public interface IObservation extends IEvent {

    public void NewEvent();
 
    public boolean UpdateSimulation();

    public void HandleEvent();
}
