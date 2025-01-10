package inc.prettyhatemachin.e.Quality;

import inc.prettyhatemachin.e.Tools.TypeHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class FixedValue extends Quality{

    private Object fixedValue;

    public FixedValue(String comment, int typeNumber, ArrayList<?> fixedValue) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        super(comment, typeNumber, fixedValue);

        Class<?> c = TypeHelper.getDataType(typeNumber);
        Constructor<?> constructor = c.getConstructor(c.getClass());

        this.fixedValue = c.cast( constructor.newInstance(fixedValue));
    }

    public Object getFixedValue(){
        return fixedValue;
    }

}
