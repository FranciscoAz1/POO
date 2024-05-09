package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Empire {
  private List<Patrol> patrols;
  private List<PlanetarySystem> planetarySystems;
  private List<Individual> population;

  public Empire(List<Patrol> patrols, List<PlanetarySystem> planetarySystems) {
    this.patrols = patrols;
    this.planetarySystems = planetarySystems;
    this.population = new ArrayList<>();
  }

  public void generateInitialPopulation(int numIndividuals) {
    for (int i = 0; i < numIndividuals; i++) {
      Individual individual = new Individual(i);
      // Randomly distribute planetary systems among patrols
      Collections.shuffle(planetarySystems);
      int index = 0;
      for (PlanetarySystem system : planetarySystems) {
        Patrol patrol = patrols.get(index % patrols.size());
        individual.assignSystemToPatrol(patrol, system);
        index++;
      }
      population.add(individual);
    }
  }

  public Individual findBestFittedIndividual() {
    // Evaluate comfort (fitness) for each individual and find the best fitted one
    double bestComfort = 0.0;
    Individual bestIndividual = null;

    for (Individual individual : population) {
      double comfort = calculateComfort(individual);
      if (comfort > bestComfort) {
        bestComfort = comfort;
        bestIndividual = individual;
      }
    }

    return bestIndividual;
  }

  private double calculateComfort(Individual individual) {
    // Calculate the comfort φ(z) for an individual
    Map<Patrol, Set<PlanetarySystem>> distribution = individual.getDistribution();
    int totalSystems = planetarySystems.size();

    // Calculate t_min
    double tMin = 0.0;
    for (Patrol patrol : patrols) {
      int minTime = Integer.MAX_VALUE;
      for (PlanetarySystem system : distribution.getOrDefault(patrol, Collections.emptySet())) {
        int time = patrol.getTimeRequired().getOrDefault(system, -1);
        if (time != -1) {
          minTime = Math.min(minTime, time);
        }
      }
      tMin += minTime;
    }
    tMin /= patrols.size();

    // Calculate tz
    int maxTime = 1;
    for (Patrol patrol : patrols) {
      int time = 0;
      for (PlanetarySystem system : distribution.getOrDefault(patrol, Collections.emptySet())) {
        time += patrol.getTimeRequired().getOrDefault(system, 0);
      }
      maxTime = Math.max(maxTime, time);
    }

    // Calculate comfort φ(z)
    double comfort = tMin / maxTime;
    return comfort;
  }
}
