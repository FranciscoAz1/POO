package main;

// import src.Empire;
// import src.Patrol;
// import src.Individual;
// import src.PlanetarySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.*;

public class Main {
  public static void main(String[] args) {
    // Example: Matrix representing time required for each patrol to pacify each
    // planetary system
    int[][] matrix = {
        { 1, 2, 1, 1, 2, 1 },
        { 2, 2, 2, 2, 2, 2 },
        { 3, 3, 3, 3, 3, 3 }
    };

    List<Patrol> patrols = new ArrayList<>();
    List<PlanetarySystem> planetarySystems = new ArrayList<>();

    // Create patrols and planetary systems based on the matrix
    for (int i = 0; i < matrix.length; i++) {
      Map<PlanetarySystem, Integer> timeRequired = new HashMap<>();
      for (int j = 0; j < matrix[i].length; j++) {
        PlanetarySystem system = new PlanetarySystem(j);
        planetarySystems.add(system);
        timeRequired.put(system, matrix[i][j]);
      }
      Patrol patrol = new Patrol(i, timeRequired);
      patrols.add(patrol);
    }

    // Create the empire
    Empire empire = new Empire(patrols, planetarySystems);

    // Generate initial population
    int numIndividuals = 10; // Specify the number of initial individuals
    empire.generateInitialPopulation(numIndividuals);

    // Find the best-fitted individual
    Individual bestIndividual = empire.findBestFittedIndividual();

    System.out.println("Best-fitted individual: " + bestIndividual.getId());
    System.out.println("end Program");
  }
}
