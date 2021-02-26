package CoolingSchedules;

@FunctionalInterface
public interface CoolingSchedule {
    double coolDownTemperature(int outerLoopIteration, double initTemperature, double coolingConstant) throws IllegalCoolingConstant;
}
