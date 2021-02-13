package CoolingSchedules;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LogarithmicalMultiplicativeCoolingTest {

    CoolingSchedule coolingSchedule;
    double result;

    @BeforeEach
    void setUp() {

        coolingSchedule = new LogarithmicalMultiplicativeCooling();
    }

    @Test
    void shouldCalculateLogarithmicalMultiplicativeCooling() {
        //given
        int outerLoopIteration = 9;
        double initTemperature = 10;
        double coolingConstant = 4;

        //when
        result = coolingSchedule.coolDownTemperature(outerLoopIteration, initTemperature, coolingConstant);

        //then
        Assertions.assertThat(result).isEqualTo(2);

    }

    @Test
    void shouldReturnExceptionIfCoolingConstantIsSmallerThanOne() {
        //given
        int outerLoopIteration = 1;
        double initTemperature = 10;
        double coolingConstant = 0.9;

        //then
        assertThatExceptionOfType(IllegalCoolingConstant.class).isThrownBy(() -> coolingSchedule.coolDownTemperature(outerLoopIteration, initTemperature, coolingConstant)).withMessage("Alpha should be higher than 1");
    }

    @Test
    void shouldReturnExceptionIfCoolingConstantIsEqualOne() {
        //given
        int outerLoopIteration = 1;
        double initTemperature = 10;
        double coolingConstant = 1;

        //then
        assertThatExceptionOfType(IllegalCoolingConstant.class).isThrownBy(() -> coolingSchedule.coolDownTemperature(outerLoopIteration, initTemperature, coolingConstant)).withMessage("Alpha should be higher than 1");
    }


}