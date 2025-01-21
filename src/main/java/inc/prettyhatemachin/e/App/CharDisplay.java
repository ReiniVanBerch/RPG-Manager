package inc.prettyhatemachin.e.App;

/*----------------------------------------------------------------------------------------
 * Copyright (c) Morbit Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/


import inc.prettyhatemachin.e.Controller.CharacterStaticController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class CharDisplay extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Character character1, character2;
        character1 = new Character("Claudius von Vengaberg",28,73,1, new ArrayList<String>() {{add("Schild"); add("Schwert");}} );
        character2 = new Character("Trevor Noah",75,50,30,new ArrayList<String>(){{add("Wahnsinn"); add("Crystal Meth");}});
        Character.saveCharacter(character1, "src/main/resources/sample.character/character1.json");
        //Character.loadChar("src/main/resources/sample.character/character1.json");

        FXMLLoader fxmlLoader = new FXMLLoader(CharDisplay.class.getResource("CharacterStatic.fxml"));
        //fxmlLoader.setController(csc);
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        CharacterStaticController csc = fxmlLoader.getController();
        csc.setCharacter(character1);

        // CSS hinzufügen
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());

        stage.setTitle("Digital Game Tracker - Character");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
        //inc.prettyhatemachin.e.TestingGrounds.Main.init();
    }
}
