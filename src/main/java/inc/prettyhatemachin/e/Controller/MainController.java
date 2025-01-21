package inc.prettyhatemachin.e.Controller;

import inc.prettyhatemachin.e.App.CharDisplay;
import inc.prettyhatemachin.e.App.Character;
import inc.prettyhatemachin.e.App.Help;
import inc.prettyhatemachin.e.CharacterDynamic.CharacterDynamic;
import inc.prettyhatemachin.e.FuneralPyre.JsonConversionTherapy;
import inc.prettyhatemachin.e.Tools.CharacterFileHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONException;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    private MenuItem about;

    private ArrayList<Stage> stages;
    private ArrayList<FXMLLoader> loaders;
    private ArrayList<CharacterDynamicController> controllersDynamic;

    @FXML
    public void initialize(){
        stages = new ArrayList<>();
        loaders = new ArrayList<>();
        controllersDynamic = new ArrayList<>();


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
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("ser Files", "*.json"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                Character load = Character.loadChar(selectedFile.toString());
                CharDisplay help = new CharDisplay();
                Stage charstage = new Stage();
                charstage.setUserData(load);
                help.start(charstage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        about.setOnAction(event ->
                {
                    try {
                        Alert aboutal = new Alert(AlertType.NONE,"This is a program written by a the individual programmers of the Team BTS ka OS, in the spirit of game programmers, leaving bugs for everyone to find and lots of open point upon early release. " +
                                "There is no bugfinding fee, the hidden 'feature' was ready before the rest of the program, so our priorities were a little screwed up. Thank god we are not programmers in an atomic powerplant (c)2024 Pretty Hate Machin.e " ,ButtonType.OK);
                        aboutal.setTitle("About this program");
                        aboutal.setHeaderText("Gametracker by Pretty Hate Machin.e (Team BTS ka OS)");
                        aboutal.showAndWait();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        );


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

    public void openCharacterDynamic(CharacterDynamic cd){
        try{
            Stage newStage = new Stage();
            stages.add(newStage);
            loaders.add(new FXMLLoader(CharDisplay.class.getResource("CharacterDynamic.fxml")));

            //last index
            int lil = loaders.size() - 1;
            int lis = stages.size() - 1;

            Scene scene = new Scene(loaders.get(lil).load(), 800, 400);

            CharacterDynamicController cdc = loaders.get(lil).getController();


            cdc.setCharacter(cd);
            cdc.displayList();

            controllersDynamic.add(cdc);


            stages.get(lis).setTitle(cd.getName());
            stages.get(lis).setScene(scene);
            stages.get(lis).show();

        } catch (IOException e) {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("There was an Error loading this character. Something is in the IO");
            a.show();

        }
    }

    public void openCharacterDynamicFileChooser() throws IOException{


        Stage saveStage = new Stage();

        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("OPEN CHARACTER", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open dialog
        File file = fileChooser.showOpenDialog(saveStage);
        if (file != null) {
            try {
                CharacterFileHandler chf = new CharacterFileHandler();

                CharacterDynamic cd = chf.getCharacter(file);

                openCharacterDynamic(cd);
            }
            catch (InvocationTargetException ITex){
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("An error occured");
                a.show();
            }
            catch (NoSuchMethodException NMSex){
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("An error occured");
                a.show();
            }
            catch (InstantiationException Iex){
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("An error occured");
                a.show();
            }
            catch (IllegalAccessException IAex){
                Alert a = new Alert(AlertType.ERROR);
                a.setTitle("ERROR");
                a.setContentText("You aren't allowed to open this.");
                a.show();
            }
            catch (JSONException e){
                Alert a = new Alert(AlertType.ERROR);
                a.setTitle("ERROR");
                a.setContentText("Your JSON seems faulty.");
                a.show();
            }

        }
        else {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("ERROR");
            a.setContentText("The file you selected is empty!");
            a.show();
        }
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