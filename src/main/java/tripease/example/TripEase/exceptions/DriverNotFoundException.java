package tripease.example.TripEase.exceptions;

public class DriverNotFoundException extends RuntimeException{
    public DriverNotFoundException(String message){
        super(message);
    }
}
