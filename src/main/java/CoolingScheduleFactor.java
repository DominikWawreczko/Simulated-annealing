import CoolingSchedules.*;

public class CoolingScheduleFactor {
    public CoolingSchedule getCoolingSchedule(CoolingScheduleType coolingScheduleType) throws InvalidCoolingScheduleType{
        switch (coolingScheduleType){
            case GEOMETRIC:
                return new GeometricCooling();
            case LINEAR:
                return new LinearCooling();
            case LINEARMULTIPLICATIVE:
                return new LinearMultiplicativeCooling();
            case LOGARITHMICAL:
                return new LogarithmicalMultiplicativeCooling();
            case QUADRATIC:
                return new QuadraticMultiplicativeCooling();
            default:
                throw new InvalidCoolingScheduleType("Unknown type:"+coolingScheduleType);
        }

    }
}
