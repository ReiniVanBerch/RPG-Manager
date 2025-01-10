package inc.prettyhatemachin.e.Quality;

import inc.prettyhatemachin.e.Exception.InvalidTypeException;
import inc.prettyhatemachin.e.Tools.TypeHelper;

import java.util.ArrayList;

/**
 * @author Morbit
 * @version 0.18
 *
 * PURPOSE: Mother of the other qualities and helps regulate the handling of these
 * via defining things for the rest, while the rest gain extra handlers, as the data
 * of the different qualities is stored twice, once in the values list as in here
 * as well as there respective properties in their own classes.
 *
 *
 * There is an numerical approach via the typenumber,
 * handled by the typehelper. {@link inc.prettyhatemachin.e.Tools.TypeHelper}
 * That is the number in front of the definitions below.
 * Explanation still resides here.
 *
 * The whole type is represented in hexadecimal, called typeNumber, but is just 1 Byte.
 * We split the byte into two half-bytes (displayed as a hex number) where the ...
 *
 * ~1st represents the "dataType", typeInt, so whether its an type o integer, double, boolean, whatever
 * - 0# / Boolean
 * - 1# / Integers
 * - 2# / Double
 * - E# / Strings
 * - F# / Errors and Debug
 *
 *
 * ~2nd represents the "quality", qualityInt, so whether it"s a sole value, a range, a list etc.
 * - #0 - Fixed Value
 *  {@link inc.prettyhatemachin.e.Quality.FixedValue}
 *
 * - #1 - Changing value
 *   {@link inc.prettyhatemachin.e.Quality.ChangingValue}
 *
 * - #2 - Range
 *   {@link inc.prettyhatemachin.e.Quality.Range}
 *
 * - #3 - Range with a current value
 *   {@link inc.prettyhatemachin.e.Quality.RangedValue}
 *
 * - ---left open for future---
 *
 * - #E - Lists
 *   {@link inc.prettyhatemachin.e.Quality.ListValue}
 *
 * NOTES:
 * Some pairings between qualities and datatype don't make any practical sense, but the system will still handle it.
 * E.g. you can make a boolean range, or String ranges.
 *
 * If there is an F present int, it should represent an error in the according thing.
 * E.g. 0xFE would be a list with an error.
 *      0x1F would be an integer with an faulty quality.
 *      0xFF would be an total error, the highest tier.
 *
 *
 */


public class Quality {

    private Class<? extends Quality> quality;
    private Class<?> datatype;
    private String comment;
    private ArrayList<?> values;

    TypeHelper typeHelper;


    public Quality(String comment, int typeNumber, ArrayList<?> values) {

        try{

            this.comment = comment;
            this.values = values;

            if(typeNumber < 0xFF) {
                typeHelper = new TypeHelper();

                this.quality = typeHelper.getQuality(typeNumber);
                this.datatype = typeHelper.getDataType(typeNumber);
            }
            else throw new InvalidTypeException("");
        } catch (InvalidTypeException e){

            //
            //INVALID INPUT FOR
            //


        }

    }

    public int getTypeNumber() {
        int qi = TypeHelper.getQualityInt(this.quality);
        int ti = TypeHelper.getTypeInt(this.datatype);
        return qi + ti;
    }

    public void setComment(String comment){this.comment = comment;}
    public String getComment(){return this.comment;}

    public Class<?> getDataType(){
        return this.datatype;
    }


}
