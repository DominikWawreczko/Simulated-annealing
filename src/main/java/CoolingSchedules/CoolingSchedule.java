package CoolingSchedules;

@FunctionalInterface
public interface CoolingSchedule {
    public double coolDownTemperature(int outerLoopIteration, double initTemperature, double coolingConstant) throws IllegalCoolingConstant;
}
