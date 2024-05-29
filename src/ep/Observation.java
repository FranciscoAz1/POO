package ep;

import java.util.List;
import java.util.Vector;

import dss.AEvent;

public class Observation extends AEvent implements IObservation {
  private int counter = 0;
  private double finalInstance;
  private int actualTime;
  private Population population;

  public Observation(double time, double finalInstance, Population population) {
    super(time);
    this.population = population;
    this.finalInstance = finalInstance;
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
    sb.append("Observation " + this.counter + ":");
    String topic1 = sb.toString();

    sb = new StringBuilder();
    sb.append(String.format("Present instant:\t\t%.2f\n", this.eventTime));
    // sb.append(String.format("Number of realized events:\t%d\n",
    // population.getRealizedEvents()));
    sb.append(String.format("Population size:\t\t%d\n", population.getPopulation().size()));
    sb.append(String.format("Number of epidemics:\t\t%d\n", population.getEpidemic().getCounter()));
    sb.append(String.format("Best distribuition of the patrols:"));
    sb.append(Best_Fitted_Individual.getBestIndividual().toString());
    sb.append(
        String.format("Empire policing time::\t\t%f\n", Best_Fitted_Individual.getBestIndividual().getPolicingTime()));
    sb.append(String.format("Confort: \t\t%f\n", Best_Fitted_Individual.getBestIndividual().getConfort()));
    sb.append(String.format("Other candidate distributions:"));
    List<Individual> otherCandidates = Best_Fitted_Individual.getBest5(population.getPopulation());
    for (int i = 0; i < otherCandidates.size(); i++) {
      Individual candidate = otherCandidates.get(i);
      sb.append(candidate.toString());
      sb.append(String.format(": \t\t%f", candidate.getPolicingTime()));
      sb.append(String.format(": \t\t%f", candidate.getConfort()));
    }
    this.counter++;
    // Program the event time for the next TimeEvent
    this.eventTime = (counter * finalInstance) / 20;
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
