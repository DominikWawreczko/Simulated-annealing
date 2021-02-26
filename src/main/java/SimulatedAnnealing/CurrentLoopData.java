package SimulatedAnnealing;

public class CurrentLoopData {
    private double temperature;
    private int loopNumber;

    public CurrentLoopData(double temperature) {
        this.temperature = temperature;
        loopNumber = 0;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getLoopNumber() {
        return loopNumber;
    }
    public void incrementLoop(){
        this.loopNumber ++;
    }

}
