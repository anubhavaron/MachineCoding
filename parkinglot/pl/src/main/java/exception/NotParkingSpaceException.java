package exception;

public class NotParkingSpaceException extends Exception{
    private final static String msg = "No Parking Space";
    public NotParkingSpaceException() {
        super(msg);
    }
}
