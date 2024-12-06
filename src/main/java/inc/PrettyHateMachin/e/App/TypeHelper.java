package inc.PrettyHateMachin.e.App;

import org.json.*;

/**
 * @author Vincent Berchtold
 * @version 0.1.01
 *
 * Types for the kind of information to be stored
 *
 * 0# / Boolean
 * 00 - Boolean
 * 0* - ---left open for future---
 * 0F - Boolean Array
 *
 * 1# / Integer
 * 10 - Fixed Integer value
 * 11 - Changing Integer value
 * 12 - Integer Range
 * 13 - Integer Range with a current value
 * 1* - ---left open for future---
 * 1F - Integer Array
 *
 * 2# / Double
 * 20 - Fixed Double Value
 * 21 - Changing Double value
 * 22 - Double Range
 * 23 - Double Range with a current value
 * 2* - ---left open for future---
 * 2F - Integer Array
 *
 * 30-EF ---left open for future---
 *
 * F# / Strings
 * F0 - Text
 */





public class TypeHelper {
    //Handle the different Types - just put in the "value" from character2property

    public static Object jsonResolver(String json){


        return null;
    }

    public static Object jsonResolver(JSONObject json){
        json.getJSONObject("properties");

        return null;
    }




}
