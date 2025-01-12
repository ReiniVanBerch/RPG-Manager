package inc.prettyhatemachin.e.TestingGrounds;

/*----------------------------------------------------------------------------------------
 * Copyright (c) Morbit Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

import inc.prettyhatemachin.e.CharacterMorbit.CharacterMorbit;
import inc.prettyhatemachin.e.Tools.CharacterFileHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


public class Main {
    public static void init() throws IOException {
        //LEISE AM AUSRASTEN




        try (InputStream inputStream = Main.class.getResourceAsStream( "/sample.character/character3.json")) {
            if (inputStream == null) {
                System.out.println("Resource not found...");
            }

            // Read the resource content into a string
            String jsonContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            CharacterMorbit c = CharacterFileHandler.getCharacter(jsonContent);
            JSONObject jObj= CharacterFileHandler.getJSON(c);

            String cJSON = jObj.toString(4);

            CharacterMorbit c2 = CharacterFileHandler.getCharacter(cJSON);

            System.out.println(c2);


            // Use jsonContent as needed
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}

