package inc.prettyhatemachin.e.Common;

import java.util.ArrayList;

/**
 * @author V. Berchtold
 * @version 0.1.2
 *
 * PURPOSE:
 * The purpose of this is to handle a range.
 * As the upper bound needs to be larger than the lower.
 *
 * TODO:
 * The errors need to be displayed somewhere, where? idk, please help.
 *
 */

public class Range extends Quality {

    private Object lowerBound, upperBound;

    public Range(String comment, int typeNumber, ArrayList<?> range){
        super(comment, typeNumber, range);
        
        if(range.size() == 2){
            this.lowerBound = range.get(0);
            this.upperBound = range.get(1);
            /*
            if (isComparable(range.get(0)))
            if(checkValues(lowerBound, upperBound)){
            */
        }
    }


/*
    public boolean checkValues(Comparable lowerBound, Comparable upperBound){
        try{
            if(lowerBound.compareTo(upperBound) >= 0 ){

                return true;
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

    public void setLowerBound(Comparable lowerBound){
        if(checkValues(lowerBound, this.upperBound)){
            this.lowerBound = lowerBound;
        }
    }

    public void setUpperBound(Comparable upperBound){
        if(checkValues(this.lowerBound, upperBound)){
            this.upperBound = upperBound;
        }
    }
    */
}
