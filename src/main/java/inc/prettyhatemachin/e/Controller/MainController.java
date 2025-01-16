package inc.prettyhatemachin.e.Controller;

import inc.prettyhatemachin.e.App.Character;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainController {

    private Stage stage;



    // Methode zum Anzeigen der Charaktere
    @FXML
    private void showCharacters() {
        // Zeigt eine Informationsmeldung an
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Charaktere");
        alert.setHeaderText(null);
        alert.setContentText("Charaktere werden angezeigt!");
        alert.showAndWait();
    }

    // Methode zum Laden einer JSON-Datei
    @FXML
    private Character loadCharacter(Path path) throws IOException{
        // Erstellt einen FileChooser zum Auswählen der JSON-Datei
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("ser Files", "*.ser"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                // Liest den Inhalt der ausgewählten Datei
                Character char1 = loadCharacter((Paths.get(file.getAbsolutePath())));
                // Verarbeite die JSON-Datei (hier nur eine Informationsmeldung)
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("JSON-Datei geladen");
                alert.setHeaderText(null);
                alert.setContentText("JSON-Datei erfolgreich geladen!");
                alert.showAndWait();
            } catch (IOException e) {
                // Zeigt eine Fehlermeldung an, wenn die Datei nicht geladen werden kann
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Fehler");
                alert.setHeaderText(null);
                alert.setContentText("Fehler beim Laden der Datei!");
                alert.showAndWait();
            }
        }
        return null;
    }

    // Methode zum Beenden des Spiels
    @FXML
    private void exitGame() {
        // Beendet die Anwendung
        System.exit(0);
    }

    public void setStage(Stage stage) {
    }
}