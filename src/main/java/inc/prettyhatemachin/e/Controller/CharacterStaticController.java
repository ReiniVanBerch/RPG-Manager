
package inc.prettyhatemachin.e.Controller;

import inc.prettyhatemachin.e.App.Character;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CharacterStaticController {

    private Character character;

    private StringProperty characterName = new SimpleStringProperty();

    @FXML
    private TextField characterNameField;

    private IntegerProperty characterHealth = new SimpleIntegerProperty(0);

    private IntegerProperty characterConstitution = new SimpleIntegerProperty(0);

    private IntegerProperty characterStrength = new SimpleIntegerProperty(0);

    @FXML
    private ListView<String> items;

    @FXML
    private ProgressBar progressBarHealth;

    @FXML
    private ProgressBar progressBarConstitution;

    @FXML
    private ProgressBar progressBarStrength;

    @FXML
    private ProgressBar progressBarCharacteristic4;






    public CharacterStaticController(){


    }

    public void setCharacter(Character character) {
        this.character = character;
        /*characterName.set = character.nameProperty();
        characterHealth = character.healthProperty();
        characterConstitution = character.constitutionProperty();
        characterStrength = character.strengthProperty();

        ObservableList<String> observable = FXCollections.observableArrayList(character.getItems());
        this.items = new ListView<>(observable);*/

        if (character != null) {
            characterName.set(character.getName());
            characterHealth.set(character.getHealth());
            characterConstitution.set(character.getConstitution());
            characterStrength.set(character.getStrength());

            // Reflect changes in the TextField
            if (characterNameField != null) {
                characterNameField.textProperty().bindBidirectional(characterName);
            }

            ObservableList<String> observable = FXCollections.observableArrayList(character.getItems());
            this.items = new ListView<>(observable);
        }
    }

    @FXML
    public void initialize() {
        //other stuff


        setCharacterName();
        //then
        updateProgressBarHealth();
        updateProgressBarConstitution();
        updateProgressBarStrength();
        //updateProgressBarCharacteristic4(); - not implemented

    }

    //TODO: gets called in initialise()
    public void setCharacterName() {
        if (characterName != null) {
            characterNameField.setText(characterName.getName());
        }

    }

    @FXML
    
    private void increaseOneHealth () {
        if (character.healthProperty().getValue() < 100) {
            character.healthProperty().add(1);
        }
        characterHealth.set(character.healthProperty().getValue());
        updateProgressBarHealth();

        //TODO: celebration gif if 100?
    }

    @FXML
    private void decreaseOneHealth() {
        if (character.healthProperty().getValue() > 0) {
            character.healthProperty().subtract(1);
        }
        characterHealth.set(character.healthProperty().getValue());
        updateProgressBarHealth();

        //TODO: death simulation if 0?

    }
    

    @FXML
    public void updateProgressBarHealth() {
        progressBarHealth.setProgress(characterHealth.getValue());
    }

    @FXML
    private void increaseOneConstitution() {
        if (character.constitutionProperty().getValue() < 100) {
            character.constitutionProperty().add(1);
        }
        characterConstitution.set(character.constitutionProperty().getValue());
        updateProgressBarConstitution();
    }

    @FXML
    private void decreaseOneConstitution() {
        if (character.constitutionProperty().getValue() > 0) {
            character.constitutionProperty().subtract(1);
        }
        characterConstitution.set(character.constitutionProperty().getValue());
        updateProgressBarConstitution();
    }


    @FXML
    public void updateProgressBarConstitution() {
        progressBarConstitution.setProgress(characterConstitution.getValue());
    }

    @FXML
    private void increaseOneStrength() {
        if (character.strengthProperty().getValue() < 100) {
            character.strengthProperty().add(1);
        }
        characterStrength.set(character.strengthProperty().getValue());
        updateProgressBarStrength();
    }

    @FXML
    private void decreaseOneStrength() {
        if (character.strengthProperty().getValue() > 0) {
            character.strengthProperty().subtract(1);
        }
        characterStrength.set(character.strengthProperty().getValue());
        updateProgressBarStrength();
    }

    @FXML
    public void updateProgressBarStrength() {
        progressBarStrength.setProgress(characterStrength.getValue());
    }


    //fourth characteristic - not implemented

    @FXML
    private void increaseOneCharacteristic4() {

    }

    @FXML
    private void decreaseOneCharacteristic4() {

    }

    //TODO: needs to be called after each button click of said characteristic
    @FXML
    public void updateProgressBarCharacteristic4() {

    }



    //for dynamic name and characteristics
    @FXML
    public void setCharacteristicName1() {

    }

    @FXML
    public void setCharacteristicName2() {

    }

    @FXML
    public void setCharacteristicName3() {

    }

    @FXML
    public void setCharacteristicName4() {

    }

}


