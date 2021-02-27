package AcceptanceNewSolution;

import SimulatedAnnealing.CurrentLoopData;

public class StandardAcceptanceNewSolutionMethod implements AcceptanceNewSolutionMethod {
    @Override
    public boolean shouldAcceptNewSolution(Double difference, CurrentLoopData currentLoopData) {
        if (difference<0){
            return true;
        }else {
            double temperature = currentLoopData.getTemperature();
            return standardProbabilityMethod(difference, temperature);

        }
    }
    private boolean standardProbabilityMethod(double difference, double temperature){
        var randomNumber = Math.random();
        return randomNumber < getExp(difference, temperature);
    }

    private double getExp(Double difference, double temperature) {
        return Math.exp(-1 * difference / temperature);
    }

}
