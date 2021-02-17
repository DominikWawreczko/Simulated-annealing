package SimulatedAnnealing;

import CoolingSchedules.CoolingSchedule;
import CoolingSchedules.CoolingScheduleFactor;
import CoolingSchedules.CoolingScheduleType;
import CoolingSchedules.InvalidCoolingScheduleType;
import SimulatedAnnealingBuilderInterfaces.*;
import StopConditionChecker.StopOuterLoopConditionChecker;

public class SimulatedAnnealing {
    private int innerLoopLength;
    private double initTemperature;
    private double coolingConstant;
    private CoolingSchedule coolingSchedule;
    private StopOuterLoopConditionChecker stopOuterLoopConditionChecker;

    private SimulatedAnnealing(){

    }

    public static class Builder implements CanBeBuild, NeedCoolingSchedule, NeedInnerLoopLength, NeedCoolingConstant, NeedInitTemperature, NeedStopOuterLoopConditionChecker {
        private int innerLoopLength;
        private double initTemperature;
        private double coolingConstant;
        private CoolingSchedule coolingSchedule;
        private StopOuterLoopConditionChecker stopOuterLoopConditionChecker;

        @Override
        public SimulatedAnnealing build() {
            var simulatedAnnealing = new SimulatedAnnealing();
            simulatedAnnealing.coolingConstant = this.coolingConstant;
            simulatedAnnealing.coolingSchedule = this.coolingSchedule;
            simulatedAnnealing.stopOuterLoopConditionChecker = this.stopOuterLoopConditionChecker;
            simulatedAnnealing.initTemperature = this.initTemperature;
            simulatedAnnealing.innerLoopLength = this.innerLoopLength;
            return simulatedAnnealing;
        }

        @Override
        public NeedStopOuterLoopConditionChecker coolingConstant(Double constant) {
            this.coolingConstant = constant;
            return this;
        }

        @Override
        public NeedInitTemperature coolingSchedule(CoolingScheduleType scheduleType) {
            try {
                this.coolingSchedule = CoolingScheduleFactor.getCoolingSchedule(scheduleType);
                return this;

            }catch (InvalidCoolingScheduleType invalidCoolingScheduleType) {
                //todo
                return null;
            }


        }

        @Override
        public NeedCoolingConstant initTemperature(Double temperature) {
            this.initTemperature = temperature;
            return this;
        }

        @Override
        public CanBeBuild innerLoopLength(int innerLoopLength) {
            this.innerLoopLength = innerLoopLength;
            return this;
        }

        @Override
        public NeedInnerLoopLength stopOuterLoopConditionChecker(StopOuterLoopConditionChecker stopOuterLoopConditionChecker) {
            this.stopOuterLoopConditionChecker = stopOuterLoopConditionChecker;
            return this;
        }
    }

    public Solution simulateAnneal(Solution solution){
        do {
            for (int iteration = 0; iteration < innerLoopLength; iteration++){
                //todo
            }

        }while (stopOuterLoopConditionChecker.shouldContinue());
        return solution;
    }



}
