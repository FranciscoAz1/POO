package dss.pec;

import java.util.PriorityQueue;

public class PEC implements IPEC {
    private int eventID;
    private int maxTime;
    private int instant;
    private PriorityQueue<IEvent> Eventet;

    public PEC() {
        Eventet = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getActionInstant(), e2.getActionInstant()));
    }
    

    @Override
    public void addEvent(IEvent Event) {
        if (Event instanceof AEvent) {
            for (IEvent event : ((AEvent) Event).getEvent()) {
                Eventet.add(event);
            }
        }
    }

    @Override
    public IEvent nextEvent() {
        return Eventet.poll();
    }

    @Override
    public boolean isEmpty() {
        return Eventet.isEmpty();
    }

    public void OrderEvent() {
        // Assuming maxTime is the maximum time for which you want to check Event
        for (int time = 0; time <= maxTime; time++) {
            // Use a while loop to process all Event at this particular time
            while (!Eventet.isEmpty() && Eventet.peek().getTime() == time) {
                IEvent event = Eventet.poll();
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