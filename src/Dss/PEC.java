package dss;

import java.util.PriorityQueue;

public class PEC implements IPEC {
  private int maxTime;
  private PriorityQueue<IEvent> pec;

  public PEC() {
    pec = new PriorityQueue<>((e1, e2) -> Double.compare(e1.getActionInstant(), e2.getActionInstant()));
  }

  @Override
  public void addEvent(IEvent Event) {
    if (Event instanceof AEvent) {
      for (IEvent event : ((AEvent) Event).getEvent()) {
        pec.add(event);
      }
    }
  }

  @Override
  public IEvent nextEvent() {
    return pec.poll();
  }

  @Override
  public boolean isEmpty() {
    return pec.isEmpty();
  }

  public void OrderEvent() {
    // Assuming maxTime is the maximum time for which you want to check Event
    for (int instant = 0; instant <= maxTime; instant++) {
      // Use a while loop to process all Event at this particular time
      while (!pec.isEmpty() && pec.peek().getActionInstant() == time) {
        IEvent event = pec.poll();
        // Process the event here

      }
    }
  }

  public IEvent AddToPEC(Object aIEvent) {
    if (aIEvent instanceof IEvent) {
      addEvent((IEvent) aIEvent);
    }
    return (IEvent) aIEvent;
  }
}
