package dss;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.PriorityQueue;
import ep.Death;
import ep.Reproduction;
import ep.Mutation;
import ep.Individual;

public class PEC implements IPEC {
  private int maxTime;
  private PriorityQueue<IEvent> pec;

  public PEC() {
    pec = new PriorityQueue<>((e1, e2) -> Double.compare(e1.getEventTime(), e2.getEventTime()));
  }

  @Override
  public void addEvent(IEvent event) {
    pec.add(event);
  }

  @Override
  public void removeIndividual(Individual individual) {
    Iterator<IEvent> it = pec.iterator();
    while (it.hasNext()) {
      if (it instanceof Death) {
        Death death = (Death) it;
        if (death.getIndividual() == individual) {
          it.remove();
        }
      } else if (it instanceof Reproduction) {
        Reproduction reproduction = (Reproduction) it;
        if (reproduction.getIndividual() == individual) {
          it.remove();
        }
      } else if (it instanceof Mutation) {
        Mutation mutation = (Mutation) it;
        if (mutation.getIndividual() == individual) {
          it.remove();
        }
      }
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
