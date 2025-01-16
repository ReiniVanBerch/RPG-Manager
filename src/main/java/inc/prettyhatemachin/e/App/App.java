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

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Character character1, character2;
        character1 = new Character("Claudius von Vengaberg",100,100,200, new ArrayList<String>() {{add("Schild"); add("Schwert");}} );
        character2 = new Character("Trevor Noah",75,50,30,new ArrayList<String>(){{add("Wahnsinn"); add("Crystal Meth");}});

        CharacterStaticController csc = new CharacterStaticController(character1);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CharacterStatic.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setTitle("My Simple \"Game Tracker\"");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
        //inc.prettyhatemachin.e.TestingGrounds.Main.init();
    }
}
