package dss;

import java.util.Vector;

import dss.pec.IEvents;
import dss.pec.IPEC;

public class Simulate implements ISimulate {
	private int _eventID;
	private IPEC _pec;
	private int _sImulationTime;
	private IEvent _currentEvent;
	private int _currentTime;
	public IEvents _unnamed_IEvents_;
	public Vector<IPEC> _eventSet = new Vector<IPEC>();

	public void SimulateEvents() {
		throw new UnsupportedOperationException();
	}

	public void AddToPEC(IEvents aEvents) {
		throw new UnsupportedOperationException();
	}

	public void run() {
		throw new UnsupportedOperationException();
	}

	public void AddtToPEC() {
		throw new UnsupportedOperationException();
	}
}