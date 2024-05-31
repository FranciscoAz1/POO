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
   * @param population       the population to assign
   * @param patrols          the patrols to assign
   * @param planetarySystems the planetary systems to assign
   */
  public Individual(Population population, List<Patrol> patrols, ArrayList<PlanetarySystem> planetarySystems) {
    // this.id = id; // Inicializando o id
    this.population = population;
    this.distribution = new HashMap<>();
    createDistribution(patrols, planetarySystems);
  }

  /**
   * Constructs an Individual object with a specified population, patrols, and
   * planetary systems.
   * 
   * @param individual
   */
  public Individual(Individual individual) {
    this.distribution = individual.getDistribution();
    this.population = individual.getPopulation();
  }

  /**
   * Constructs an Individual object with a specified population, patrols, and
   * planetary systems.
   * 
   * @param population
   * @param distribution
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
   * @param patrol the patrol to assign
   * @param system the planetary system to assign
   */
  public void assignSystemToPatrol(Patrol patrol, PlanetarySystem system) {
    distribution.computeIfAbsent(patrol, k -> new HashSet<>()).add(system);
  }

  /**
   * Returns the population of the individual.
   * 
   * @return the population of the individual
   */
  public Population getPopulation() {
    return population;
  }

  /**
   * Returns the comfort of the individual.
   * 
   * @return the comfort of the individual
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
   * @return the policing time of the individual
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
   * @return the distribution of the individual
   */
  public Map<Patrol, Set<PlanetarySystem>> getDistribution() {
    return distribution;
  }

  /**
   * Returns the distribution of the individual.
   * 
   * @return the distribution of the individual
   */
  public void calculateConfort() {
    double total_time = 0;
    for (Map.Entry<Patrol, Set<PlanetarySystem>> entry : distribution.entrySet()) {
      double timez = 0.0;
      Patrol patrol = entry.getKey();
      Set<PlanetarySystem> systems = entry.getValue();

      for (PlanetarySystem system : systems) {
        double time = patrol.getTimeRequired().getOrDefault(system, -1);
        if (time == -1) {
          System.out.println("Error in calculating confort for Individual");
        }
        timez += time;
      }
      total_time += timez;
      this.confort = ep.Confort.tmin / timez;
    }
    this.policingTime = total_time;
  }

  /**
   * Creates a list of events for the individual.
   * 
   * @return a list of events for the individual
   */
  public List<IEvent> createEvents() {
    List<IEvent> events = new ArrayList<>();
    events.add(new Reproduction(this));
    events.add(new Mutation(this));
    events.add(new Death(this));
    return events;
  }

  /**
   * Creates a list of events for the individual. Equal to the above but creates
   * events with a specific time.
   * 
   * @param time the time to create the events
   * @return a list of events for the individual
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
   * @return a list of events for the individual
   */
  public List<IEvent> getEvents() {
    return createEvents();
  }

  /**
   * Returns a list of events for the individual. Equal to the above but creates
   * events with a specific time.
   * 
   * @param time the time to create the events
   * @return a list of events for the individual
   */
  public List<IEvent> getNewEvents(double time) {
    return createEvents(time);
  }

  /*
   * // Método para obter o ID do indivíduo
   * public int getId() {
   * return id;
   * }
   */

  /**
   * Method to print troop distribution over time
   * 
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
   * Sets the population of the individual.
   * 
   * @param population the population to set
   */
  public void setDistribution(Map<Patrol, Set<PlanetarySystem>> distribution) {
    calculateConfort();
    this.distribution = distribution;
  }

  /**
   * Sets the population of the individual.
   * 
   * @param population the population to set
   */
  public void setConfort(double confort) {
    this.confort = confort;
  }

  /**
   * Sets the population of the individual.
   * 
   * @param population the population to set
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

    for (Map.Entry<Patrol, Set<PlanetarySystem>> entry : individualA.distribution.entrySet()) {
      Patrol patrol = entry.getKey();
      Set<PlanetarySystem> systemsA = entry.getValue();
      Set<PlanetarySystem> systemsB = individualB.distribution.getOrDefault(patrol, new HashSet<>());
      if (!systemsA.equals(systemsB)) {
        // System.out.println("Indivíduos " + individualA + " e " + individualB + " têm
        // distribuições de patrulha diferentes.");
        return false;
      }
    }

    for (Map.Entry<Patrol, Set<PlanetarySystem>> entry : individualB.distribution.entrySet()) {
      Patrol patrol = entry.getKey();
      Set<PlanetarySystem> systemsB = entry.getValue();
      Set<PlanetarySystem> systemsA = individualA.distribution.getOrDefault(patrol, new HashSet<>());
      if (!systemsB.equals(systemsA)) {
        // System.out.println("Indivíduos " + individualA + " e " + individualB + " têm
        // distribuições de patrulha diferentes.");
        return false;
      }
    }

    // System.out.println("Indivíduos " + individualA + " e " + individualB + " têm
    // a mesma distribuição de patrulha.");
    return true;
  }

  /**
   * Returns a string representation of the individual.
   * 
   * @return a string representation of the individual
   */
  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("{");
    for (Map.Entry<Patrol, Set<PlanetarySystem>> entry : distribution.entrySet()) {
      Patrol patrol = entry.getKey();
      Set<PlanetarySystem> systems = entry.getValue();
      output.append("{");
      for (PlanetarySystem system : systems) {
        output.append(+system.getId());
        if (system != systems) {
          output.append(",");
        }
      }
      output.replace(output.length() - 1, output.length(), "},");
    }
    output.replace(output.length() - 1, output.length(), "}");
    if (output.length() == 0) {
      throw new NullPointerException("Leitura de indivíduo falhou");
    }
    return output.toString();
  }
}
