package inc.prettyhatemachin.e.Main;

/*----------------------------------------------------------------------------------------
 * Copyright (c) Morbit Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

import inc.prettyhatemachin.e.Character.Character;
import inc.prettyhatemachin.e.Tools.OpenCharacterFile;

public class Main {
    public static void main(String[] args) {
        //LEISE AM AUSRASTEN
        String json = "inc.prettyhatemachin.e.sample.character/character1.json";

        String path =  Main.class.getResource(json).getPath();
        Character character = OpenCharacterFile.getCharacter("path");



    }
}
