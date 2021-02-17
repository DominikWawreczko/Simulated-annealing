package StopConditionChecker;

@FunctionalInterface
public interface StopOuterLoopConditionChecker {
    public boolean shouldContinue();
}
