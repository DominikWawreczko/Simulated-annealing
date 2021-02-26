package SimulatedAnnealing;

import CoolingSchedules.CoolingScheduleType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulatedAnnealingTest {
    @Test
    @DisplayName("NameGoesHere")
    void name() {
        //given
        SimulatedAnnealing simulatedAnnealing = SimulatedAnnealing.builder().
                coolingSchedule(CoolingScheduleType.LINEAR).
                initTemperature(120.0).
                coolingConstant(0.85).
                stopOuterLoopConditionChecker().
                innerLoopLength(20).
                AcceptanceNewSolutionMethod().
                build();

        //when

        //then

    }
}