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

  // Method to print troop distribution over time
  public void printTroopDistribution() {
    System.out.println("Troop Distribution for Individual " + id + ":");
    for (Map.Entry<Patrol, Set<PlanetarySystem>> entry : distribution.entrySet()) {
      Patrol patrol = entry.getKey();
      Set<PlanetarySystem> systems = entry.getValue();

      System.out.println("Patrol " + patrol.getId() + ":");
      for (PlanetarySystem system : systems) {
        int days = patrol.getTimeRequired().getOrDefault(system, -1);
        if (days != -1) {
          System.out
              .println("  - Planetary System " + system.getId() + " " + days + " days");
        }
      }
    }
  }
}
