package inc.prettyhatemachin.e.Tools;

import inc.prettyhatemachin.e.Character.Character;
import inc.prettyhatemachin.e.Common.Quality;
import inc.prettyhatemachin.e.Common.TypeHelper;
import netscape.javascript.JSObject;
import org.json.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class OpenCharacterFile {

    static public Character getCharacter(String filePath) {
        try {


            String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jObj = new JSONObject(jsonString);

            String name = jObj.getString("name");
            JSONArray jQualities = jObj.getJSONArray("qualities");


            ArrayList<Quality> qualities = new ArrayList<>();

            for (int i = 0; i < jQualities.length(); i++) {
                JSONObject jQuality = jQualities.getJSONObject(i);

                String comment = jQuality.getString("comment");
                int typeNumber = jQuality.getInt("typeNumber");
                JSONArray jValues = jQuality.getJSONArray("values");
                ArrayList<Quality> values = new ArrayList<>();

                for (int j = 0; j < jValues.length(); j++) {
                    Quality jValue = (Quality) jValues.get(j);
                    values.add(jValue);
                }


                Quality q = TypeHelper.generateQuality(comment, typeNumber, values);
                qualities.add(q);

            }

            return new Character(name, qualities);


        }catch (IOException ex) {
            System.err.println("An error occurred while reading the file: " + ex.getMessage());

        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }



        return null;
    }




}
