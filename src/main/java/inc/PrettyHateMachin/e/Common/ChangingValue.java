package inc.PrettyHateMachin.e.Common;

public class ChangingValue extends Quality {

    private Object changingValue;

    public ChangingValue(Object changingValue, String comment){
        super(0xf1, comment);
        this.changingValue = changingValue;
    }

    public Object getChangingValue(){return changingValue;}
    public void setChangingValue(Object changingValue){
        this.changingValue = changingValue;
    }
}
