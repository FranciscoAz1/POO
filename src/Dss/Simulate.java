package dss;

import java.util.Vector;

import dss.pec.IEvent;
import dss.pec.IPEC;
import dss.pec.IEvent;

public class Simulate implements ISimulate {
    private int eventID;
    private IPEC pec;
    private int simulationTime;
    private IEvent currentEvent;
    private int currentTime;
    public IEvent unnamed_IEvent_;
    public Vector<IPEC> Eventet = new Vector<IPEC>();

    public Simulate(int simulationTime, IPEC pec) {
        this.simulationTime = simulationTime;
        this.pec = pec;
        this.currentTime = 0;
    }

    @Override
    public void SimulateEvent() {
        while (currentTime < simulationTime && !pec.isEmpty()) {
            currentEvent = pec.nextEvent();
            currentTime = currentEvent.getTime();
            currentEvent.execute();
        }
    }

    @Override
    public void AddToPEC(IEvent aEvent) {
        pec.addEvent(aEvent);
    }

    @Override
    public void run() {
        SimulateEvent();
    }

    @Override
    public void AddtToPEC() {
        throw new UnsupportedOperationException();
    }
}