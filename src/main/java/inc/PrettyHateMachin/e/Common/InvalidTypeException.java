package inc.PrettyHateMachin.e.Common;

public class InvalidTypeException extends Exception {

    static String standardMessage = "Something is wrong with the typing of this object...";

    public InvalidTypeException(){
        super(standardMessage);
    }

    public InvalidTypeException(String message){
        super(standardMessage + ": " + System.lineSeparator() + message);

    }

}
