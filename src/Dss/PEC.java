package dss;

import java.util.PriorityQueue;

public class PEC implements IPEC {
  private int maxTime;
  private PriorityQueue<IEvent> pec;

  public PEC() {
    pec = new PriorityQueue<>((e1, e2) -> Double.compare(e1.getEventTime(), e2.getEventTime()));
  }

  @Override
  public void addEvent(IEvent event) {
    if (event instanceof IEvent) {
      pec.add(event);
    }
  }

  @Override
  public IEvent nextEvent() {
    // System.out.println("-> PEC next event: " + pec.peek());
    return pec.poll();
  }

  @Override
  public boolean isEmpty() {
    // System.out.println(" PEC should be empty");

    return pec.isEmpty();
  }

  public IEvent AddToPEC(Object aIEvent) {
    if (aIEvent instanceof IEvent) {
      addEvent((IEvent) aIEvent);
    }
    // System.out.println("Event added to PEC: " + aIEvent);
    return (IEvent) aIEvent;
  }

  public void printPEC() {
    // System.out.println("Current state of PEC:");
    for (IEvent event : pec) {
      System.out.println(event);
    }
  }
}
