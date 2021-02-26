package SimulatedAnnealing;

import AcceptanceNewSolution.StandardAcceptanceNewSolutionMethod;
import CoolingSchedules.CoolingScheduleType;
import Solutions.ExampleSolution;
import Solutions.Solution;
import StopConditionChecker.StopWhenTemperatureIsLow;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

class SimulatedAnnealingTest {
    @Test
    void shouldCalculateSolutionCloseToOptimum() {
        //given

        SimulatedAnnealing simulatedAnnealing = SimulatedAnnealing.builder().
                coolingSchedule(CoolingScheduleType.LINEAR).
                initTemperature(120.0).
                coolingConstant(0.85).
                stopOuterLoopConditionChecker(new StopWhenTemperatureIsLow(1)).
                innerLoopLength(20).
                AcceptanceNewSolutionMethod(new StandardAcceptanceNewSolutionMethod()).
                build();

        //when
        boolean IsResultCloseToOptimum;
        Solution result = simulatedAnnealing.simulateAnneal(new ExampleSolution());
        IsResultCloseToOptimum = result.fitnessFunction() > 89;

        //then
        Assertions.assertThat(IsResultCloseToOptimum).isTrue();
    }
}