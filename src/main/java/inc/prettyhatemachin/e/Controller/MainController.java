package inc.prettyhatemachin.e.Controller;

import inc.prettyhatemachin.e.App.CharDisplay;
import inc.prettyhatemachin.e.App.Character;
import inc.prettyhatemachin.e.App.Help;
import inc.prettyhatemachin.e.App.Main;
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
                /*
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("ser Files", "*.json"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                Character load = Character.loadChar(selectedFile.toString());
                CharDisplay help = new CharDisplay();
                Stage charstage = new Stage();
                charstage.setUserData(load);
                help.start(charstage);

                 */

                Stage stage = new Stage();

                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("User Files", "*.json"));
                fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "\\build\\resources\\main\\sample.character"));
                File selectedFile = fileChooser.showOpenDialog(stage);

                Character character = Character.loadChar(selectedFile.toString());


                //CharDisplay help = new CharDisplay();
                Stage charstage = new Stage();
                charstage.setUserData(character);

                //help.start(charstage);

                FXMLLoader fxmlLoader = new FXMLLoader(CharDisplay.class.getResource("CharacterStatic.fxml"));

                Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                CharacterStaticController csc = fxmlLoader.getController();
                csc.setCharacter(character);

                // CSS hinzufügen
                scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());

                stage.setTitle("Digital Game Tracker - Character");
                stage.setScene(scene);
                stage.show();
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


    @FXML
    public void newCharOpen(){
        System.out.println("in the method");
        Stage newStage = new Stage();
        stages.add(newStage);
        loaders.add(new FXMLLoader(inc.prettyhatemachin.e.App.Main.class.getResource("CreateStaticCharacter.fxml")));

        //last index
        int lil = loaders.size() - 1;
        int lis = stages.size() - 1;

        Scene scene = null;
        try {
            scene = new Scene(loaders.get(lil).load(), 800, 400);
            stages.get(lis).setScene(scene);
            stages.get(lis).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



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
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "\\build\\resources\\main\\sample.characterDynamic"));
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
        // by by
        System.exit(0);
    }

    public void setStage(Stage stage) {
    }
}