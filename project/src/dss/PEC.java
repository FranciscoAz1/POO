package dss;

import java.util.List;
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
   * @param event The event to add.
   */
  @Override
  public void addEvent(IEvent event) {
    pec.add(event);
  }

  /**
   * Adds a list of events to the priority queue.
   *
   * @param events The list of events to add.
   */
  public void addEvents(List<IEvent> events) {
    pec.addAll(events);
  }

  /**
   * Removes an individual from the priority queue.
   * Removes any events associated with the individual.
   *
   * @param individual The individual to remove.
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
   * @return The next event.
   */
  @Override
  public IEvent nextEvent() {
    return pec.poll();
  }

  /**
   * Checks if the priority queue is empty without counting Observation events.
   *
   * @return true if the priority queue is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    Iterator<IEvent> it = pec.iterator();
    while (it.hasNext()) {
      IEvent event = it.next();
      if (event instanceof Death) {
        return false;
      } else if (event instanceof Reproduction) {
        return false;
      } else if (event instanceof Mutation) {
        return false;
      }
    }
    return true;
  }

  /**
   * Adds an event to the priority queue.
   *
   * @param aIEvent The event to add.
   * @return The event that was added.
   */
  public IEvent AddToPEC(Object aIEvent) {
    if (aIEvent instanceof IEvent) {
      addEvent((IEvent) aIEvent);
    }
    return (IEvent) aIEvent;
  }

  /**
   * Prints the current state of the priority queue.
   */
  public void printPEC() {
    for (IEvent event : pec) {
      System.out.println(event);
    }
  }
}
