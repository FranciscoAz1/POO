package pa;

/**
 * The IEmpire interface provides a contract for empire objects in a simulation.
 * It defines methods for creating an empire with patrols and planetary systems.
 */
public interface IEmpire {

  public void printPatrols();

  public void printSystems();

  public java.util.List<Patrol> getPatrols();

  public java.util.ArrayList<PlanetarySystem> getPlanetarySystems();
}
