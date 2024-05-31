package ep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import dss.AEvent;
import pa.Patrol;
import pa.PlanetarySystem;
import rand.myMath;

/**
 * The Mutation class provides a concrete implementation of a mutation event in
 * a simulation. It defines methods for handling mutation events.
 */
public class Mutation extends AEvent {
  private Individual individual;
  private Map<Patrol, Set<PlanetarySystem>> distribution;

  public Individual getIndividual() {
    return individual;
  }

  /**
   * Constructs a Mutation object with a specified individual.
   * 
   * @param individual
   */
  public Mutation(Individual individual) {
    super(myMath.mutationRate(individual.getConfort()));
    this.individual = individual;
  }

  /**
   * Constructs a Mutation object with a specified individual and time.
   * 
   * @param individual
   * @param time
   */
  public Mutation(Individual individual, double time) {
    super(time + myMath.mutationRate(individual.getConfort()));
    this.individual = individual;
  }

  /**
   * Handles the Mutation event by moving a planetary system from one patrol to
   * another.
   */
  @Override
  public void HandleEvent() {
    if (individual == null) {
      throw new IllegalStateException("Individual cannot be null.");
    }
    // // check death
    // if (individual.getPopulation().getPopulation().contains(individual)) {
    // return false;
    // }
    distribution = individual.getDistribution();
    // Check if the distribution is not empty and has more than one patrol
    if (distribution == null || distribution.isEmpty()) {
      throw new IllegalStateException("There must be at least one patrol with planetary systems in the distribution.");
    }

    Random random = new Random();

    List<Patrol> patrolList = new ArrayList<>(distribution.keySet());
    Patrol sourcePatrol = null;
    Set<PlanetarySystem> sourceSystems = null;
    boolean foundNonEmptyPatrol = false;

    // Try to find a patrol with at least one planetary system
    for (int i = 0; i < patrolList.size(); i++) {
      Patrol potentialSourcePatrol = patrolList.get(random.nextInt(patrolList.size()));
      Set<PlanetarySystem> potentialSourceSystems = distribution.get(potentialSourcePatrol);
      if (potentialSourceSystems != null && !potentialSourceSystems.isEmpty()) {
        sourcePatrol = potentialSourcePatrol;
        sourceSystems = potentialSourceSystems;
        foundNonEmptyPatrol = true;
        break;
      }
    }

    if (!foundNonEmptyPatrol) {
      throw new IllegalStateException("No patrols have any planetary systems.");
    }

    // Step 2: Select a random PlanetarySystem from the selected Patrol
    List<PlanetarySystem> systemList = new ArrayList<>(sourceSystems);
    PlanetarySystem systemToMove = systemList.get(random.nextInt(systemList.size()));

    // Step 3: Remove the selected PlanetarySystem from the selected Patrol
    sourceSystems.remove(systemToMove);

    // Ensure source patrol has no empty set
    if (sourceSystems.isEmpty()) {
      distribution.remove(sourcePatrol);
    }

    // Step 4: Select a different random Patrol
    Patrol destinationPatrol;
    do {
      destinationPatrol = patrolList.get(random.nextInt(patrolList.size()));
    } while (destinationPatrol.equals(sourcePatrol));

    // Step 5: Add the selected PlanetarySystem to the set associated with the new
    // Patrol
    distribution.computeIfAbsent(destinationPatrol, k -> new HashSet<>()).add(systemToMove);
    individual.setDistribution(distribution);
    individual.getPopulation().countEvent();

    // Agendar um novo evento de reprodução para o mesmo indivíduo
    double newEventTime = getEventTime() + myMath.mutationRate(individual.getConfort());
    Mutation newMutationEvent = new Mutation(individual, newEventTime);
    this.addEvent(newMutationEvent);
  }

  /**
   * Returns a string representation of the Mutation event.
   * 
   * @return a string representation of the Mutation event
   */
  @Override
  public String toString() {
    return "Mutation Event{time=" + getEventTime() + "}";
  }
}
