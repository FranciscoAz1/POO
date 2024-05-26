package dss;

import java.util.Vector;

public class Simulate implements ISimulate {
  private IPEC pec;
  private double simulationTime;
  private IEvent currentEvent;
  private double currentTime;
  public IEvent unnamed_IEvent_;

  public Simulate(double simulationTime) {
    this.simulationTime = simulationTime;
    this.currentTime = 0;
  }

  @Override
  public void AddToPEC(IEvent aEvent) {
    pec.addEvent(aEvent);
  }

  @Override
  public void run() {
    while (currentTime < simulationTime && !pec.isEmpty()) {
      currentEvent = pec.nextEvent();

      currentTime = currentEvent.getActionInstant();
      if (currentTime > simulationTime) {
        break;
      }
      currentEvent.HandleEvent();
    }
  }
}
