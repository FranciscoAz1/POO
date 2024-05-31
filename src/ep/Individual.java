package ep;

import java.util.List;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dss.IEvent;
import pa.PlanetarySystem;
import rand.Utils;
import pa.Patrol;

/**
 * The Individual class represents an individual in a population. It contains
 * methods for creating distributions, assigning systems to patrols, calculating
 * comfort, and printing troop distributions.
 */
public class Individual {

  private Map<Patrol, Set<PlanetarySystem>> distribution;
  private Population population;

  private double confort = Double.NaN;
  private double policingTime = Double.NaN;

  // private int id; // Adicionando o campo id

  // p1 - 1 , 3, 4
  // p2 - 2 , 5
  // p3 - 7

  /**
   * Constructs an Individual object with a specified population, patrols, and
   * planetary systems.
   *
   * @param population       The population to assign.
   * @param patrols          The patrols to assign.
   * @param planetarySystems The planetary systems to assign.
   */
  public Individual(Population population, List<Patrol> patrols, ArrayList<PlanetarySystem> planetarySystems) {
    // this.id = id; // Inicializando o id
    this.population = population;
    this.distribution = new HashMap<>();
    createDistribution(patrols, planetarySystems);
  }

  /**
   * Constructs an Individual object by copying another individual.
   *
   * @param individual The individual to copy.
   */
  public Individual(Individual individual) {
    this.distribution = individual.getDistribution();
    this.population = individual.getPopulation();
  }

  /**
   * Creates a distribution of planetary systems among patrols.
   * 
   * @param patrols          The patrols to assign.
   * @param planetarySystems The planetary systems to assign.
   */
  private void createDistribution(List<Patrol> patrols, ArrayList<PlanetarySystem> planetarySystems) {
    // Randomly distribute planetary systems among patrols
    Collections.shuffle(planetarySystems);
    for (var system : planetarySystems) {
      var patrol = Utils.getRandomElement(patrols);
      assignSystemToPatrol(patrol, system);
    }
  }

  /**
   * Assigns a planetary system to a patrol.
   *
   * @param patrol The patrol to assign.
   * @param system The planetary system to assign.
   */
  public void assignSystemToPatrol(Patrol patrol, PlanetarySystem system) {
    distribution.computeIfAbsent(patrol, k -> new HashSet<>()).add(system);
  }

  /**
   * Returns the population of the individual.
   * 
   * @return The population of the individual.
   */
  public Population getPopulation() {
    return population;
  }

  /**
   * Returns the comfort of the individual, recalculating if necessary.
   * 
   * @return The comfort of the individual.
   */
  public double getNewConfort() {
    calculateConfort();
    return confort;
  }

  /**
   * Returns the comfort of the individual.
   * 
   * @return the comfort of the individual
   */
  public double getConfort() {
    if (Double.isNaN(this.confort)) {
      calculateConfort();
    }
    return confort;
  }

  /**
   * Returns the policing time of the individual.
   * 
   * @return The policing time of the individual.
   */
  public double getPolicingTime() {
    if (Double.isNaN(this.policingTime)) {
      calculateConfort();
    }
    return this.policingTime;
  }

  /**
   * Returns the distribution of the individual.
   * 
   * @return The distribution of the individual.
   */
  public Map<Patrol, Set<PlanetarySystem>> getDistribution() {
    return distribution;
  }

  /**
   * Calculates the comfort of the individual based on the assigned patrols and
   * planetary systems.
   */
  public void calculateConfort() {
    double timez = 0;
    for (Map.Entry<Patrol, Set<PlanetarySystem>> entry : distribution.entrySet()) {
      Patrol patrol = entry.getKey();
      Set<PlanetarySystem> systems = entry.getValue();

      for (PlanetarySystem system : systems) {
        double time = patrol.getTimeRequired().getOrDefault(system, -1);
        if (time == -1) {
          System.out.println("Error in calculating confort for Individual");
        }
        timez += time;
      }
    }
    double confort = ep.Confort.tmin;
    this.policingTime = timez;
    this.confort = ep.Confort.tmin / timez;
  }

  /**
   * Creates a list of events for the individual.
   * 
   * @return A list of events for the individual.
   */
  public List<IEvent> createEvents() {
    List<IEvent> events = new ArrayList<>();
    events.add(new Reproduction(this));
    events.add(new Mutation(this));
    events.add(new Death(this));
    return events;
  }

  /**
   * Creates a list of events for the individual with a specific time.
   * 
   * @param time The time to create the events.
   * @return A list of events for the individual.
   */
  public List<IEvent> createEvents(double time) {
    List<IEvent> events = new ArrayList<>();
    events.add(new Reproduction(this, time));
    events.add(new Mutation(this, time));
    events.add(new Death(this, time));
    return events;
  }

  /**
   * Returns a list of events for the individual.
   * 
   * @return A list of events for the individual.
   */
  public List<IEvent> getEvents() {
    return createEvents();
  }

  /**
   * Returns a list of events for the individual with a specific time.
   * 
   * @param time The time to create the events.
   * @return A list of events for the individual.
   */
  public List<IEvent> getNewEvents(double time) {
    return createEvents(time);
  }


  /**
   * Prints the troop distribution over time.
   */
  public void printTroopDistribution() {
    for (Map.Entry<Patrol, Set<PlanetarySystem>> entry : distribution.entrySet()) {
      Patrol patrol = entry.getKey();
      Set<PlanetarySystem> systems = entry.getValue();

      System.out.println();
      System.out.print("Patrol " + patrol.getId() + ":");
      for (PlanetarySystem system : systems) {
        int days = patrol.getTimeRequired().getOrDefault(system, -1);
        if (days == -1) {
          System.out.print("[ p" + system.getId() + " n]");
        } else
          System.out
              .print("[ p" + system.getId() + " " + days + "]");
      }
      System.out.println();
    }
  }

  /**
   * Sets the distribution of the individual.
   * 
   * @param distribution The distribution to set.
   */
  public void setDistribution(Map<Patrol, Set<PlanetarySystem>> distribution) {
    calculateConfort();
    this.distribution = distribution;
  }

  /**
   * Sets the comfort of the individual.
   * 
   * @param comfort The comfort to set.
   */
  public void setConfort(double confort) {
    this.confort = confort;
  }

  /**
   * Compares the distribution of two individuals for equality.
   * 
   * @param individualA The first individual to compare.
   * @param individualB The second individual to compare.
   * @return true if the distributions are equal, false otherwise.
   */
  public static boolean equalsByDistribution(Individual individualA, Individual individualB) {
    /*
     * 
     * The first for loop iterates over the patrol distribution of individualA
     * and checks if the patrols and their corresponding systems are equal
     * in both individualA and individualB.
     *
     * The second for loop iterates over the patrol distribution of individualB
     * and checks if all the patrols present in this individual are also present
     * in the patrol distribution of individualA.
     *
     * This ensures that the patrol distribution of individualB does not
     * contain patrols that are not present in the patrol distribution of
     * individualA.
     * 
     */

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Individual that = (Individual) o;
    return Objects.equals(distribution, that.distribution);
  }

  @Override
  public int hashCode() {
    return Objects.hash(distribution);
  }

  // Static method for comparing by distribution if needed
  public static boolean equalsByDistribution(Individual a, Individual b) {
    return Objects.equals(a.distribution, b.distribution);
  }

  /**
   * Returns a string representation of the individual.
   * 
   * @return A string representation of the individual.
   */
  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("{");
    for (Map.Entry<Patrol, Set<PlanetarySystem>> entry : distribution.entrySet()) {
      Patrol patrol = entry.getKey();
      output.append("{");
      Set<PlanetarySystem> systems = entry.getValue();
      for (PlanetarySystem system : systems) {
        output.append(+system.getId() + ",");
      }
      if (!systems.isEmpty()) {
        output.setLength(output.length() - 1);
      }
      output.append("},");
    }
    if (!distribution.isEmpty()) {
      output.setLength(output.length() - 1);
    }
    output.append("}");
    if (output.length() == 0) {
      throw new NullPointerException("Leitura de indivíduo falhou");
    }
    return output.toString();
  }

  /**
   * Returns the id of the individual.
   * 
   * @return The id of the individual.
   */
  public void updateFrom(Individual other) {
    // Atualize os atributos conforme necessário
    this.distribution = other.getDistribution();
    this.confort = other.getConfort();
    this.policingTime = other.getPolicingTime();
    // Adicione os demais atributos que precisam ser atualizados
  }
}
