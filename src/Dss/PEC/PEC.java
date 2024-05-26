package dss.pec;

import java.util.PriorityQueue;

public class PEC implements IPEC {
    private int eventID;
    private int maxTime;
    private int instant;
    private PriorityQueue<IEvent> EventSet;

    public PEC() {
        EventSet = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getActionInstant(), e2.getActionInstant()));
    }
    

    @Override
    public void addEvent(IEvent Event) {
        if (Event instanceof AEvent) {
            for (IEvent event : ((AEvent) Event).getEvent()) {
                EventSet.add(event);
            }
        }
        System.out.println("Current EventSet: " + EventSet);
    }

    @Override
    public IEvent nextEvent() {
        IEvent event = EventSet.poll();
        if (event != null) {
            System.out.println("Polled event with details: " + event);
        } else {
            System.out.println("No events left to poll.");
        }
        System.out.println("EventSet after polling: " + EventSet);
        return event;
    
    }

    @Override
    public boolean isEmpty() {
        return EventSet.isEmpty();
    }

    public void OrderEvent() {
    // Assuming maxTime is the maximum time for which you want to check Event
    for (int instant = 0; instant <= maxTime; instant++) {
        // Use a while loop to process all Event at this particular time
        while (!EventSet.isEmpty() && EventSet.peek().getActionInstant() == time) {
            IEvent event = EventSet.poll();
            // Print the details of the event being processed
            System.out.println("Processing event at instant: " + instant + " with details: " + event);
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