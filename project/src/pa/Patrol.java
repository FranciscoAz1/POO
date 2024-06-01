package pa;

import java.util.Map;

/**
 * The Patrol class represents a patrol in an empire.
 */
public class Patrol {
  private int id;
  private Map<PlanetarySystem, Integer> timeRequired;

  /**
   * Constructs a Patrol object with the specified id and time required for each planetary system.
   *
   * @param id           The id of the patrol.
   * @param timeRequired The time required for each planetary system.
   */
  public Patrol(int id, Map<PlanetarySystem, Integer> timeRequired) {
    this.id = id;
    this.timeRequired = timeRequired;
  }

  /**
   * Gets the ID of the patrol.
   * 
   * @return The ID of the patrol.
   */
  public int getId() {
    return id;
  }

  /**
   * Gets the time required for each planetary system.
   * 
   * @return The map of planetary systems and the time required for each.
   */
  public Map<PlanetarySystem, Integer> getTimeRequired() {
    return timeRequired;
  }
}
