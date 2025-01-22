package inc.prettyhatemachin.e.App;




import inc.prettyhatemachin.e.Controller.CharacterStaticController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CharDisplay extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Character character;
        //character1 = new Character("Claudius von Vengaberg",28,73,1, new ArrayList<String>() {{add("Schild"); add("Schwert");}} );
        //character2 = new Character("Trevor Noah",75,50,30,new ArrayList<String>(){{add("Wahnsinn"); add("Crystal Meth");}});
        //Character.saveCharacter(character1, "src/main/resources/sample.character/character1.json");

        //Character.loadChar("src/main/resources/sample.character/character1.json");

        //ToDo dunno ob das da wer braucht sorry
        //Character character1 =(Character) stage.getUserData();


        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("User Files", "*.json"));
            File selectedFile = fileChooser.showOpenDialog(stage);

            character = Character.loadChar(selectedFile.toString());


            CharDisplay help = new CharDisplay();
            Stage charstage = new Stage();
            charstage.setUserData(character);

            help.start(charstage);

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





    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}
