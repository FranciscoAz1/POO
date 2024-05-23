package ev;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pa.PlanetarySystem;
import pa.Patrol;
import pa.Empire;

public class Individual {

  private boolean IndivualDeath;
  private int IndividualsID;

  private int id;
  private Map<Patrol, Set<PlanetarySystem>> distribution;

  // p1 - 1 , 3, 4
  // p2 - 2 , 5
  // p3 - 7
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

      System.out.print("Patrol " + patrol.getId() + ":");
      for (PlanetarySystem system : systems) {
        int days = patrol.getTimeRequired().getOrDefault(system, -1);
        if (days == -1) {
          System.out.print("p" + system.getId() + "none");
        }
        System.out
            .println(" p" + system.getId() + " " + days + " d");
      }
    }
  }
}
