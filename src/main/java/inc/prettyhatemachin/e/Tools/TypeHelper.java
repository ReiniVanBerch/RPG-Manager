package inc.prettyhatemachin.e.Tools;

/**
 * @author Morbit
 * @version 0.1.7
 *
 * RECENT:
 * Revamped comment and sent type explanation to {@link inc.prettyhatemachin.e.Quality.Quality}
 *
 * PURPOSE:

 *
 *
 */


import inc.prettyhatemachin.e.Quality.*;

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
            System.out.println(c.getSimpleName());
            return 0x0F; // Default for unknown classes
        }
    }

    public static int getTypeInt(int typeNumber){return typeNumber / 0x10;}
    public static int getTypeInt(Class c){

        if (c.equals(Boolean.class)) {
            return 0x00; // Boolean class
        } else if (c.equals(Integer.class)) {
            return 0x10; // Integer class
        } else if (c.equals(Double.class)) {
            return 0x20; // Double class
        } else if (c.equals(String.class)) {
            return 0xE0; // String class
        } else {
            System.out.println(c.getSimpleName());
            return 0xF0; // Default for unknown or unhandled class types
        }
    }

    public static Class<?> getDataType(int typeNumber){
        int num = typeNumber / 0x10;


        switch (num){
            case 0x0:
                return Boolean.class;
            case 0x1:
                return Integer.class;
            case 0x2:
                return Double.class;
            case 0xE:
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


    public static <T extends Quality> Quality generateQuality(String comment, Integer typeNumber, ArrayList<Object> values) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Object[] parameters = new Object[3];
        parameters[0] = comment;
        parameters[1] = typeNumber;
        parameters[2] = values;


        Class<T> c = getQuality(typeNumber);
        Constructor<T> constructor = c.getConstructor(String.class, Integer.class, values.getClass() );

        return constructor.newInstance(parameters);

    }


}