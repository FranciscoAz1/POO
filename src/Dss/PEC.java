package dss;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.PriorityQueue;
import ep.Death;
import ep.Reproduction;
import ep.Mutation;
import ep.Individual;

/**
 * The PEC class implements the IPEC interface. It provides functionality for
 * managing events in a simulation using a priority queue.
 */

public class PEC implements IPEC {
  private int maxTime;
  private PriorityQueue<IEvent> pec;

  /**
   * Constructs a PEC object with an empty priority queue for managing events.
   */
  public PEC() {
    pec = new PriorityQueue<>((e1, e2) -> Double.compare(e1.getEventTime(), e2.getEventTime()));
  }

  /**
   * Adds an event to the priority queue.
   *
   * @param event the event to add
   */
  @Override
  public void addEvent(IEvent event) {
    pec.add(event);
  }

  public void addEvents(List<IEvent> events) {
    pec.addAll(events);
  }

  /**
   * Removes an individual from the priority queue.
   * Removes any events associated with the individual.
   *
   * @param individual the individual to remove
   */
  @Override
  public void removeIndividual(Individual individual) {
    Iterator<IEvent> it = pec.iterator();
    while (it.hasNext()) {
      IEvent event = it.next();
      if (event instanceof Death) {
        Death death = (Death) event;
        if (death.getIndividual() == individual) {
          it.remove();
        }
      } else if (event instanceof Reproduction) {
        Reproduction reproduction = (Reproduction) event;
        if (reproduction.getIndividual() == individual) {
          it.remove();
        }
      } else if (event instanceof Mutation) {
        Mutation mutation = (Mutation) event;
        if (mutation.getIndividual() == individual) {
          it.remove();
        }
      }
    }
  }

  /**
   * Returns the next event in the priority queue.
   *
   * @return the next event
   */
  @Override
  public IEvent nextEvent() {
    // System.out.println("-> PEC next event: " + pec.peek());
    return pec.poll();
  }

  /**
   * Checks if the priority queue is empty.
   *
   * @return true if the priority queue is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    // System.out.println(" PEC should be empty");
    return pec.isEmpty();
  }

  /**
   * Adds an event to the priority queue.
   *
   * @param aIEvent the event to add
   * @return the event that was added
   */
  public IEvent AddToPEC(Object aIEvent) {
    if (aIEvent instanceof IEvent) {
      addEvent((IEvent) aIEvent);
    }
    // System.out.println("Event added to PEC: " + aIEvent);
    return (IEvent) aIEvent;
  }

  /**
   * Prints the current state of the priority queue.
   */
  public void printPEC() {
    // System.out.println("Current state of PEC:");
    for (IEvent event : pec) {
      System.out.println(event);
    }
  }
}
