package dss.pec;

import java.util.ArrayList;
import java.util.List;

public class AEvents implements IEvents {
    private List<IEvent> listEvents;
    private int eventTime;
    protected List<IEvent> newEvents = new ArrayList<>();

    public AEvents() {
        listEvents = new ArrayList<>();
    }

    @Override
    public void NewEvents() {
        // Implement logic for creating new events
    }

    @Override
    public void UpdateSimulation() {
        // Implement logic for updating the simulation
    }

    @Override
    public void HandleEvents() {
        // Implement logic for handling events
    }

    public void addEvent(IEvent event) {
        listEvents.add(event);
    }

    public List<IEvent> getEvents() {
        return listEvents;
    }
}