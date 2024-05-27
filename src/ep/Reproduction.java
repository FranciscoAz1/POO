package ep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import dss.AEvent;
import pa.Patrol;
import pa.PlanetarySystem;
import rand.myMath;

public class Reproduction extends AEvent implements Ireproduction {
  private static final Random random = new Random();
  private Individual individual;
  private Map<Patrol, Set<PlanetarySystem>> distribution;

  public Individual getIndividual() {
    return individual;
  }

  public Reproduction(Individual individual) {
    super(myMath.reproductionRate(individual.getConfort()));
    this.individual = individual;
  }

  @Override
  public boolean HandleEvent() {
    // check death of individual
    if (individual == null) {
      return false;
    }
    if (individual.getPopulation().getPopulation().contains(individual)) {
      return false;
    }
    distribution = individual.getDistribution();
    // Check if the distribution is not empty and has more than one patrol
    if (distribution == null || distribution.isEmpty()) {
      throw new IllegalStateException("There must be at least one patrol with planetary systems in the distribution.");
    }

    Individual newIndividual = new Individual(individual);
    Map<Patrol, Set<PlanetarySystem>> newDistribution = newIndividual.getDistribution();
    // Step 1 calculate ⌊(1 − ϕ(z))m⌋ systems to remove
    int nSystems = 0;
    List<PlanetarySystem> systemsToRemove = new ArrayList<>();
    for (Set<PlanetarySystem> planetarySystems : distribution.values()) {
      nSystems += planetarySystems.size();
    }
    int nSystemsToRemove = (int) (1 - individual.getConfort()) * nSystems;
    //
    // Step 3: Randomly remove planetary systems from the new distribution
    List<PlanetarySystem> removedSystems = new ArrayList<>();
    for (int i = 0; i < nSystemsToRemove; i++) {
      Patrol randomPatrol = getRandomPatrolWithSystems(distribution);
      if (randomPatrol == null)
        break; // No more systems to remove

      Set<PlanetarySystem> systems = newDistribution.get(randomPatrol);
      PlanetarySystem system = getRandomElementFromSet(systems);
      systems.remove(system);
      removedSystems.add(system);

      // Remove patrol if it has no more systems
      if (systems.isEmpty()) {
        newDistribution.remove(randomPatrol);
      }
    }

    // Step 4: Randomly redistribute the removed systems among the patrols
    for (PlanetarySystem system : removedSystems) {
      Patrol randomPatrol = getRandomPatrol(newDistribution);
      newDistribution.computeIfAbsent(randomPatrol, k -> new HashSet<>()).add(system);
    }

    // Step 5: add new individual to population
    newIndividual.setDistribution(newDistribution);
    Population pop = individual.getPopulation();
    pop.addIndividual(newIndividual);
    return true;
  }

  private Patrol getRandomPatrolWithSystems(Map<Patrol, Set<PlanetarySystem>> distribution) {
    List<Patrol> patrolsWithSystems = new ArrayList<>();
    for (Map.Entry<Patrol, Set<PlanetarySystem>> entry : distribution.entrySet()) {
      if (!entry.getValue().isEmpty()) {
        patrolsWithSystems.add(entry.getKey());
      }
    }
    return patrolsWithSystems.isEmpty() ? null : patrolsWithSystems.get(random.nextInt(patrolsWithSystems.size()));
  }

  private Patrol getRandomPatrol(Map<Patrol, Set<PlanetarySystem>> distribution) {
    List<Patrol> patrolList = new ArrayList<>(distribution.keySet());
    return patrolList.get(random.nextInt(patrolList.size()));
  }

  private <T> T getRandomElementFromSet(Set<T> set) {
    int index = random.nextInt(set.size());
    Iterator<T> iter = set.iterator();
    for (int i = 0; i < index; i++) {
      iter.next();
    }
    return iter.next();
  }

  @Override
  public String toString() {
    return "Reproduction Event{time= " + getEventTime() + "}";
  }
}
