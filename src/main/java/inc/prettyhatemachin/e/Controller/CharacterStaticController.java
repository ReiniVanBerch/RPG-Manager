
package inc.prettyhatemachin.e.Controller;

import inc.prettyhatemachin.e.App.Character;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CharacterStaticController {

    private final Character character;

    @FXML
    private final StringProperty characterName;

    @FXML
    private TextField characterNameField;

    @FXML
    private final IntegerProperty characterHealth;

    @FXML
    private final IntegerProperty characterConstitution;

    @FXML
    private final IntegerProperty characterStrength;

    @FXML
    private final ListView<String> items;




    public CharacterStaticController(Character character){
        this.character = character;

        characterName = character.nameProperty();
        characterHealth = character.healthProperty();
        characterConstitution = character.constitutionProperty();
        characterStrength = character.strengthProperty();

        ObservableList<String> observable = FXCollections.observableArrayList(character.getItems());
        this.items = new ListView<>(observable);
    }

    @FXML
    public void initialise() {

    }

    //TODO: gets called in initialise()
    public void setCharacterName() {
        characterNameField.setText(characterName.getName());
    }

    @FXML
    //TODO: different method for each different characteristic so i know which one to increase/decrease?
    private void increaseOneHealth () {

    }

    @FXML
    private void decreaseOneHealth() {

    }

    @FXML
    private void increaseOneConstitution() {

    }

    @FXML
    private void decreaseOneConstitution() {

    }

    @FXML
    private void increaseOneStrength() {

    }

    @FXML
    private void decreaseOneStrength() {

    }

}


