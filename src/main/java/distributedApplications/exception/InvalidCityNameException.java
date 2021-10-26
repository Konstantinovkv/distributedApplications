package distributedApplications.exception;

public class InvalidCityNameException extends Exception{

    private String message;

    public InvalidCityNameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
