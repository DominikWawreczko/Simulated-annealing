package CoolingSchedules;

public class IllegalCoolingConstant extends IllegalArgumentException{
    public String message;

    public IllegalCoolingConstant(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
