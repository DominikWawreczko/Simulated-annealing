package SimulatedAnnealing;

public interface Solution {
    public Solution generateNeighbourSolution();
    public double fitnessFunction();

}
