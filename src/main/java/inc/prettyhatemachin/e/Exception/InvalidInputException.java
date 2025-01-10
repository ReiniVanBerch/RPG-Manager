package inc.prettyhatemachin.e.Exception;

public class InvalidInputException extends Exception{

    static String standardMessage = "One or more of your inputs is invalid";

    public InvalidInputException(){
        super(standardMessage);
    }

    public InvalidInputException(String message){
        super((standardMessage + ": " + System.lineSeparator() + message));

    }

}
