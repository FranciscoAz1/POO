package ep;

import dss.IEvent;

/**
 * The IObservation interface provides a contract for observation events in a
 * simulation.
 */
public interface IObservation extends IEvent {
  public String indentString(String string, int spaces);
}
