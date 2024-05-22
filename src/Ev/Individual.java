package ev;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dss.PlanetarySystem;
import pa.Patrol;

public class Individual {

  private boolean IndivualDeath;
  private int IndividualsID;

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

  // Method to print troop distribution over time
  public void printTroopDistribution() {
    throw new UnsupportedOperationException();
  }
}
