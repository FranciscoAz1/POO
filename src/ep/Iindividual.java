package ep;

import java.util.List;
import pa.Patrol;
import pa.PlanetarySystem;

/**
 * The Iindividual interface provides a contract for individual objects in a
 * simulation. It defines methods for creating distributions, assigning systems
 * to patrols, calculating comfort, and printing troop distributions.
 */
public interface Iindividual {

	public void Individual(int aId, java.util.List<Patrol> aPatrols);

	public void createDistribution(java.util.List<Patrol> aPatrols);

	public void assignSystemToPatrol(Patrol aPatrol, PlanetarySystem aSystem);

	public void calculateConfort();

	public void printTroopDistribution();
}