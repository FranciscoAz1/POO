package pa;

public interface IEmpire {

  public void Empire(java.util.List<Patrol> aPatrols);

  public void Empire(int[][] aMatrix);

  public void printPatrols();

  public void printSystems();

  public java.util.List<Patrol> getPatrols();

  public java.util.ArrayList<PlanetarySystem> getPlanetarySystems();
}
