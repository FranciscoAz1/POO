package pa;

/**
 * The PlanetarySystem class represents a planetary system in an empire.
 */
public class PlanetarySystem {

  private int id;


  /**
   * Constructs a PlanetarySystem object with the specified ID.
   * 
   * @param id The ID of the planetary system.
   */
  public PlanetarySystem(int id) {
    this.id = id;
  }

  /**
   * Gets the ID of the planetary system.
   * 
   * @return The ID of the planetary system.
   */
  public int getId() {
    return id;
  }

  /**
   * Returns a string representation of the planetary system.
   * 
   * @return A string representation of the planetary system.
   */
  @Override
  public String toString() {
    return "p" + id;
  }
}
