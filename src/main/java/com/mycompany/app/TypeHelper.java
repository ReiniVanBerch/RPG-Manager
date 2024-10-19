package com.mycompany.app;
import org.json.*;
import netscape.javascript.JSObject;

/**The following types exist
 *
 * @author Vincent Berchtold
 * @version 0.1.0
 *
 * 0# / Boolean
 * 00 - Boolean
 *
 * 1# / Integer
 * 10 - Fixed Integer value
 * 11 - Changing Integer value
 * 12 - Integer Range
 * 13 - Integer Range with a current value
 *
 * 2# / Double
 * 20 - Fixed Double Value
 * 21 - Changing Double value
 * 22 - Double Range
 * 23 - Double Range with a current value
 *
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
