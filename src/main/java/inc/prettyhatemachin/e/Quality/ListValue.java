package inc.prettyhatemachin.e.Quality;

/**
 * @author Morbit
 * @version 0.1.1
 *
 * PURPOSE:
 * this is for lists of values. Via tba features this will be able to turned into a die.
 *
 * EXAMPLES:
 * Loot-pools, a simple inventory, languages spoken, damage poools, etc.
 */

import java.util.ArrayList;

public class ListValue extends Quality{
    public ListValue(String comment, Integer typeNumber, ArrayList<Object> list){
        super(comment, typeNumber, list);
    }

}
