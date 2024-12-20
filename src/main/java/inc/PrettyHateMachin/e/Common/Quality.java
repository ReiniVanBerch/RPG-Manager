package inc.PrettyHateMachin.e.Common;

import java.lang.reflect.Type;

public class Quality {

    private int typeNumber;
    private String comment;



    public Quality(int typeNumber, String comment){

        this.comment = comment;

        if(typeNumber < 0xFF) {
            this.typeNumber = typeNumber;
        }

    }

    public int getTypeNumber(){return this.typeNumber;}

    public void setComment(String comment){this.comment = comment;}
    public String getComment(){return this.comment;}

    public Type getDataType(){
        int typeInt = this.typeNumber % 0x10;

        try {
            switch (typeInt) {

                case 0x0: {
                    return boolean.class.getClass();
                }

                case 0x1: {
                    return int.class.getClass();
                }

                case 0x2: {
                    return double.class.getClass();
                }

                case 0xE: {
                    return String.class.getClass();
                }

                case 0xF: {
                    throw new InvalidTypeException("This type is reserved for errors and debug");
                }

                default:
                    throw new InvalidTypeException("The type of this is faulty atleast in its datatype");

            }
        }
        catch(InvalidTypeException e){
            //
            // HANDLE THIS ERROR PLS; I DONT KNOW WHAT DO TO WITH IT
            //
            return null;
        }

    }


}
