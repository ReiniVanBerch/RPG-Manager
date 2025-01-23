
package inc.prettyhatemachin.e.Controller;

import inc.prettyhatemachin.e.App.Character;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;

import java.io.File;

public class CharacterStaticController {

    private Character character;

    private final StringProperty characterName = new SimpleStringProperty();
    private final StringProperty characteristic4Name = new SimpleStringProperty("optional");

    @FXML
    private TextField characterNameField;


    //values of characteristics
    //health has range 0-100 ->  numbers>100 will be set to 100, numbers<0 to 0
    private final IntegerProperty characterHealth = new SimpleIntegerProperty(0);

    //health has range 0-100 ->  numbers>100 will be set to 100, numbers<0 to 0
    private final IntegerProperty characterConstitution = new SimpleIntegerProperty(0);

    //health has range 0-25 ->  numbers>25 will be set to 25, numbers<0 to 0
    private final IntegerProperty characterStrength = new SimpleIntegerProperty(0);

    // characteristic4 has range 0-100
    private final IntegerProperty characteristic4Value = new SimpleIntegerProperty();



    @FXML
    private ListView<String> items;


    //progress bar fields
    @FXML
    private ProgressBar progressBarHealth; //range 0-1

    @FXML
    private ProgressBar progressBarConstitution;

    @FXML
    private ProgressBar progressBarStrength;

    @FXML
    private ProgressBar progressBarCharacteristic4;


    //health number fields
    @FXML
    private TextField healthNumberField;

    @FXML
    private TextField constitutionNumberField;

    @FXML
    public TextField strengthNumberField;

    @FXML
    private TextField characteristic4NumberField;


    //showcasing the name of the characteristic - fields
    @FXML
    private TextField healthNameField;

    @FXML
    private TextField constitutionNameField;

    @FXML
    private TextField strengthNameField;

    @FXML
    private TextField characteristic4NameField;



    public CharacterStaticController(){
        //default constructor
    }

    public void setCharacter(Character character) {
        this.character = character;

        if (character != null) {
            characterName.set(character.getName());
            characterHealth.set(Math.max(0, Math.min(character.getHealth(), 100))); //ensures in bounds
            characterConstitution.set(Math.max(0, Math.min(character.getConstitution(), 100)));
            characterStrength.set(Math.max(0, Math.min(character.getStrength(), 25)));
            characteristic4Value.set(Math.max(0, Math.min(character.getCharacteristic(), 100)));

            //in case characteristic 4 is pre-added
            if (character.getCharacteristicName() != null) {
                characteristic4Name.set(character.getCharacteristicName());
                characteristic4NameField.setText(character.getCharacteristicName());
                characteristic4NameField.setEditable(false);
            }
            if (character.getCharacteristic() != 0) {
                characteristic4Value.set(Math.max(0, Math.min(character.getCharacteristic(), 100)));
                characteristic4NumberField.setEditable(false);
            }

            if (character.getCharacteristicName() != null) {
                characteristic4Name.set(character.getCharacteristicName());
            } else {
                setCharacteristic4Name();
            }


            //in case values were changed
            character.setHealth(characterHealth.get());
            character.setConstitution(characterConstitution.get());
            character.setStrength(characterStrength.get());
            character.setCharacteristic(characteristic4Value.get());


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

            if (characteristic4NumberField != null) {
                characteristic4NumberField.textProperty().bind(characteristic4Value.asString());
            }

            if (characteristic4NameField != null) {
                characteristic4NameField.textProperty().bindBidirectional(characteristic4Name);
            }



            showItems();
            updateProgressBarConstitution();
            updateProgressBarStrength();
            updateProgressBarHealth();
            updateProgressBarCharacteristic4();

        }
    }

    @FXML
    public void initialize() {
        setCharacterName();
        characterNameField.setEditable(false);
        strengthNameField.setEditable(false);
        constitutionNameField.setEditable(false);
        healthNameField.setEditable(false);

        //displays progress bars and items upon opening the screen
        updateProgressBarHealth();
        updateProgressBarConstitution();
        updateProgressBarStrength();
        showItems();

        //characteristic 4

        updateProgressBarCharacteristic4();

    }

    //shows character name on screen
    public void setCharacterName() {
        characterNameField.setText(characterName.getName());

    }

    //shows items in list view on screen
    public void showItems() {
        if (character != null && items != null) {
            ObservableList<String> observable = FXCollections.observableArrayList(character.getItems());
            items.setItems(observable);
        }
    }

    //increases health by 1
    @FXML
    private void increaseOneHealth () {
        if (character.healthProperty().get() < 100) {
            character.healthProperty().set(character.getHealth() + 1);
        } else {
            character.setHealth(100);
        }
        characterHealth.set(character.getHealth());
        updateProgressBarHealth();
    }

    //decreases health by 1
    @FXML
    private void decreaseOneHealth() {
        if (character.healthProperty().get() > 0) {
            character.healthProperty().set(character.getHealth() - 1);
        } else {
            character.setHealth(0);
        }
        characterHealth.set(character.getHealth());
        updateProgressBarHealth();
    }

    //updates progress bar for health
    @FXML
    public void updateProgressBarHealth() {
        progressBarHealth.setProgress(characterHealth.get()/100.0);
    }

    //increases constitution by 1
    @FXML
    private void increaseOneConstitution() {
        if (character.constitutionProperty().get() < 100) {
            character.constitutionProperty().set(character.getConstitution() + 1);
        } else {
            character.setConstitution(100);
        }
        characterConstitution.set(character.getConstitution());
        updateProgressBarConstitution();
    }

    //decreases constitution by 1
    @FXML
    private void decreaseOneConstitution() {
        if (character.constitutionProperty().get() > 0) {
            character.constitutionProperty().set(character.getConstitution() - 1);
        } else {
            character.setConstitution(0);
        }
        characterConstitution.set(character.getConstitution());
        updateProgressBarConstitution();
    }

    //updates progress bar for constitution
    @FXML
    public void updateProgressBarConstitution() {
        progressBarConstitution.setProgress(characterConstitution.get()/100.0);
    }

    //increases strength by 1
    @FXML
    private void increaseOneStrength() {
        if (character.strengthProperty().get() < 25) {
            character.strengthProperty().set(character.getStrength() + 1);
        } else {
            character.setStrength(25);
        }
        characterStrength.set(character.getStrength());
        updateProgressBarStrength();
    }

    //decreases strength by 1
    @FXML
    private void decreaseOneStrength() {
        if (character.strengthProperty().get() > 0) {
            character.strengthProperty().set(character.getStrength() - 1);
        } else {
            character.setStrength(0);
        }
        characterStrength.set(character.getStrength());
        updateProgressBarStrength();
    }

    //updates progress bar for strength
    @FXML
    public void updateProgressBarStrength() {
        progressBarStrength.setProgress(characterStrength.get()/25.0);
    }

    //Save Button yay
    @FXML
    public void saveFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "\\build\\resources\\main\\sample.character"));
        File selectedFile = fileChooser.showSaveDialog(healthNumberField.getScene().getWindow());

        character.setCharacteristicname(characteristic4Name.get());
        character.setCharacteristic(characteristic4Value.get());

        Character.saveCharacter(character,selectedFile.toString());

    }


    //increases value of characteristic 4 by 1
    @FXML
    private void increaseOneCharacteristic4() {
        if (characteristic4Value.get() < 100) {
            characteristic4Value.set(characteristic4Value.get() + 1);
        } else {
            characteristic4Value.set(100);
        }
        updateProgressBarCharacteristic4();
    }

    //decreases value of characteristic 4 by 1
    @FXML
    private void decreaseOneCharacteristic4() {
        if (characteristic4Value.get() > 0) {
            characteristic4Value.set(characteristic4Value.get() - 1);
        } else {
            characteristic4Value.set(0);
        }
        updateProgressBarCharacteristic4();

    }

    //updates progress bar for characteristic 4
    @FXML
    public void updateProgressBarCharacteristic4() {
        progressBarCharacteristic4.setProgress(characteristic4Value.get()/100.0);
    }

    //lets user type in characteristic name
    @FXML
    public void setCharacteristic4Name() {
        if (characteristic4NameField != null) {
            characteristic4NameField.textProperty().bindBidirectional(characteristic4Name);
            characteristic4NameField.textProperty().addListener(((observable, oldValue, newValue) -> {
                try {
                    if (!newValue.matches("[a-zA-Z ]*")) {
                        throw new IllegalArgumentException("oh no :( please only use letters or spaces");
                    }
                    characteristic4Name.set(newValue);
                } catch (IllegalArgumentException e) {
                    characteristic4NameField.setText(oldValue);
                    showErrorAlert("Error - Invalid Input", e.getMessage());
                }
            }));
        }

    }

    //Error message
    private void showErrorAlert(String title, String content) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(content);
        a.show();
    }

}


