package inc.prettyhatemachin.e.TestingGrounds;

import inc.prettyhatemachin.e.CharacterMorbit.CharacterMorbit;
import inc.prettyhatemachin.e.Tools.CharacterFileHandler;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonConversionTherapy {
    //LEISE AM AUSRASTEN
    static int charI = 0;

    static public CharacterMorbit getTestcharacter(){
        String file = "/sample.character/character" + charI+ ".json";

        try (InputStream inputStream = Main.class.getResourceAsStream(file)) {
            if (inputStream == null) {
                System.out.println("Resource not found...");
            }

            // Read the resource content into a string
            String jsonContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            CharacterMorbit c = CharacterFileHandler.getCharacter(jsonContent);
            charI++;
            return c;
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    static public CharacterMorbit jsonConversion() {


        JSONObject jObj = CharacterFileHandler.getJSON(getTestcharacter());

        String cJSON = jObj.toString(4);

        CharacterMorbit c2 = CharacterFileHandler.getCharacter(cJSON);

        System.out.println(c2);

        return c2;


    }
}
