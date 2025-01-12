package inc.prettyhatemachin.e.Quality;

import java.util.ArrayList;

/**
 * @author V. Berchtold
 * @version 0.1.1
 *
 *
 * The purpose of this is to handle a Value in a range, including both bounds.
 * As the value needs between the two, all three values need to be comparable.
 *
 * TODO:
 * The errors need to be displayed somewhere, where? idk, please help.
 *
 */

public class RangedValue extends Quality {

    private Object lowerBound, upperBound, value;

    public RangedValue(String comment, Integer typeNumber, ArrayList<Object> rangedValue){
        super(comment, typeNumber, rangedValue);

        if(rangedValue.size() == 3){
            this.lowerBound = rangedValue.get(0);
            this.upperBound = rangedValue.get(1);
            this.value = rangedValue.get(2);
            /*
            if (isComparable(range.get(0)))
            if(checkValues(lowerBound, upperBound)){
            */
        }
    }
     /*
    public RangedValue(String name, Class<?> c,  lowerBound, Comparable upperBound, Comparable value){
        super(name, c);


        if(checkValues(lowerBound, upperBound, value)){
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.value = value;
        }


    }


    public boolean checkValues(Comparable lowerBound, Comparable upperBound, Comparable value){
        try{
            if(lowerBound.compareTo(upperBound) >= 0 ){

                if(value.compareTo(lowerBound) >= 0 && value.compareTo(upperBound) <= 0){
                    return true;
                }
                else {
                    throw new InvalidInputException("The value is not between the lower and upper bound.");
                }

            }
            else{
                throw new InvalidInputException("The lower bound is not equal or greater than the upper bound.");
            }
        } catch (InvalidInputException e){

            //
            //INVALID INPUT FOR
            //

            return false;
        }
    }

    public Object getLowerBound(){return this.lowerBound;}
    public Object getUpperBound(){return this.upperBound;}
    public Object getValue(){return this.value;}

    public void setLowerBound(Comparable lowerBound){
        if(checkValues(lowerBound, this.upperBound, this.value)){
            this.lowerBound = lowerBound;
        }
    }

    public void setUpperBound(Comparable upperBound){
        if(checkValues(this.lowerBound, upperBound, this.value)){
            this.upperBound = upperBound;
        }
    }

    public void setValue(Comparable value){
        if(checkValues(this.lowerBound, this.upperBound, value)){
            this.value = value;
        }
    }
    */
}
