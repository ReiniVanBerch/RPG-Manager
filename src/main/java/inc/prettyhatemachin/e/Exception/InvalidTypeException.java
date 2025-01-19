package inc.prettyhatemachin.e.Exception;

public class InvalidTypeException extends Exception {

    static String standardMessage = "Something is wrong with the typing of this object...";

    public InvalidTypeException(){
        super(standardMessage);
    }

    public InvalidTypeException(String message){
        super(standardMessage + ": " + System.lineSeparator() + message);

    }

    public InvalidTypeException(String message, int typeNumber){

        this();
        String output = InvalidTypeExceptionHelper(message, typeNumber);
    }

    public String InvalidTypeExceptionHelper(String message, int typeNumber){
        String output = "";
        int qualityInt = typeNumber % 16;
        int typeInt = typeNumber / 16;

        if (qualityInt == 0xF){ output += "There is something wrong in the quality of this..." + System.lineSeparator();}
        if (typeInt == 0xF){ output += "There is something wrong in the datatype of this..." + System.lineSeparator();}

        return output;
    }


}
