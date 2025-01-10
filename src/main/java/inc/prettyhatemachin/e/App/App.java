package inc.prettyhatemachin.e.App;

/*----------------------------------------------------------------------------------------
 * Copyright (c) Morbit Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

import inc.prettyhatemachin.e.Tools.OpenCharacterFile;
import inc.prettyhatemachin.e.Character.Character;

public class App {
    public static void main(String[] args) {
        //LEISE AM AUSRASTEN
        String json = "inc.prettyhatemachin.e.sample.character/character1.json";

        String path =  App.class.getResource(json).getPath();
        Character character = OpenCharacterFile.getCharacter("path");



    }
}
