package inc.prettyhatemachin.e.TestingGrounds;

/*----------------------------------------------------------------------------------------
 * Copyright (c) BTS kA OS Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

import inc.prettyhatemachin.e.CharacterDynamic.CharacterDynamic;
import inc.prettyhatemachin.e.Controller.CharacterDynamicController;
import inc.prettyhatemachin.e.FuneralPyre.JsonConversionTherapy;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import inc.prettyhatemachin.e.App.CharDisplay;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application{
    private static CharacterDynamic cm;
    public static void App() {
        //LEISE AM AUSRASTEN

        launch();
    }

    @Override
    public void start(Stage stage) {
        /*
        CharacterDynamic cm;
        ArrayList<Stage> stages = new ArrayList<>();
        ArrayList<FXMLLoader> loaders = new ArrayList<>();
        ArrayList<CharacterDynamicController> controllers = new ArrayList<>();

        try{
            for (int i = 0; i < 2; i++) {
                stages.add(stage);

                cm = JsonConversionTherapy.getTestcharacter();

                loaders.add(new FXMLLoader(CharDisplay.class.getResource("CharacterDynamic.fxml")));
                Scene scene = new Scene(loaders.get(i).load(), 800, 400);

                CharacterDynamicController cdc = loaders.get(i).getController();

                cm.toString();
                cdc.setCharacter(cm);
                cdc.displayList();

                controllers.add(cdc);


                System.out.println("Opening... " + i + " : " + cm.getName());
                stages.get(i).setTitle(cm.getName());
                stages.get(i).setScene(scene);
                stages.get(i).show();
            }



        } catch(IOException e){
            e.printStackTrace();
        }
        */


    }
}

