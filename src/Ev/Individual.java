package ev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pa.PlanetarySystem;
import rand.Utils;
import pa.Patrol;
import pa.Empire;

public class Individual {

  private boolean IndivualDeath;
  private int id;

  private Map<Patrol, Set<PlanetarySystem>> distribution;

  // p1 - 1 , 3, 4
  // p2 - 2 , 5
  // p3 - 7
  public Individual(int id, List<Patrol> patrols, ArrayList<PlanetarySystem> planetarySystems) {
    this.id = id;
    this.distribution = new HashMap<>();
    createDistribution(patrols, planetarySystems);

  }

  private void createDistribution(List<Patrol> patrols, ArrayList<PlanetarySystem> planetarySystems) {
    // Randomly distribute planetary systems among patrols
    // Collections.shuffle(planetarySystems);
    for (var system : planetarySystems) {
      var patrol = Utils.getRandomElement(patrols);
      assignSystemToPatrol(patrol, system);
    }
  }

  public void assignSystemToPatrol(Patrol patrol, PlanetarySystem system) {
    distribution.computeIfAbsent(patrol, k -> new HashSet<>()).add(system);
  }

  public Map<Patrol, Set<PlanetarySystem>> getDistribution() {
    return distribution;
  }

  // Method to print troop distribution over time
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
}
