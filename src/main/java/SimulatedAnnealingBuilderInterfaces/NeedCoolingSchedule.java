package SimulatedAnnealingBuilderInterfaces;

import CoolingSchedules.CoolingScheduleType;

public interface NeedCoolingSchedule {
    NeedInitTemperature coolingSchedule(CoolingScheduleType scheduleType);
}
