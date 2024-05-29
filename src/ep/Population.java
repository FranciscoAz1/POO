package ep;

import java.util.List;

import dss.IEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    EpidemicMayOccur();
  }

  public void addIndividual(Individual individual) {
    if (population.add(individual)) {
      this.numIndividuals += 1;
    }
    EpidemicMayOccur();
  }

  public void removeIndividual(Individual individual) {
    if (this.population.remove(individual)) {
      this.numIndividuals -= 1;
    }
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
      List<IEvent> events = individual.getEvents();
      for (IEvent event : events) {
        System.out.println(event);
      }
    }

    /*
     * System.out.println("\nLista ordenada de todos os indivíduos:");
     * Best_Fitted_Individual.sortPopulation(population);
     * for (Individual individual : population) {
     * System.out.printf("Conforto: %.2f - %s\n", individual.getConfort(),
     * individual);
     * }
     * 
     * System.out.println("\nOs 5 melhores indivíduos:");
     * List<Individual> best5 = Best_Fitted_Individual.getBest5(population);
     * for (Individual individual : best5) {
     * System.out.printf("Conforto: %.2f - %s\n", individual.getConfort(),
     * individual);
     * }
     * // Imprimir o melhor indivíduo rastreado
     * Individual bestIndividual = Best_Fitted_Individual.getBestIndividual();
     * if (bestIndividual != null) {
     * System.out.println("\nMelhor indivíduo rastreado:");
     * System.out.printf("Conforto: %.2f - %s\n", bestIndividual.getConfort(),
     * bestIndividual);
     * } else {
     * System.out.println("\nNenhum indivíduo rastreado como o melhor.");
     * }
     */
  }

  public List<IEvent> getEvents() {
    List<IEvent> AllEvents = new ArrayList<>();
    for (Individual individual : population) {
      AllEvents.addAll(individual.getEvents());
    }
    return AllEvents;
  }

  @Override
  public void EpidemicMayOccur() {
    if (this.numIndividuals >= this.MaxPopulationSize) {
      doEpidemic();
    }
  }

  private void sortPopulation() {
    Collections.sort(population, Comparator.comparingDouble(Individual::getConfort).reversed());
  }

  <<<<<<<HEAD

  public Epidemic getEpidemic() {
    return epidemic;
  }=======

  private void doEpidemic() {
    // Seperate the population to the five best one
    sortPopulation();
    // for (population p : population) {
    //
    // }

  }
}>>>>>>>9938f 6d a6165397af5adb53bac5c496ef4c329c1
