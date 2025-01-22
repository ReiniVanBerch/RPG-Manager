package inc.prettyhatemachin.e.Controller;

/**
 * @author Morbit
 * @version 0.1.1
 *
 * PURPOSE:
 * This is the controller for the window with completely dynamic characters.
 *
 * Left are the qualities of the character listed, in the mid are the values associated with that quality
 * and right might be a way to edit the quality, depending on the specifics of the quality.
 *
 */

import inc.prettyhatemachin.e.CharacterDynamic.CharacterDynamic;
import inc.prettyhatemachin.e.Exception.InvalidTypeException;
import inc.prettyhatemachin.e.Quality.Quality;
import inc.prettyhatemachin.e.Quality.FixedValue;

import inc.prettyhatemachin.e.Tools.CharacterFileHandler;
import inc.prettyhatemachin.e.Tools.TypeHelper;

import javafx.fxml.FXML;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class CharacterDynamicController {

    private CharacterDynamic character;
    private Quality currentQuality;

    @FXML
    private ListView<String> qualityList;
    @FXML
    private ListView<String> qualityValuesList;

    @FXML
    private TextField valuesTextField;

    @FXML
    private Button qualityButton;

    @FXML
    private Label qualityCommentLabel;
    @FXML
    private Label qualityTypeLabel;


    @FXML
    public void initialize(){

    }

    public void displayList(){
        ArrayList<Quality> qualities = this.character.getQualities();
        ArrayList<String> qualitiesAsString = new ArrayList<>();

        for (int i = 0; i < qualities.size(); i++) {
            qualitiesAsString.add(qualities.get(i).getComment());
        }

        qualityList.setItems(FXCollections.observableArrayList(qualitiesAsString));

    }

    public void loadQuality(){
        int index = qualityList.getSelectionModel().getSelectedIndex();
        this.currentQuality = this.character.getQualities().get(index);



        qualityCommentLabel.setText(this.currentQuality.getComment());
        try {
            qualityTypeLabel.setText(TypeHelper.getTypingAsString(this.currentQuality.getTypeNumber()));
        } catch (InvalidTypeException e){
            qualityTypeLabel.setText(e.toString());
        }
        ArrayList<String> valuesAsString = new ArrayList<>();


        for(Object value : this.currentQuality.getValues()){
            valuesAsString.add(value.toString());
        }
        qualityValuesList.setItems(FXCollections.observableArrayList(valuesAsString));

        valuesTextField.setText(this.currentQuality.getValuesAsInputString());

        qualityButton.setDisable(this.currentQuality.getClass().equals(FixedValue.class));

    }

    public Object dataTypeChecker(Class c, String input){

        try {
            if (c == Integer.class) {
                // Validate and convert to Integer
                return Integer.parseInt(input);
            } else if (c == Double.class) {
                // Validate and convert to Double
                return Double.parseDouble(input);
            } else if (c == Boolean.class) {
                // Validate and convert to Boolean
                if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                    return Boolean.parseBoolean(input);
                } else {

                    Alert a = new Alert(Alert.AlertType.ERROR, "Input is not a valid Boolean value.");
                    a.show();
                }
            } else if (c == String.class) {
                // No validation needed for String; just return it
                return input;
            } else {
                throw new IllegalArgumentException("Unsupported data type: " + c.getSimpleName());

            }

        } catch (Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("There seem to be wrong datatypes in the new values textBox");
            a.show();
        }
        return null;
    }


    public void saveChange()  {
        String valuesAsString = valuesTextField.getText();
        Class dt = currentQuality.getDataType();
        Class qt = currentQuality.getClass();

        String[] valuesString = valuesAsString.split(";");
        ArrayList<Object> values = new ArrayList<>();

        if(this.currentQuality.getValues().size() == valuesString.length){

            for(int i = 0; i < valuesString.length; i++){

                System.out.println("Trying: " + i + " -> " + dt.getSimpleName());
                String valueString = valuesString[i];

                Object obj = dataTypeChecker(dt, valueString);

                if(obj != null){
                    values.add(obj);
                }

            }


            try {
                Quality quality;
                quality = TypeHelper.generateQuality(this.currentQuality.getComment(), this.currentQuality.getTypeNumber(), values);
                this.character.setQuality(this.character.getQualities().indexOf(this.currentQuality), quality);
            } catch (Exception e){

                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(e.toString());
                a.show();
            }

            this.loadQuality();
        }
        else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Please give the same amount of arguments as already are given!");
            a.show();
        }
    }


    public void saveCharacter(){

        Stage saveStage = new Stage();

        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SAVE CHARACTER", "*.json");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "\\build\\resources\\main\\sample.characterDynamic"));
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog

        File file = fileChooser.showSaveDialog(saveStage);


        if (file != null) {
            try {
                saveWriter(file);
            }
            catch (IOException e){
                System.out.println("There is something wrong with the chosen file!\n" + e.toString());
            }
        }



    }

    public void saveWriter (File file) throws IOException {

        PrintWriter writer;
        writer = new PrintWriter(file);
        JSONObject jso = CharacterFileHandler.getJSON(this.character);
        writer.println(jso.toString(4));
        writer.close();
    }


    public CharacterDynamic getCharacter() {return character;}
    public void setCharacter(CharacterDynamic character) {this.character = character;}



}


