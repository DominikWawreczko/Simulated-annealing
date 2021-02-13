package CoolingSchedules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


class GeometricCoolingTest {

    CoolingSchedule coolingSchedule;
    double result;

    @BeforeEach
    void setUp() {

        coolingSchedule = new GeometricCooling();
    }

    @Test
    void shouldCalculateGeometricCooling() {
        //given
        int outerLoopIteration = 1;
        double initTemperature = 10;
        double coolingConstant = 0.9;

        //when
        result = coolingSchedule.coolDownTemperature(outerLoopIteration, initTemperature, coolingConstant);

        //then
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(9);

    }

    @Test
    void shouldReturnExceptionIfCoolingConstantIsHigherThanNinetyFiveHundredths() {
        //given
        int outerLoopIteration = 1;
        double initTemperature = 10;
        double coolingConstant = 1.9;

        //then
        assertThatExceptionOfType(IllegalCoolingConstant.class).isThrownBy(() -> coolingSchedule.coolDownTemperature(outerLoopIteration, initTemperature, coolingConstant)).withMessage("Alpha should be between 0.8 and 0.95");
    }

    @Test
    void shouldReturnExceptionIfCoolingConstantIsHigherThanEightTenths() {
        //given
        int outerLoopIteration = 1;
        double initTemperature = 10;
        double coolingConstant = 0.09;

        //then
        assertThatExceptionOfType(IllegalCoolingConstant.class).isThrownBy(() -> coolingSchedule.coolDownTemperature(outerLoopIteration, initTemperature, coolingConstant)).withMessage("Alpha should be between 0.8 and 0.95");
    }


}