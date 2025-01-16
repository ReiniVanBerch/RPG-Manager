package inc.prettyhatemachin.e.TestingGrounds;

import inc.prettyhatemachin.e.CharacterMorbit.CharacterMorbit;
import inc.prettyhatemachin.e.Tools.CharacterFileHandler;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonConversionTherapy {
    //LEISE AM AUSRASTEN


    static public CharacterMorbit jsonConversion() {


        try (InputStream inputStream = Main.class.getResourceAsStream("/sample.character/character3.json")) {
            if (inputStream == null) {
                System.out.println("Resource not found...");
            }

            // Read the resource content into a string
            String jsonContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            CharacterMorbit c = CharacterFileHandler.getCharacter(jsonContent);
            JSONObject jObj = CharacterFileHandler.getJSON(c);

            String cJSON = jObj.toString(4);

            CharacterMorbit c2 = CharacterFileHandler.getCharacter(cJSON);

            System.out.println(c2);

            return c2;


            // Use jsonContent as needed
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
