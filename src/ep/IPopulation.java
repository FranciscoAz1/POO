package ep;

public interface IPopulation {

	public void Population(int[][] aMatrix, int aMaxPopulationSize);

	public void Population(int[][] aMatrix, int aMaxPopulationSize, int aNumIndividuals);

	public void createInitialPopulation(int aNumIndividuals);

	public void performReproduction();

	public void performMutation();

	public void performDeath();

	public void evaluateFitness();

	public void checkTerminationCondition();

	public void Epidemics();

	public void printPopulation();
}