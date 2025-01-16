package inc.prettyhatemachin.e.Controller;

import inc.prettyhatemachin.e.CharacterMorbit.CharacterMorbit;
import inc.prettyhatemachin.e.Quality.Quality;
import inc.prettyhatemachin.e.Tools.TypeHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;




public class CharacterDynamicController {

    private CharacterMorbit character;
    private Quality currentQuality;

    @FXML
    private ListView<String> qualityList;
    @FXML
    private ListView<String> qualityValuesList;


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
        qualityTypeLabel.setText(TypeHelper.getTypingAsString(this.currentQuality.getTypeNumber()));

        ArrayList<String> valuesAsString = new ArrayList<>();

        for(Object value : this.currentQuality.getValues()){
            valuesAsString.add(value.toString());
        }
        qualityValuesList.setItems(FXCollections.observableArrayList(valuesAsString));
    }


    public CharacterMorbit getCharacter() {return character;}
    public void setCharacter(CharacterMorbit character) {this.character = character;}



}


