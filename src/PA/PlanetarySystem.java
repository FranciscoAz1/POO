package pa;

/**
 * The PlanetarySystem class represents a planetary system in an empire.
 */
public class PlanetarySystem {

  private int id;

  public PlanetarySystem(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "p" + id;
  }
}
