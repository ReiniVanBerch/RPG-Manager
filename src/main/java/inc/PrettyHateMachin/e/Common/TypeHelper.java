package inc.PrettyHateMachin.e.Common;

//import org.json.*;

/**
 * @author V. Berchtold
 * @version 0.1.3
 *
 * PURPOSE:
 * The type is represented in hexadecimal, but is just 1 Byte.
 * We split the byte into two half-bytes where the ...
 * ... first represents the "type", typeInt, so whether its an type o integer, double, boolean, whatever
 * ... second represetns the "quality", qualityInt, so whether its a sole value, a range, an array etc.
 *      -   the quality is translatable between types, so *F will always be an array,
 *          some have only theoretical types, it lets you generate boolean ranges, just not really ~worthy~
 *
 *
 * Types for the kind of information to be stored
 * as of 06.12.2024, day of the comeback
 *
 * 0# / Boolean
 * 1# / Integer
 * 2# / Double
 * F# / Strings
 *
 * #0 - Fixed Value
 * #1 - Double value
 * #2 - Range
 * #3 - Range with a current value
 * * - ---left open for future---
 * #F - Lists
 *
 * 30-EF ---left open for future---
 *
 */





public class TypeHelper {
    //Handle the different Types - just put in the "value" from character2property

    public static Object typeResolver(int typeNumber, String value){
        int typeInt = typeNumber / 16;
        int qualityInt = typeNumber % 16;

        Object obj;

        switch (qualityInt){
            case 0:
                // one fixed value

                break;

            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

        }



        return new Object();
    }

    public static Object jsonResolver(String json){
        return null;
    }
}