package ep;

import java.util.List;
import pa.Patrol;
import pa.PlanetarySystem;

public interface Iindividual {

	public void Individual(int aId, java.util.List<Patrol> aPatrols);

	public void createDistribution(java.util.List<Patrol> aPatrols);

	public void assignSystemToPatrol(Patrol aPatrol, PlanetarySystem aSystem);

	public void calculateConfort();

	public void printTroopDistribution();
}