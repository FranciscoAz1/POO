package pa;

import main.Args;
import dss.PEC; // NEED EVENT COUNTER

public class Observation {

  private int ObsID;
  private int PresentInstant;
  private int NumberEvent;
  private int PopulationSize;
  private int NumberEpidemics;
  private int BestDistPatrols;
  private int EmpirePolicingTime;
  private int Confort;
  private int OtherDistPatrols;

  public Observation() {
    // TODO - implement Observation.Observation
    double TempoMax = Args.tau;
    double incremento = TempoMax / 20;
    int counter = 0;
    for (double i = TempoMax / 20; i <= TempoMax; i = i + incremento) {
      ObsID = counter;
      // PresentInstant = i;
      // NumberEvent = this.NumberEvent;
      //
      // // NumberEpidemics
      // // BestDistPatrols
      //
      // Confort = Confort.pa;

      // OtherDistPatrols

      counter++;
    }
  }

}
