package inc.prettyhatemachin.e.Tools;



import inc.prettyhatemachin.e.CharacterMorbit.CharacterMorbit;
import inc.prettyhatemachin.e.Quality.Quality;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class CharacterFileHandler {

    static public CharacterMorbit getCharacter(String jsonContent )  {
        try{
            JSONObject jsonObject = new JSONObject(jsonContent);

            return getCharacter(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  null;


    }
    static public CharacterMorbit getCharacter(JSONObject jObj) {
        try {
            String name = jObj.getString("name");
            JSONArray jQualities = jObj.getJSONArray("qualities");


            ArrayList<Quality> qualities = new ArrayList<>();

            for (int i = 0; i < jQualities.length(); i++) {
                JSONObject jQuality = jQualities.getJSONObject(i);

                String comment = jQuality.getString("comment");
                int typeNumber = jQuality.getInt("typeNumber");
                JSONArray jValues = jQuality.getJSONArray("values");

                ArrayList<Object> values = new ArrayList<>();


                for (int j = 0; j < jValues.length(); j++) {
                    Object jValue = jValues.get(j);


                    //Other than the intellisense suggesting, these casts are not redundant.
                    //Because values are Object Lists we are passing a more defined child
                    //This is to better handle the values later.
                    if (jValue instanceof Integer) {
                        values.add((int) jValue);
                    } else if (jValue instanceof BigDecimal) {
                        values.add(((BigDecimal) jValue).doubleValue());
                    } else if (jValue instanceof Boolean) {
                        values.add((boolean) jValue);
                    } else if (jValue instanceof String) {
                        values.add((String) jValue);
                    } else{
                        values.add(jValue.toString());
                    }
                }


                Quality q = TypeHelper.generateQuality(comment, typeNumber, values);
                qualities.add(q);

            }
            return new CharacterMorbit(name, qualities);


        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }




    }

    static public JSONObject getJSON(CharacterMorbit character) {
        if (character == null) {
            throw new IllegalArgumentException("Character object cannot be null.");
        }

        JSONObject characterJson = new JSONObject();
        characterJson.put("name", character.getName());

        JSONArray qualitiesArray = new JSONArray();


        for (Quality quality : character.getQualities()) {
            JSONObject qualityJson = new JSONObject();

            JSONArray valuesArray = new JSONArray(quality.getValues());

            qualityJson.put("comment", quality.getComment());
            qualityJson.put("values", valuesArray);
            qualityJson.put("typeNumber", quality.getTypeNumber());


            qualitiesArray.put(qualityJson);
        }

        // Add qualities to the main JSON object
        characterJson.put("qualities", qualitiesArray);

        // Return the JSON string
        return characterJson;


    }


}
