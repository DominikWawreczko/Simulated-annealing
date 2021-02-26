package StopConditionChecker;

import SimulatedAnnealing.CurrentLoopData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopWhenTemperatureIsLowTest {
    StopWhenTemperatureIsLow stopWhenTemperatureIsLow;
    @BeforeEach
    void setUp() {
       stopWhenTemperatureIsLow = new StopWhenTemperatureIsLow(1);
    }

    @Test
    void shouldReturnFalseIfTemperatureIsLowerThanOrEqualToLimit() {
        //given
        double currentTemperature = 0.001;
        CurrentLoopData currentLoopData = new CurrentLoopData(currentTemperature);

        //when
        var result = stopWhenTemperatureIsLow.shouldContinue(currentLoopData);

        //then
        Assertions.assertThat(result).isFalse();

    }

    @Test
    void shouldReturnFalseIfTemperatureIsHigherThanLimit() {
        //given
        double currentTemperature = 12;
        CurrentLoopData currentLoopData = new CurrentLoopData(currentTemperature);

        //when
        var result = stopWhenTemperatureIsLow.shouldContinue(currentLoopData);

        //then
        Assertions.assertThat(result).isTrue();

    }

}