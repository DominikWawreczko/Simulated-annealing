package SimulatedAnnealing;

import AcceptanceNewSolution.StandardAcceptanceNewSolutionMethod;
import CoolingSchedules.CoolingScheduleType;
import Solutions.ExampleSolution;
import Solutions.Solution;
import StopConditionChecker.StopWhenTemperatureIsLow;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleSimulatedAnnealingTest {
    @Test
    void shouldCalculateSolutionCloseToOptimum() {
        //given

        var simpleSimulatedAnnealing = SimpleSimulatedAnnealing.builder().
                coolingSchedule(CoolingScheduleType.GEOMETRIC).
                initTemperature(30.0).
                coolingConstant(0.85).
                stopOuterLoopConditionChecker(new StopWhenTemperatureIsLow(0.09)).
                innerLoopLength(20).
                AcceptanceNewSolutionMethod(new StandardAcceptanceNewSolutionMethod()).
                build();

        //when
        boolean IsResultCloseToOptimum;
        Solution result = simpleSimulatedAnnealing.simulateAnneal(new ExampleSolution());
        IsResultCloseToOptimum = result.fitnessFunction() < 1;

        //then
        Assertions.assertThat(IsResultCloseToOptimum).isTrue();
    }
}