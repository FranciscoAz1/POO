package pa;

import java.util.List;
import java.util.ArrayList;

public interface IEmpire {

	public void Empire(java.util.List<Patrol> aPatrols);

	public void Empire(int[][] aMatrix);

	public void printPatrols();

	public void printSystems();

	public java.util.List<Patrol> getPatrols();

	public java.util.ArrayList<PlanetarySystem> getPlanetarySystems();
}