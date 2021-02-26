package Solutions;

import java.util.Random;

public class ExampleSolution implements Solution{
    double currentNumber;
    public ExampleSolution() {
        this.currentNumber = new Random().nextDouble()*100;
    }

    @Override
    public Solution generateNeighbourSolution() {
        return new ExampleSolution();
    }

    @Override
    public double fitnessFunction() {
        return currentNumber;
    }
}
