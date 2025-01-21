package inc.prettyhatemachin.e.App;
/*----------------------------------------------------------------------------------------
 * Copyright (c) BTS ka OS Corporation. All rights reserved.
 * Main Stage Loader
 *---------------------------------------------------------------------------------------*/
import inc.prettyhatemachin.e.Controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Loads the FXML-File
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LandingPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 400);

            // set CSS Style
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());

            // gets controller and sets the stage
            MainController controller = fxmlLoader.getController();
            controller.setStage(stage);
            // Sets the Title and Scene
            stage.setTitle("Digital Game Tracker - Team ka OS");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Fehler beim Laden der FXML-Datei oder CSS:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
