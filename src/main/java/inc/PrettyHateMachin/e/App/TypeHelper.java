package inc.PrettyHateMachin.e.App;

//import org.json.*;

/**
 * @author Vincent Berchtold
 * @version 0.1.2
 *
 *
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
 * 00 - Boolean
 * 0* - ---left open for future---
 * 0F - Boolean Array
 *
 * 1# / Integer
 * 10 - Fixed Integer value
 * 11 - Changing Integer value
 * 12 - Integer Range
 * 13 - Integer Range with a current value
 * 1* - ---left open for future---
 * 1F - Integer Array
 *
 * 2# / Double
 * 20 - Fixed Double Value
 * 21 - Changing Double value
 * 22 - Double Range
 * 23 - Double Range with a current value
 * 2* - ---left open for future---
 * 2F - Integer Array
 *
 * 30-EF ---left open for future---
 *
 * F# / Strings
 * F0 - Text
 */





public class TypeHelper {
    //Handle the different Types - just put in the "value" from character2property

    public static Object typeResolver(int typeNumber, String value){
        int typeInt = typeNumber / 16;
        int qualityInt = typeNumber % 16;


    }

    public static Object jsonResolver(String json){




        return null;
    }







}
