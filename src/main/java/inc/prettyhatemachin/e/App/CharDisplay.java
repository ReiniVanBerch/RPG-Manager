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

        Character character1 =(Character) stage.getUserData();



        FXMLLoader fxmlLoader = new FXMLLoader(CharDisplay.class.getResource("CharacterStatic.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        CharacterStaticController csc = fxmlLoader.getController();
        csc.setCharacter(character1);

        // CSS hinzufügen
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());

        stage.setTitle("My Simple \"Game Tracker\"");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}
