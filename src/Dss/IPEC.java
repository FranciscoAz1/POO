package dss;

public interface IPEC {

  public void OrderEvent();

  public void addEvent(IEvent Event);

  public IEvent nextEvent();

  public boolean isEmpty();

  public IEvent AddToPEC(Object aIEvent);
}