package dss.pec;

import java.util.ArrayList;
import java.util.List;

public class AEvent implements IEvent {
    private List<IEvent> listEvent;
    private int eventTime;
    protected List<IEvent> newEvent = new ArrayList<>();

    public AEvent() {
        listEvent = new ArrayList<>();
    }

    @Override
    public void NewEvent() {
        // Implement logic for creating new Event
    }

    @Override
    public void UpdateSimulation() {
        // Implement logic for updating the simulation
    }

    @Override
    public void HandleEvent() {
        // Implement logic for handling Event
    }

    public void addEvent(IEvent event) {
        listEvent.add(event);
    }

    public List<IEvent> getEvent() {
        return listEvent;
    }
}