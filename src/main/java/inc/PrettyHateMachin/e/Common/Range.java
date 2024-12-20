package inc.PrettyHateMachin.e.Common;


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

    private Comparable lowerBound, upperBound;

    public Range(Comparable lowerBound, Comparable upperBound, String comment){
        super(0xf, comment);
        if(checkValues(lowerBound, upperBound)){
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

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
}
