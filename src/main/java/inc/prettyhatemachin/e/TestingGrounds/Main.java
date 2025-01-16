package inc.prettyhatemachin.e.TestingGrounds;

/*----------------------------------------------------------------------------------------
 * Copyright (c) Morbit Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

import inc.prettyhatemachin.e.CharacterMorbit.CharacterMorbit;
import inc.prettyhatemachin.e.Controller.CharacterDynamicController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import inc.prettyhatemachin.e.App.App;

import java.io.IOException;

public class Main extends Application{
    private static CharacterMorbit cm;
    public static void App() {
        //LEISE AM AUSRASTEN


        cm = JsonConversionTherapy.jsonConversion();

        launch();
    }

    @Override
    public void start(Stage stage) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CharacterDynamic.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 400);



            CharacterDynamicController cdc = fxmlLoader.getController();
            cdc.setCharacter(cm);
            cdc.displayList();

            stage.setTitle(cm.getName());
            stage.setScene(scene);
            stage.show();


        } catch(IOException e){
            e.printStackTrace();
        }

    }
}

