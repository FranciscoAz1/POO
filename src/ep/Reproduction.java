package ep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import rand.Utils;

import dss.AEvent;
import pa.Patrol;
import pa.PlanetarySystem;
import rand.myMath;

/**
 * The Reproduction class represents an event in the simulation where an
 * individual reproduces.
 * It extends the AEvent class and overrides the HandleEvent method.
 */
public class Reproduction extends AEvent implements Ireproduction {
  private static final Random random = new Random();
  private Individual individual;
  private Map<Patrol, Set<PlanetarySystem>> distribution;

  /**
   * Constructs a Reproduction event for a specific individual.
   * The event time is calculated based on the individual's comfort level.
   * 
   * @param individual The individual who will reproduce in this event.
   */
  public Reproduction(Individual individual) {
    super(myMath.reproductionRate(individual.getConfort()));
    this.individual = individual;
  }

  /**
   * Constructs a Reproduction event for a specific individual at a specified
   * time.
   * 
   * @param individual The individual who will reproduce in this event.
   * @param time       The time at which the reproduction event occurs.
   */
  public Reproduction(Individual individual, double time) {
    super(time + myMath.reproductionRate(individual.getConfort()));
    this.individual = individual;
  }

  /**
   * Gets the individual associated with this reproduction event.
   * 
   * @return The individual who will reproduce in this event.
   */
  public Individual getIndividual() {
    return individual;
  }

  /**
   * Handles the reproduction event by creating a new individual and
   * redistributing
   * planetary systems among patrols.
   * 
   * @return true if the event was successfully handled.
   * @throws IllegalStateException if the individual's distribution is empty or
   *                               null.
   */
  @Override
  public void HandleEvent() {
    // check death of individual
    if (individual == null) {
      throw new IllegalStateException("Individual cannot be null.");
    }
    // if (!individual.getPopulation().getPopulation().contains(individual)) {
    // return false;
    // }
    distribution = individual.getDistribution();
    // Check if the distribution is not empty and has more than one patrol
    if (distribution == null || distribution.isEmpty()) {
      throw new IllegalStateException("There must be at least one patrol with planetary systems in the distribution.");
    }

    Individual newIndividual = new Individual(individual);
    Map<Patrol, Set<PlanetarySystem>> newDistribution = newIndividual.getDistribution();
    // Step 1 calculate ⌊(1 − ϕ(z))m⌋ systems to remove
    int nSystems = 0;
    // get total nSystems
    for (Set<PlanetarySystem> planetarySystems : distribution.values()) {
      nSystems += planetarySystems.size();
    }
    // ⌊(1 − ϕ(z))m⌋
    int nSystemsToRemove = (int) ((1 - individual.getConfort()) * nSystems);
    //
    Population pop = individual.getPopulation();
    int attempts = 50;
    do {
      attempts--;
      if (attempts == 0) {
        pop.addIndividual(newIndividual);
        break;
      }
      // Step 3: Randomly remove planetary systems from the new distribution
      List<PlanetarySystem> removedSystems = new ArrayList<>();
      for (int i = 0; i < nSystemsToRemove; i++) {
        Patrol randomPatrol = getRandomPatrolWithSystems(distribution);

        Set<PlanetarySystem> systems = newDistribution.get(randomPatrol);
        PlanetarySystem system = Utils.getRandomElementFromSet(systems);
        systems.remove(system);
        removedSystems.add(system);
      }

      // Step 4: Randomly redistribute the removed systems among the patrols
      for (PlanetarySystem system : removedSystems) {
        Patrol randomPatrol = getRandomPatrol(newDistribution);
        newDistribution.computeIfAbsent(randomPatrol, k -> new HashSet<>()).add(system);
      }
      // Step 5: add new individual to population
      newIndividual.setDistribution(newDistribution);
    } while (pop.tryAdd(newIndividual));
    // pop.forceAdd(newIndividual);

    double currentTime = getEventTime();
    // Epidemic may occur
    this.addEvents(Epidemic.MayOccur(pop, currentTime));
    // add events to the new individual, with the time of the parent individual
    // Agendar um novo evento de reprodução para o mesmo indivíduo
    Reproduction newReproductionEvent = new Reproduction(individual, getEventTime());

    addEvents(newIndividual.getNewEvents(currentTime));
    this.addEvent(newReproductionEvent);
    pop.countEvent();
  }

  /**
   * Gets a random patrol that has planetary systems in the distribution.
   * 
   * @param distribution The distribution of patrols and planetary systems.
   * @return A random patrol with planetary systems.
   */
  private Patrol getRandomPatrolWithSystems(Map<Patrol, Set<PlanetarySystem>> distribution) {
    List<Patrol> patrolsWithSystems = new ArrayList<>();
    for (Map.Entry<Patrol, Set<PlanetarySystem>> entry : distribution.entrySet()) {
      if (!entry.getValue().isEmpty()) {
        patrolsWithSystems.add(entry.getKey());
      }
    }
    return patrolsWithSystems.isEmpty() ? null : patrolsWithSystems.get(random.nextInt(patrolsWithSystems.size()));
  }

  /**
   * Gets a random patrol from the distribution.
   * 
   * @param distribution The distribution of patrols and planetary systems.
   * @return A random patrol.
   */
  private Patrol getRandomPatrol(Map<Patrol, Set<PlanetarySystem>> distribution) {
    List<Patrol> patrolList = new ArrayList<>(distribution.keySet());
    return patrolList.get(random.nextInt(patrolList.size()));
  }

  /**
   * Returns a string representation of the reproduction event.
   * 
   * @return A string representing the reproduction event with the event time.
   */
  @Override
  public String toString() {
    return "Reproduction Event{time= " + getEventTime() + "}";
  }
}
