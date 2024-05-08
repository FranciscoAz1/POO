package src;

import java.util.*;

// Represents an individual in the population
public class Individual {
  private int id;
  private Map<Patrol, Set<PlanetarySystem>> distribution;

  public Individual(int id) {
    this.id = id;
    this.distribution = new HashMap<>();
  }

  public void assignSystemToPatrol(Patrol patrol, PlanetarySystem system) {
    distribution.computeIfAbsent(patrol, k -> new HashSet<>()).add(system);
  }

  public Map<Patrol, Set<PlanetarySystem>> getDistribution() {
    return distribution;
  }

  public int getId() {
    return id;
  }
}
