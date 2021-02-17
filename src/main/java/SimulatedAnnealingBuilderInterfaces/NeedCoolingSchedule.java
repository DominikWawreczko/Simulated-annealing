package SimulatedAnnealingBuilderInterfaces;

import CoolingSchedules.CoolingScheduleType;

public interface NeedCoolingSchedule {
    public NeedInitTemperature coolingSchedule(CoolingScheduleType scheduleType);
}
