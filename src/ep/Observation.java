package ep;

import java.util.List;
import java.util.Vector;

import dss.AEvent;

public class Observation extends AEvent implements IObservation {
  private int _counter = 0;
  private int _finalInstante;
  private int _actualTime;
  private Population _population;

  public Observation() {
    super();
    throw new UnsupportedOperationException();
  }

  @Override
  public void NewEvent() {
    throw new UnsupportedOperationException("Unimplemented method 'NewEvent'");
  }

  @Override
  public void UpdateSimulation() {
    throw new UnsupportedOperationException("Unimplemented method 'UpdateSimulation'");
  }

  @Override
  public boolean HandleEvent() {
    throw new UnsupportedOperationException("Unimplemented method 'HandleEvent'");
  }

  @Override
  public double getEventTime() {
    throw new UnsupportedOperationException("Unimplemented method 'getEventTime'");
  }
}
