package inc.prettyhatemachin.e.Quality;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ChangingValue extends Quality {

    private Object changingValue;

    public ChangingValue(String comment, int typeNumber, ArrayList<?> changingValue) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        super(comment, typeNumber, changingValue);

        setChangingValue(changingValue);
    }

    public Object getChangingValue(){return changingValue;}
    public void setChangingValue(Object changingValue) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> c = this.getDataType();
        Constructor<?> constructor = c.getConstructor(c.getClass());

        this.changingValue = c.cast(constructor.newInstance(changingValue));

        this.changingValue = changingValue;
    }
}
