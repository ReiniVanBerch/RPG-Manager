package inc.prettyhatemachin.e.Quality;

/**
 * @author Morbit
 * @version 0.1.2
 *
 * PURPOSE:
 * This is meant for a fixed value, never meant to be changed.
 *
 * EXAMPLES:
 * Statistics in some TTRPG games as:
 * Netrunners Hacking in CyP Red
 * CoC statistics.
 *
 *
 */

import inc.prettyhatemachin.e.Tools.TypeHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class FixedValue extends Quality{

    private Object fixedValue;

    public FixedValue(String comment, Integer typeNumber, ArrayList<Object> fixedValue) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        super(comment, typeNumber, fixedValue);
        this.fixedValue = fixedValue.get(0);
    }

    public Object getFixedValue(){
        return fixedValue;
    }

}
