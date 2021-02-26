package SimulatedAnnealing;

import AcceptanceNewSolution.AcceptanceNewSolutionMethod;
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
    private AcceptanceNewSolutionMethod acceptanceNewSolutionMethod;

    private SimulatedAnnealing(){

    }

    public Solution simulateAnneal(Solution solution){
        Solution theBestSolutionSoFar =solution;
        CurrentLoopData currentLoopData = new CurrentLoopData(initTemperature);
        currentLoopData.incrementLoop();
        do {
            for (int iteration = 0; iteration < innerLoopLength; iteration++){
                Solution newSolution = solution.generateNeighbourSolution();
                double delta = newSolution.fitnessFunction() - solution.fitnessFunction();
                if(acceptanceNewSolutionMethod.shouldAcceptNewSolution(delta, currentLoopData)){
                    solution = newSolution;
                }
                if(isNewSolutionBetter(theBestSolutionSoFar, newSolution)){
                    theBestSolutionSoFar = newSolution;
                }
            }
            currentLoopData.setTemperature(coolingSchedule.coolDownTemperature(currentLoopData.getLoopNumber(),initTemperature,coolingConstant));
        }while (!stopOuterLoopConditionChecker.shouldContinue(currentLoopData));
        return theBestSolutionSoFar;
    }

    private boolean isNewSolutionBetter(Solution oldSolution, Solution newSolution){
        double difference = newSolution.fitnessFunction() - oldSolution.fitnessFunction();
        return difference>0;
    }

    public static NeedCoolingSchedule builder() {
        return new Builder();
    }


    public static class Builder implements CanBeBuild, NeedCoolingSchedule, NeedInnerLoopLength, NeedCoolingConstant, NeedInitTemperature, NeedStopOuterLoopConditionChecker, NeedAcceptanceNewSolutionMethod {
        private int innerLoopLength;
        private double initTemperature;
        private double coolingConstant;
        private CoolingSchedule coolingSchedule;
        private StopOuterLoopConditionChecker stopOuterLoopConditionChecker;
        private AcceptanceNewSolutionMethod acceptanceNewSolutionMethod;


        @Override
        public SimulatedAnnealing build() {
            var simulatedAnnealing = new SimulatedAnnealing();
            simulatedAnnealing.coolingConstant = this.coolingConstant;
            simulatedAnnealing.coolingSchedule = this.coolingSchedule;
            simulatedAnnealing.stopOuterLoopConditionChecker = this.stopOuterLoopConditionChecker;
            simulatedAnnealing.initTemperature = this.initTemperature;
            simulatedAnnealing.innerLoopLength = this.innerLoopLength;
            simulatedAnnealing.acceptanceNewSolutionMethod = this.acceptanceNewSolutionMethod;
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
                System.exit(0);
                return null;
            }


        }

        @Override
        public NeedCoolingConstant initTemperature(Double temperature) {
            this.initTemperature = temperature;
            return this;
        }

        @Override
        public NeedAcceptanceNewSolutionMethod innerLoopLength(int innerLoopLength) {
            this.innerLoopLength = innerLoopLength;
            return this;
        }

        @Override
        public NeedInnerLoopLength stopOuterLoopConditionChecker(StopOuterLoopConditionChecker stopOuterLoopConditionChecker) {
            this.stopOuterLoopConditionChecker = stopOuterLoopConditionChecker;
            return this;
        }

        @Override
        public CanBeBuild AcceptanceNewSolutionMethod(AcceptanceNewSolutionMethod acceptanceNewSolutionMethod) {
            this.acceptanceNewSolutionMethod = acceptanceNewSolutionMethod;
            return this;
        }
    }





}
