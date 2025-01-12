package inc.prettyhatemachin.e.Quality;

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
