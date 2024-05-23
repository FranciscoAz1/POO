package pa;

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
