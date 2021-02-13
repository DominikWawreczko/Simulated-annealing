package CoolingSchedules;

public class LinearMultiplicativeCooling implements CoolingSchedule{
    @Override
    public double coolDownTemperature(int outerLoopIteration, double initTemperature, double coolingConstant) throws IllegalCoolingConstant {

        if (checkIfCoolingConstIsIllegal(coolingConstant)) {
            throw new IllegalCoolingConstant("Alpha should be higher than 0");
        }else {
            return coolTemperature(outerLoopIteration, initTemperature, coolingConstant);
        }

    }
    private double coolTemperature(int outerLoopIteration, double initTemperature, double coolingConstant){

        return initTemperature / (1+coolingConstant * outerLoopIteration);
    }

    private Boolean checkIfCoolingConstIsIllegal(double alpha){

        return alpha <= 0;
    }
}
