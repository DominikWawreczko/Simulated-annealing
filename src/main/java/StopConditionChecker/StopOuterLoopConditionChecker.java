package StopConditionChecker;

import SimulatedAnnealing.CurrentLoopData;

@FunctionalInterface
public interface StopOuterLoopConditionChecker {
    boolean shouldContinue(CurrentLoopData currentLoopData);
}
