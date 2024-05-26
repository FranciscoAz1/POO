package ep;

import java.util.Collections;
import java.util.List;

import dss.AEvent;

import java.util.ArrayList;

import pa.AEmpire;

public class Population extends AEmpire implements IPopulation {

  private int numIndividuals = 0;
  private int MaxPopulationSize;
  private List<Individual> population = new ArrayList<>();

  public Population(int[][] matrix, int MaxPopulationSize) {
    super(matrix);
    this.MaxPopulationSize = MaxPopulationSize;
  }

  public Population(int[][] matrix, int MaxPopulationSize, int numIndividuals) {
    super(matrix);
    this.MaxPopulationSize = MaxPopulationSize;
    this.numIndividuals = numIndividuals;
    createInitialPopulation(numIndividuals);
  }

  public void createInitialPopulation(int numIndividuals) {
    this.numIndividuals += numIndividuals;
    for (int i = 0; i < numIndividuals; i++) {
      population.add(new Individual(this, patrols, planetarySystems));
    }
  }

  // Método para retornar a lista de indivíduos
  public List<Individual> getPopulation() {
    return population;
  }

  public void setPopulation(List<Individual> population) {
    this.population = population;
  }

  public void addIndividual(Individual individual) {
    this.numIndividuals += 1;
    population.add(individual);
  }

  @Override
  public void evaluateFitness() {
    // TODO - implement Population.evaluateFitness
    throw new UnsupportedOperationException();
  }

  @Override
  public void checkTerminationCondition() {
    // TODO - implement Population.checkTerminationCondition
    throw new UnsupportedOperationException();
  }

  @Override
  public void Epidemics() {
    // TODO - implement Population.Epidemics
    throw new UnsupportedOperationException();
  }

  @Override
  public void printPopulation() {
    for (int i = 0; i < population.size(); i++) {

      // Linha que indica o indivíduo com uma linha em branco antes
      System.out.println();
      System.out.println("Individual " + i + ":");

      Individual individual = population.get(i);
      System.out.println("Troop Distribution for Individual " + i + ":");
      System.out.printf("Confort: %.2f\n", individual.getConfort());
      individual.printTroopDistribution();

      // Imprimir os eventos do indivíduo
      List<AEvent> events = individual.getEvents();
      for (AEvent event : events) {
        System.out.println(event);
      }
    }
  }
}
