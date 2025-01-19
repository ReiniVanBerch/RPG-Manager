package inc.prettyhatemachin.e.Quality;

/**
 * @author Morbit
 * @version 0.1.2
 *
 * PURPOSE:
 * The changing value is for a not fixated value.
 * There is no real lower or upper bound to this value, just the idea, that it is not fixed.
 *
 * EXAMPLES:
 * A list of items, number of kills, total damage taken, other statistics.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ChangingValue extends Quality {

    private Object changingValue;

    public ChangingValue(String comment, Integer typeNumber, ArrayList<Object> changingValue) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        super(comment, typeNumber, changingValue);
        this.changingValue = changingValue;
    }

    public Object getChangingValue(){return changingValue;}
    public void setChangingValue(Object changingValue) {
        if(changingValue.getClass() == this.changingValue.getClass()){
            this.changingValue = changingValue;
        }
    }
}
