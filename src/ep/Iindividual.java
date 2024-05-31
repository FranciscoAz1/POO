package ep;

import java.util.List;
import java.util.Map;
import java.util.Set;

import dss.IEvent;
import pa.Patrol;
import pa.PlanetarySystem;

/**
 * The Iindividual interface provides a contract for individual objects in a
 * simulation. It defines methods for creating distributions, assigning systems
 * to patrols, calculating comfort, and printing troop distributions.
 */
public interface Iindividual {

	public void createDistribution(java.util.List<Patrol> aPatrols);

	public void assignSystemToPatrol(Patrol aPatrol, PlanetarySystem aSystem);
	
	public Population getPopulation();

	public double getNewConfort();

	public double getConfort();
	
	public double getPolicingTime();
	
	public Map<Patrol, Set<PlanetarySystem>> getDistribution();

	public List<IEvent> createEvents();

	public List<IEvent> createEvents(double time);

	public List<IEvent> getEvents();

	public void calculateConfort();

	public List<IEvent> getNewEvents(double time);

	public void printTroopDistribution();

	public void setDistribution(Map<Patrol, Set<PlanetarySystem>> distribution);

	public void setConfort(double confort);

	public static boolean equalsByDistribution(Individual individualA, Individual individualB);

	public String toString();
}