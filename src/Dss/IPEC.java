package dss;

import java.util.List;

import ep.Individual;

/**
 * The IPEC interface provides a contract for the Priority Event Container in a
 * simulation. It defines methods for adding, removing, and managing events.
 */

public interface IPEC {

  public void addEvent(IEvent Event);

  public void addEvents(List<IEvent> events);

  public IEvent nextEvent();

  public boolean isEmpty();

  public void removeIndividual(Individual individual);

  public IEvent AddToPEC(Object aIEvent);
}
