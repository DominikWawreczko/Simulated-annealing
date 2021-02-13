package CoolingSchedules;

import java.lang.Math;

public class GeometricCooling implements CoolingSchedule{
    @Override
    public double coolDownTemperature(int outerLoopIteration, double initTemperature, double coolingConstant) throws IllegalCoolingConstant {

        if (checkIfCoolingConstIsIllegal(coolingConstant)) {
            throw new IllegalCoolingConstant("Alpha should be between 0.8 and 0.95");
        }else {
            return coolTemperature(outerLoopIteration, initTemperature, coolingConstant);
        }

    }
    private double coolTemperature(int outerLoopIteration, double initTemperature, double coolingConstant){

        return initTemperature*Math.pow(coolingConstant,outerLoopIteration);
    }

    private Boolean checkIfCoolingConstIsIllegal(double alpha){

        return alpha<0.8 && alpha > 0.95;
    }
}
