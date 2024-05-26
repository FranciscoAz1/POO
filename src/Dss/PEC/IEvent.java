package dss.pec;

import java.util.List;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 * @see AEvent
 */
public interface IEvent {

    /** This function gives the time of the event
     * @return the time of the event
     */
    public double getEventTime();

    /** This function handles the event, doing everything
     * Also, updates the time of the event, for the next event of its type to be scheduled
     */
    public void handleEvent();

    /**This function updates the State of the Simulation
     * 
     */
    public void updateSimulationState();

    /** This function gives the information about the validity of the event
     * @return if true, event is still valid, if false, event is no longer valid
     */
    public boolean valid();

    /**This function gives a list of new Events created while handling the Event.
     * It also resets the list
     * @return a list of new Events
     */
    public List<IEvent> getNewEvents();
}