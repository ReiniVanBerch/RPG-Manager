package inc.prettyhatemachin.e.Common;//import org.json.*;

/**
 * @author V. Berchtold
 * @version 0.1.5
 *
 * PURPOSE:
 * The whole type is represented in hexadecimal, called typeNumber, but is just 1 Byte.
 * We split the byte into two half-bytes where the ...
 * ... first represents the "dataType", typeInt, so whether its an type o integer, double, boolean, whatever
 * ... second represetns the "quality", qualityInt, so whether its a sole value, a range, an array etc.
 *      -   the quality is translatable between types, so *F will always be an array,
 *          some have only theoretical types, it lets you generate boolean ranges, just not really ~worthy~
 *
 *
 * Types for the kind of information to be stored
 * as of 06.12.2024, day of the comeback
 *
 * 0# / Boolean
 * 1# / Integerg
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


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class TypeHelper {

    //Handle the different Types - just put in the "value" from character2property


    public static int getQualityInt(int typeNumber){return typeNumber % 0x10;}
    public static int getQualityInt(Class<?> c) {
        // Get the class type's simple name (to compare class names easily)
        if (c.equals(FixedValue.class)) {
            return 0x00; // FixedValue class
        } else if (c.equals(ChangingValue.class)) {
            return 0x01; // ChangingValue class
        } else if (c.equals(Range.class)) {
            return 0x02; // Range class
        } else if (c.equals(RangedValue.class)) {
            return 0x03; // RangedValue class
        } else if (c.equals(ListValue.class)) {
            return 0x0E; // ListValue class
        } else {
            return 0xFF; // Default for unknown classes
        }
    }

    public static int getTypeInt(int typeNumber){return typeNumber / 0x10;}
    public static int getTypeInt(Class c){

        if (c.equals(Boolean.class)) {
            return 0x00; // Boolean class
        } else if (c.equals(Integer.class)) {
            return 0x10; // Integer class
        } else if (c.equals(Double.class)) {
            return 0x02; // Double class
        } else if (c.equals(String.class)) {
            return 0xE0; // String class
        } else {
            return 0xFF; // Default for unknown or unhandled class types
        }
    }

    public static Class<?> getDataType(int typeNumber){
        int num = typeNumber / 0x10;
        switch (num){
            case 0x00:
                return boolean.class;
            case 0x01:
                return int.class;
            case 0x02:
                return double.class;
            case 0x03:
                return String.class;
            default:
                return Object.class;
        }
    }

    public static <T extends Quality> Class<T> getQuality(int typeNumber){
        int num = typeNumber % 0x10;
        switch (num){
            case 0x00:
                return (Class<T>) FixedValue.class;
            case 0x01:
                return (Class<T>) ChangingValue.class;
            case 0x02:
                return (Class<T>) Range.class;
            case 0x03:
                return (Class<T>) RangedValue.class;
            case 0x0E:
                return (Class<T>) ListValue.class;

            default:
                return null;
        }
    }


    public static <T extends Quality> Quality generateQuality(String comment, int typeNumber, ArrayList<T> qualities) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Object[] parameters = new Object[3];
        parameters[0] = comment;
        parameters[1] = typeNumber;
        parameters[2] = qualities;


        Class<T> c = (Class<T>) getQuality(typeNumber);
        Constructor<T> constructor = c.getConstructor(Quality.class);

        return constructor.newInstance(parameters);

    }


}