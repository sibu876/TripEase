package tripease.example.TripEase.exceptions;

public class CabNotAvailableException extends RuntimeException{
    public CabNotAvailableException(String message){
        super(message);
    }
}
