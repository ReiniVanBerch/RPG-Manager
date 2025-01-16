package inc.prettyhatemachin.e.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Lade die FXML-Datei
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LandingPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 400);

            // CSS hinzufügen
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());

            // Controller holen und Stage setzen
            StartseiteController controller = fxmlLoader.getController();
            controller.setStage(stage);

            // Titel setzen und anzeigen
            stage.setTitle("Digital Game Tracker");
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
