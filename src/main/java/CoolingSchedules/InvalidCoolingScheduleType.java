package CoolingSchedules;

public class InvalidCoolingScheduleType extends Exception{
    public String message;

    public InvalidCoolingScheduleType(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
