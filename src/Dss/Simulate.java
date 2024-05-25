package dss;

import java.util.Vector;

import dss.pec.IEvents;
import dss.pec.IPEC;
import dss.pec.IEvent;

public class Simulate implements ISimulate {
    private int eventID;
    private IPEC pec;
    private int simulationTime;
    private IEvent currentEvent;
    private int currentTime;
    public IEvents unnamed_IEvents_;
    public Vector<IPEC> eventSet = new Vector<IPEC>();

    public Simulate(int simulationTime, IPEC pec) {
        this.simulationTime = simulationTime;
        this.pec = pec;
        this.currentTime = 0;
    }

    @Override
    public void SimulateEvents() {
        while (currentTime < simulationTime && !pec.isEmpty()) {
            currentEvent = pec.nextEvent();
            currentTime = currentEvent.getTime();
            currentEvent.execute();
        }
    }

    @Override
    public void AddToPEC(IEvents aEvents) {
        pec.addEvent(aEvents);
    }

    @Override
    public void run() {
        SimulateEvents();
    }

    @Override
    public void AddtToPEC() {
        throw new UnsupportedOperationException();
    }
}