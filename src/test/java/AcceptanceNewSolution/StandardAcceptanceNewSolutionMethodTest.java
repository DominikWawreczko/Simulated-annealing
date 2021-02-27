package AcceptanceNewSolution;

import SimulatedAnnealing.CurrentLoopData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardAcceptanceNewSolutionMethodTest {
    StandardAcceptanceNewSolutionMethod standardAcceptanceNewSolutionMethod;
    CurrentLoopData currentLoopData;

    @BeforeEach
    void setUp() {
        standardAcceptanceNewSolutionMethod = new StandardAcceptanceNewSolutionMethod();
    }

    @Test
    void shouldReturnTrueIfDifferenceIsSmallerThanZero() {
        //given
        double difference = 10;
        double temperature =1;
        currentLoopData = new CurrentLoopData(temperature);
        //when
        boolean result = standardAcceptanceNewSolutionMethod.shouldAcceptNewSolution(difference,currentLoopData);

        //then
        Assertions.assertThat(result).isFalse();

    }
/*
Probabilities when methods below are working fine and we still have "red tests" are:
6.5331862350007E-23 and
1.606938044259E-40
so we shouldn't care about it
 */
    @Test
    void shouldSometimesReturnTrueIfDifferenceIsHigherThanZero() {
        //given
        double difference = -10;
        boolean isTrue = false;
        double temperature =21;
        currentLoopData = new CurrentLoopData(temperature);

        //when
        for(int iteration = 0; iteration<100; iteration++){
            isTrue = standardAcceptanceNewSolutionMethod.shouldAcceptNewSolution(difference,currentLoopData);
            if (isTrue)
                break;;
        }

        //then
        Assertions.assertThat(isTrue).isTrue();

    }

    @Test
    void shouldSometimesReturnFalseIfDifferenceIsHigherThanZero() {
        //given
        double difference = -10;
        boolean isFalse = false;
        double temperature =21;
        currentLoopData = new CurrentLoopData(temperature);

        //when
        for(int iteration = 0; iteration<100; iteration++){
            isFalse = standardAcceptanceNewSolutionMethod.shouldAcceptNewSolution(difference,currentLoopData);
            if (!isFalse)
                break;;
        }

        //then
        Assertions.assertThat(isFalse).isTrue();

    }
}