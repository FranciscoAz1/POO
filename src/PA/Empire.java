package pa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empire {
  protected List<Patrol> patrols = new ArrayList<>();
  protected ArrayList<PlanetarySystem> planetarySystems = new ArrayList<>();

  public Empire(List<Patrol> patrols, ArrayList<PlanetarySystem> planetarySystems2) {
    this.patrols = patrols;
    this.planetarySystems = planetarySystems2;
  }

  public Empire(int[][] matrix) {
    // Create patrols and planetary systems based on the matrix
    for (int i = 0; i < matrix.length; i++) {
      Map<PlanetarySystem, Integer> timeRequired = new HashMap<>();
      System.out.print("Initializing Patrol " + i);

      for (int j = 0; j < matrix[i].length; j++) {

        PlanetarySystem system = new PlanetarySystem(j);
        if (i == 0) {
          planetarySystems.add(system);
        }
        timeRequired.put(system, matrix[i][j]);
        System.out.print(" " + timeRequired.get(system));
      }
      System.out.println(" days");
      // Debug
      Patrol patrol = new Patrol(i, timeRequired);
      patrols.add(patrol);
    }
  }

  public void printPatrols() {
    for (int i = 0; i < patrols.size(); i++) {
      System.out.println("Patrol " + i + ": " + patrols.get(i).getTimeRequired());
    }
  }

  public void printSystems() {
    for (int i = 0; i < planetarySystems.size(); i++) {
      System.out.println("System " + i + ": " + planetarySystems.get(i).getId());
    }
  }
}
