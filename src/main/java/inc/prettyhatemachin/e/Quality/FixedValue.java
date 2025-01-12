package inc.prettyhatemachin.e.Quality;

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
