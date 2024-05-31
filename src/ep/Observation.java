package ep;

import java.util.List;

import dss.AEvent;
import utils.ContinuousFileWriter;

/**
 * The Observation class provides a contract for observation events in a
 * simulation.
 */
public class Observation extends AEvent implements IObservation {
  private int i = 0;
  private Population population;
  private ContinuousFileWriter file;

  /**
   * Constructs an Observation object with the specified time, final instance,
   * population, and i.
   * 
   * @param time          the time of the observation
   * @param finalInstance the final instance of the observation
   * @param population    the population of the observation
   * @param i             the i of the observation
   */
  public Observation(double time, Population population, int i) {
    super(time);
    this.population = population;
    this.i = i;
    this.file = new ContinuousFileWriter("output.txt");
  }

  /**
   * Constructs an Observation object with the specified time, final instance,
   * population, i, and actual time.
   * 
   * @param time          the time of the observation
   * @param finalInstance the final instance of the observation
   * @param population    the population of the observation
   * @param i             the i of the observation
   * @param actualTime    the actual time of the observation
   */
  @Override
  public void NewEvent() {
    throw new UnsupportedOperationException("Unimplemented method 'NewEvent'");
  }

  /**
   * Updates the simulation.
   * 
   * @return true if the simulation was successfully updated.
   */
  @Override
  public boolean UpdateSimulation() {
    if (population.getBestIndividual().getBestIndividual().getConfort() >= 1) {
      return false;
    }
    if (population.getPopulation().size() == 0) {
      return false;
    }
    return true;
  }

  /**
   * Handles the event by printing the observation.
   * 
   * @return true if the event was successfully handled.
   */
  @Override
  public void HandleEvent() {
    StringBuilder sb = new StringBuilder();
    List<Individual> otherCandidates = population.getBestIndividual().getBest5(population.getPopulation());
    Individual bestIndividual = population.getBestIndividual().getBestIndividual(); // Obtendo o melhor indivíduo já registrado
    double bestConfort = bestIndividual.getConfort(); // Obtendo o melhor conforto já registrado
    double bestPolicingTime = bestIndividual.getPolicingTime(); // Obtendo o melhor tempo de policiamento já registrado
    sb.append("Observation:\t\t\t\t" + this.i + "\n");
    sb.append("Present instant:\t\t\t" + String.format("%.2f", this.eventTime) + "\n");
    sb.append("Number of realized events:\t\t" + population.getNumEvents() + "\n");
    sb.append("Population size:\t\t\t" + population.getPopulation().size() + "\n");
    sb.append("Number of epidemics:\t\t\t" + population.getEpidemicCounter() + "\n");
    sb.append(
        "Best distribution of the patrols:" + population.getBestIndividual().getBestIndividual().toString() + "\n");
    sb.append("Empire policing time:\t\t"
        + String.format("%.2f", population.getBestIndividual().getBestIndividual().getPolicingTime()) + "\n");
    sb.append("Comfort:\t\t\t"
            + String.format("%.2f", bestConfort) + "\n");
    sb.append("Other candidate distributions:\n");

    for (int i = 0; i < otherCandidates.size(); i++) {
      Individual candidate = otherCandidates.get(i);
      sb.append("\t\t\t\t" + candidate.toString() + " : " + String.format("%.2f", candidate.getPolicingTime()) + " : "
          + String.format("%.2f", candidate.getConfort()) + "\n");
    }
    // Program the event time for the next TimeEvent
    System.out.println(sb.toString());
    // file.writeToFile(sb.toString() + "\n");
  }

  /**
   * Returns a string representation of the Observation event.
   * 
   * @return a string representation of the Observation event
   */
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
