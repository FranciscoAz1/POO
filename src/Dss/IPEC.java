package dss;

import ep.Individual;

public interface IPEC {

  public void addEvent(IEvent Event);

  public IEvent nextEvent();

  public boolean isEmpty();

  public void removeIndividual(Individual individual);

  public IEvent AddToPEC(Object aIEvent);
}
