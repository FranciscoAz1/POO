package dss.pec;

import java.util.PriorityQueue;

public class PEC implements IPEC {
    private int eventID;
    private int maxTime;
    private int instant;
    private PriorityQueue<IEvent> eventSet;

    public PEC() {
        eventSet = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getActionInstant(), e2.getActionInstant()));
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
        // Assuming maxTime is the maximum time for which you want to check events
        for (int time = 0; time <= maxTime; time++) {
            // Use a while loop to process all events at this particular time
            while (!eventSet.isEmpty() && eventSet.peek().getTime() == time) {
                IEvent event = eventSet.poll();
                // Process the event here

            }
        }
    }
    
    public IEvents AddToPEC(Object aIEvents) {
        if (aIEvents instanceof IEvents) {
            addEvent((IEvents) aIEvents);
        }
        return (IEvents) aIEvents;
    }
}