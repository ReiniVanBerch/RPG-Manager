package inc.prettyhatemachin.e.Controller;

import inc.prettyhatemachin.e.App.Character;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class CharacterStaticCreatorController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField healthTextField;

    @FXML
    private TextField constitutionTextField;

    @FXML
    private TextField strengthTextField;

    @FXML
    private TextField inventoryTextField;


    public void saveCharacter(){
        String name = nameTextField.getText();

        String[] itemsArray = inventoryTextField.getText().split(";");
        ArrayList<String> items = new ArrayList<>();

        for(int i = 0; i < itemsArray.length; i++){
            items.add(itemsArray[i]);
        }

        try {
            int health = Integer.parseInt(healthTextField.getText());
            int constitution = Integer.parseInt(constitutionTextField.getText());
            int strength = Integer.parseInt(strengthTextField.getText());

            Character character = new Character(name, health, constitution, strength, items);


            Stage saveStage = new Stage();
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SAVE CHARACTER", "*.json");
            fileChooser.getExtensionFilters().add(extFilter);


            File file = fileChooser.showSaveDialog(saveStage);

            Character.saveCharacter(character, file.toPath().toString());

        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(null);
            a.setContentText("Please enter a valid integers for the numbers.");
            a.show();
        }




    }





}
