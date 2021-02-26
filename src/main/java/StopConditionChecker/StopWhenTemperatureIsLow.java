package StopConditionChecker;

import SimulatedAnnealing.CurrentLoopData;

public class StopWhenTemperatureIsLow implements StopOuterLoopConditionChecker{
    private final double stopTemperature;

    public StopWhenTemperatureIsLow(double stopTemperature) {
        this.stopTemperature = stopTemperature;
    }

    @Override
    public boolean shouldContinue(CurrentLoopData currentLoopData) {
        return currentLoopData.getTemperature()>stopTemperature;
    }
}
