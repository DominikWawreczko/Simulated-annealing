package CoolingSchedules;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class QuadraticMultiplicativeCoolingTest {

    CoolingSchedule coolingSchedule;
    double result;

    @BeforeEach
    void setUp() {

        coolingSchedule = new QuadraticMultiplicativeCooling();
    }

    @Test
    void shouldCalculateQuadraticMultiplicativeCooling() {
        //given
        int outerLoopIteration = 1;
        double initTemperature = 10;
        double coolingConstant = 4;

        //when
        result = coolingSchedule.coolDownTemperature(outerLoopIteration, initTemperature, coolingConstant);

        //then
        Assertions.assertThat(result).isEqualTo(2);

    }

    @Test
    void shouldReturnExceptionIfCoolingConstantIsSmallerThanZero() {
        //given
        int outerLoopIteration = 1;
        double initTemperature = 10;
        double coolingConstant = -1.9;

        //then
        assertThatExceptionOfType(IllegalCoolingConstant.class).isThrownBy(() -> coolingSchedule.coolDownTemperature(outerLoopIteration, initTemperature, coolingConstant)).withMessage("Alpha should be higher than 0");
    }

    @Test
    void shouldReturnExceptionIfCoolingConstantIsEqualZero() {
        //given
        int outerLoopIteration = 1;
        double initTemperature = 10;
        double coolingConstant = 0;

        //then
        assertThatExceptionOfType(IllegalCoolingConstant.class).isThrownBy(() -> coolingSchedule.coolDownTemperature(outerLoopIteration, initTemperature, coolingConstant)).withMessage("Alpha should be higher than 0");
    }


}