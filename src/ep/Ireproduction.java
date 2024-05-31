package ep;

import dss.IEvent;

/**
 * The Ireproduction interface provides a contract for reproduction events in a simulation.
 */
public interface Ireproduction extends IEvent {

    public Individual getIndividual();

    public String toString();
}
