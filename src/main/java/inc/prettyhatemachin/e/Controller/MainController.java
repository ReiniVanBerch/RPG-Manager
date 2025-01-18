package inc.prettyhatemachin.e.Controller;

import inc.prettyhatemachin.e.App.CharDisplay;
import inc.prettyhatemachin.e.App.Character;
import inc.prettyhatemachin.e.App.Help;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static inc.prettyhatemachin.e.App.Character.loadChar;

public class MainController {

    private Stage stage;
    @FXML
    private MenuItem downbutton;
    @FXML
    private Button exit;
    @FXML
    private MenuItem exit2;
    @FXML
    private Button loadchar;
    @FXML
    private Button newchar;


    @FXML
    public void initialize(){
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                exit.setOnMouseClicked(event ->
                        exit());

            }
        });
        exit2.setOnAction(event ->
                        exit());

        downbutton.setOnAction(event ->
        {
            try {
                Help help = new Help();
                Stage helpstage = new Stage();
                help.start(helpstage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        loadchar.setOnAction(event ->
        {
            try {
                CharDisplay help = new CharDisplay();
                Stage charstage = new Stage();
                help.start(charstage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


    }
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
    private void loadCharacter() {
        // Erstellt einen FileChooser zum Auswählen der JSON-Datei
        Character character1 = new Character("Claudius von Vengaberg",100,100,200, new ArrayList<String>() {{add("Schild"); add("Schwert");}} );
        {
            try {
//                CharacterStaticController csc = new CharacterStaticController(character1);
//                Stage charpstage = new Stage();
                CharDisplay.launch();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        new CharacterStaticController(character1);
        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("ser Files", "*.ser"));
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {

            // Liest den Inhalt der ausgewählten Datei
            Character char1 = loadChar(file.getAbsolutePath());
            // Verarbeite die JSON-Datei (hier nur eine Informationsmeldung)
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("JSON-Datei geladen");
            alert.setHeaderText(null);
            alert.setContentText("JSON-Datei erfolgreich geladen!");
            alert.showAndWait();
            Character character1 = new Character("Claudius von Vengaberg",100,100,200, new ArrayList<String>() {{add("Schild"); add("Schwert");}} );
            new CharacterStaticController(character1);


        }else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("JSON-Datei erfolgreich geladen!");
        }
*/

    }

    // Methode zum Beenden des Spiels
    @FXML
    private void exit() {
        // Beendet die Anwendung
        System.exit(0);
    }

    public void setStage(Stage stage) {
    }
}