package inc.prettyhatemachin.e.Controller;

import inc.prettyhatemachin.e.CharacterMorbit.CharacterMorbit;
import inc.prettyhatemachin.e.Quality.Quality;
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
    private Label qualityLabel;


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
        qualityLabel.setText(this.currentQuality.getComment());
    }

    @FXML
    public void processValue(){
        qualityList.getSelectionModel().select(0);
    }

    public CharacterMorbit getCharacter() {return character;}
    public void setCharacter(CharacterMorbit character) {this.character = character;}



}


