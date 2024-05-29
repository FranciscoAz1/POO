package ep;

import java.util.List;
import java.util.Vector;

import dss.AEvent;

public class Observation extends AEvent implements IObservation {
  private int i = 0;
  private double finalInstance;
  private int actualTime;
  private Population population;

  public Observation(double time, double finalInstance, Population population, int i) {
    super(time);
    this.population = population;
    this.finalInstance = finalInstance;
    this.i = i;
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
    StringBuilder sb = new StringBuilder();

    sb.append("Observation:\t\t\t\t" + this.i + "\n");
    sb.append("Present instant:\t\t\t" + String.format("%.2f", this.eventTime) + "\n");
    sb.append("Population size:\t\t\t" + population.getPopulation().size() + "\n");
    sb.append("Number of epidemics:\t\t\t" + population.getEpidemic().getCounter() + "\n");
    sb.append("Best distribution of the patrols:\t" + Best_Fitted_Individual.getBestIndividual().toString() + "\n");
    sb.append("Empire policing time:\t\t\t"
        + String.format("%.2f", Best_Fitted_Individual.getBestIndividual().getPolicingTime()) + "\n");
    sb.append("Comfort:\t\t\t\t" + String.format("%.2f", Best_Fitted_Individual.getBestIndividual().getConfort()) + "\n");
    sb.append("Other candidate distributions:\n");

    List<Individual> otherCandidates = Best_Fitted_Individual.getBest5(population.getPopulation());
    for (int i = 0; i < otherCandidates.size(); i++) {
      Individual candidate = otherCandidates.get(i);
      sb.append("\t\t\t\t\t" + candidate.toString() + " : " + String.format("%.2f", candidate.getPolicingTime()) + " : "
          + String.format("%.2f", candidate.getConfort()) + "\n");
    }
    // Program the event time for the next TimeEvent
    System.out.println(sb.toString());
    return true;
    
  }

  public String indentString(String string, int spaces) {
    StringBuilder sb = new StringBuilder();
    String[] lines = string.split("\\r?\\n");

    for (String line : lines) {
      sb.append(" ".repeat(spaces)); // Add the desired number of spaces
      sb.append(line).append("\n"); // Append the original line with a newline character
    }

    return sb.toString();
  }
}
