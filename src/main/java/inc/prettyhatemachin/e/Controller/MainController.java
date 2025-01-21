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
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import java.util.ArrayList;



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
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "\\build\\resources\\main\\sample.character"));
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
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


    // Quit Button
    @FXML
    private void exit() {
        // by by
        System.exit(0);
    }

    public void setStage(Stage stage) {
    }
}