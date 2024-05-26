package dss.pec;

import java.util.ArrayList;
import java.util.List;

/**
 * The AEvent class is an abstract class that implements the IEvent interface.
 * It provides common functionality for event objects in a simulation.
 * 
 * Note: The actual implementation of the IEvent interface is not shown here.
 * The AEvent class assumes that the IEvent interface exists and has appropriate functionality.
 */

public abstract class AEvent implements IEvent{
    protected double eventTime;
    protected List<IEvent> newEvents = new ArrayList<>();

    /**
     * Constructs a new AEvent object with the specified event time.
     *
     * @param eventTime the time at which the event occurs
     */
    public AEvent(double eventTime){
        this.eventTime = eventTime;
    }

    @Override
    public double getEventTime(){
        return eventTime;
    }

    @Override
    public List<IEvent> getNewEvents(){
        //Copies the list, clears the original one, and returns the copy
        List<IEvent> eventsCopy = new ArrayList<>(newEvents);
        newEvents.clear();
        return eventsCopy;
    }

    @Override
    public void updateSimulationState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSimulationState'");
    }

    @Override
    public boolean valid() {
        return true;
    }

    @Override
    public void handleEvent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleEvent'");
    }
}
