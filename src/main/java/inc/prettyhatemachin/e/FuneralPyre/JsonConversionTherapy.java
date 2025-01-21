package inc.prettyhatemachin.e.FuneralPyre;

import inc.prettyhatemachin.e.CharacterDynamic.CharacterDynamic;
import inc.prettyhatemachin.e.TestingGrounds.Main;
import inc.prettyhatemachin.e.Tools.CharacterFileHandler;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonConversionTherapy {
    //LEISE AM AUSRASTEN
    static int charI = 0;
    /*
    static public CharacterDynamic getTestcharacter(){

        String file = "/sample.characterMorbit/character" + charI+ ".json";

        try (InputStream inputStream = Main.class.getResourceAsStream(file)) {
            if (inputStream == null) {
                System.out.println("Resource not found...");
            }

            // Read the resource content into a string
            CharacterFileHandler cfh = new CharacterFileHandler();

            String jsonContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            CharacterDynamic c = cfh.getCharacter(jsonContent);
            charI++;
            return c;
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }



    }

    static public CharacterDynamic jsonConversion() {


        JSONObject jObj = CharacterFileHandler.getJSON(getTestcharacter());

        String cJSON = jObj.toString(4);

        CharacterFileHandler cfh = new CharacterFileHandler();

        CharacterDynamic c2 = cfh.getCharacter(cJSON);

        System.out.println(c2);

        return c2;


    }
    */

}
