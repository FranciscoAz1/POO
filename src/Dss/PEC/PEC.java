package dss.pec;

import java.util.PriorityQueue;

public class PEC implements IPEC {
    private int eventID;
    private int maxTime;
    private int instant;
    private PriorityQueue<IEvent> eventSet;

    public PEC() {
        eventSet = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getTime(), e2.getTime()));
    }

    @Override
    public void addEvent(IEvents events) {
        if (events instanceof AEvents) {
            for (IEvent event : ((AEvents) events).getEvents()) {
                eventSet.add(event);
            }
        }
    }

    @Override
    public IEvent nextEvent() {
        return eventSet.poll();
    }

    @Override
    public boolean isEmpty() {
        return eventSet.isEmpty();
    }

    public void OrderEvents() {
        // If ordering is needed beyond priority queue's natural ordering, implement here
    }

    public IEvents AddToPEC(Object aIEvents) {
        if (aIEvents instanceof IEvents) {
            addEvent((IEvents) aIEvents);
        }
        return (IEvents) aIEvents;
    }
}