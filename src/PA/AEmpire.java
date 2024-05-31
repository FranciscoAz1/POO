package pa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The AEmpire class provides a contract for empire objects in a simulation. It
 * defines methods for
 * managing patrols and planetary systems.
 */
public abstract class AEmpire {
  protected List<Patrol> patrols = new ArrayList<>();
  protected ArrayList<PlanetarySystem> planetarySystems = new ArrayList<>();

  /**
   * Constructs an AEmpire object with the given patrols and planetary systems.
   * 
   * @param patrols          the list of patrols
   * @param planetarySystems the list of planetary systems
   */
  public AEmpire(List<Patrol> patrols, ArrayList<PlanetarySystem> planetarySystems2) {
    this.patrols = patrols;
    this.planetarySystems = planetarySystems2;
  }

  /**
   * Constructs an AEmpire object with the given matrix.
   * 
   * @param matrix the matrix of planetary systems
   */
  public AEmpire(int[][] matrix) {
    // Create planetary systems first
    for (int j = 0; j < matrix[0].length; j++) {
      planetarySystems.add(new PlanetarySystem(j));
    }
    // Create patrols and planetary systems based on the matrix
    for (int i = 0; i < matrix.length; i++) {
      Map<PlanetarySystem, Integer> timeRequired = new HashMap<>();
      // System.out.print("Initializing Patrol " + i);

      for (int j = 0; j < matrix[i].length; j++) {

        PlanetarySystem system = planetarySystems.get(j);
        timeRequired.put(system, matrix[i][j]);
        // System.out.print(" " + timeRequired.get(system));
      }
      // System.out.println(" days");
      // Debug
      Patrol patrol = new Patrol(i, timeRequired);
      patrols.add(patrol);
    }
  }

  /**
   * Prints the patrols.
   * 
   * @param patrols the list of patrols
   */
  public void printPatrols() {
    for (int i = 0; i < patrols.size(); i++) {
      System.out.println("Patrol " + i + ": " + patrols.get(i).getTimeRequired());
    }
  }

  /**
   * Prints the planetary systems.
   * 
   * @param planetarySystems the list of planetary systems
   */
  public void printSystems() {
    for (int i = 0; i < planetarySystems.size(); i++) {
      System.out.println("System " + i + ": " + planetarySystems.get(i).getId());
    }
  }

  /**
   * Gets the list of patrols.
   * 
   * @return the list of patrols
   */
  public List<Patrol> getPatrols() {
    return patrols;
  }

  /**
   * Gets the list of planetary systems.
   * 
   * @return the list of planetary systems
   */
  public ArrayList<PlanetarySystem> getPlanetarySystems() {
    return planetarySystems;
  }
}
