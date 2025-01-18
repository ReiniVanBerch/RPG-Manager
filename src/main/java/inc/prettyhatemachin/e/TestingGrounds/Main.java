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
import inc.prettyhatemachin.e.App.CharDisplay;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application{
    private static CharacterMorbit cm;
    public static void App() {
        //LEISE AM AUSRASTEN

        System.out.println("Launching 1");
        cm = JsonConversionTherapy.getTestcharacter();
        launch();

        System.out.println("Launching 2");
        cm = JsonConversionTherapy.jsonConversion();
        launch();
    }

    @Override
    public void start(Stage stage) {
        CharacterMorbit cm;
        ArrayList<Stage> stages = new ArrayList<>();
        ArrayList<FXMLLoader> loaders = new ArrayList<>();
        ArrayList<CharacterDynamicController> controllers = new ArrayList<>();

        try{
            for (int i = 0; i < 3; i++) {
                stages.add(stage);

                cm = JsonConversionTherapy.getTestcharacter();

                loaders.add(new FXMLLoader(CharDisplay.class.getResource("CharacterDynamic.fxml")));
                Scene scene = new Scene(loaders.get(i).load(), 800, 400);

                CharacterDynamicController cdc = loaders.get(i).getController();
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

    }
}

