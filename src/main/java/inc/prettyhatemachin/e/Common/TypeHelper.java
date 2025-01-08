package inc.prettyhatemachin.e.Common;//import org.json.*;

/**
 * @author V. Berchtold
 * @version 0.1.3
 *
 * PURPOSE:
 * The whole type is represented in hexadecimal, called typeNumber, but is just 1 Byte.
 * We split the byte into two half-bytes where the ...
 * ... first represents the "dataType", typeInt, so whether its an type o integer, double, boolean, whatever
 * ... second represetns the "quality" or datatype, qualityInt, so whether its a sole value, a range, an array etc.
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
 * E# / Strings
 * F# / Errors and Debug
 *
 * #0 - Fixed Value
 * #1 - Double value
 * #2 - Range
 * #3 - Range with a current value
 * * - ---left open for future---
 * #E - Lists
 * #F - Errors and Debug for the specified type
 *
 *
 */





public class TypeHelper {
    //Handle the different Types - just put in the "value" from character2property

    public static int getTypeInt(int typeNumber){return typeNumber / 16;}
    public static int getQuality(int typeNumber){return typeNumber % 16;}

    

}