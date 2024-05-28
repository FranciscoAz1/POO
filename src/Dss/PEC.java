package dss;

import java.util.PriorityQueue;

public class PEC implements IPEC {
  private int maxTime;
  private PriorityQueue<IEvent> pec;

  public PEC() {
    pec = new PriorityQueue<>((e1, e2) -> Double.compare(e1.getEventTime(), e2.getEventTime()));
  }

  @Override
  public void addEvent(IEvent Event) {
    if (Event instanceof IEvent) {
      for (IEvent event : ((IEvent) Event).getEvents()) {
        pec.add(event);
        printPEC(); // to check the current state of PEC
        System.out.println(" PEC should be empty");

      }
    }
  }

  @Override
  public IEvent nextEvent() {
    printPEC(); // to check the current state of PEC
    System.out.println("-> PEC next event: " + pec.peek());
    return pec.poll();
  }

  @Override
  public boolean isEmpty() {
    printPEC(); // to check the current state of PEC
    System.out.println(" PEC should be empty");

    return pec.isEmpty();
  }

  public void OrderEvent() {
    // Assuming maxTime is the maximum time for which you want to check Event
    for (int instant = 0; instant <= maxTime; instant++) {
      // Use a while loop to process all Event at this particular time
      while (!pec.isEmpty() && pec.peek().getEventTime() == instant) {
        IEvent event = pec.poll();
        // Process the event here
        printPEC(); // to check the current state of PEC
        System.out.println(" PEC  is ordering events");
      }
    }
  }

  public IEvent AddToPEC(Object aIEvent) {
    if (aIEvent instanceof IEvent) {
      addEvent((IEvent) aIEvent);
    }
    printPEC(); // to check the current state of PEC
    System.out.println("Event added to PEC: " + aIEvent);
    return (IEvent) aIEvent;
  }

  public void printPEC() {
    System.out.println("Current state of PEC:");
    for (IEvent event : pec) {
      System.out.println(event);
    }
  }
}
