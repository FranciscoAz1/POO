package pa;

import java.util.Map;

/**
 * The Patrol class represents a patrol in an empire.
 */
public class Patrol {
  private int id;
  private Map<PlanetarySystem, Integer> timeRequired;

  public Patrol(int id, Map<PlanetarySystem, Integer> timeRequired) {
    this.id = id;
    this.timeRequired = timeRequired;
  }

  public int getId() {
    return id;
  }

  public Map<PlanetarySystem, Integer> getTimeRequired() {
    return timeRequired;
  }
}
