
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
    private ProgressBar progressBarHealth; //range 0-1

    @FXML
    private ProgressBar progressBarConstitution;

    @FXML
    private ProgressBar progressBarStrength;

    @FXML
    private ProgressBar progressBarCharacteristic4;

    @FXML
    public TextField healthNumberField;

    @FXML
    public TextField constitutionNumberField;

    @FXML
    public TextField strengthNumberField;

    @FXML
    public TextField characteristic4NumberField;






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

            //bind value to textfields
            if (characterNameField != null) {
                characterNameField.textProperty().bindBidirectional(characterName);
            }

            if (healthNumberField != null) {
                healthNumberField.textProperty().bind(characterHealth.asString());
            }

            if (constitutionNumberField != null) {
                constitutionNumberField.textProperty().bind(characterConstitution.asString());
            }

            if (strengthNumberField != null) {
                strengthNumberField.textProperty().bind(characterStrength.asString());
            }


            //characteristic 4 is not implemented
            if (characteristic4NumberField != null) {
                //characteristic4NumberField.textProperty().bind();
            }


            ObservableList<String> observable = FXCollections.observableArrayList(character.getItems());
            this.items = new ListView<>(observable);
        }
    }

    @FXML
    public void initialize() {
        //other stuff
        if (characterHealth != null) {
            healthNumberField.textProperty().bind(characterHealth.asString());
        }




        setCharacterName();
        characterNameField.setEditable(false);
        //then
        updateProgressBarHealth();
        updateProgressBarConstitution();
        updateProgressBarStrength();
        //updateProgressBarCharacteristic4(); - not implemented

    }

    public void setCharacterName() {
        if (characterName != null) {
            characterNameField.setText(characterName.getName());
        }

    }

    @FXML
    private void increaseOneHealth () {
        if (character.healthProperty().get() < 100) {
            character.healthProperty().set(character.getHealth() + 1);
            characterHealth.set(character.getHealth());
        }

        updateProgressBarHealth();

        //TODO: celebration gif if 100?
    }

    @FXML
    private void decreaseOneHealth() {
        if (character.healthProperty().get() > 0) {
            character.healthProperty().set(character.getHealth() - 1);
            characterHealth.set(character.getHealth());
        }

        updateProgressBarHealth();

        //TODO: death simulation if 0?

    }
    

    @FXML
    public void updateProgressBarHealth() {
        progressBarHealth.setProgress(characterHealth.get()/100.0);
    }

    @FXML
    private void increaseOneConstitution() {
        if (character.constitutionProperty().get() < 100) {
            character.constitutionProperty().set(character.getConstitution() + 1);
            characterConstitution.set(character.getConstitution());
        }
        updateProgressBarConstitution();
    }

    @FXML
    private void decreaseOneConstitution() {
        if (character.constitutionProperty().get() > 0) {
            character.constitutionProperty().set(character.getConstitution() - 1);
            characterConstitution.set(character.getConstitution());
        }

        updateProgressBarConstitution();
    }


    @FXML
    public void updateProgressBarConstitution() {
        progressBarConstitution.setProgress(characterConstitution.get()/100.0);
    }

    @FXML
    private void increaseOneStrength() {
        if (character.strengthProperty().get() < 100) {
            character.strengthProperty().set(character.getStrength() + 1);
            characterStrength.set(character.getStrength());
        }

        updateProgressBarStrength();
    }

    @FXML
    private void decreaseOneStrength() {
        if (character.strengthProperty().get() > 0) {
            character.strengthProperty().set(character.getStrength() - 1);
            characterStrength.set(character.getStrength());
        }

        updateProgressBarStrength();
    }

    @FXML
    public void updateProgressBarStrength() {
        progressBarStrength.setProgress(characterStrength.get()/100.0);
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


