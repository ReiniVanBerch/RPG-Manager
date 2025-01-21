
package inc.prettyhatemachin.e.App;
/*----------------------------------------------------------------------------------------
 * Copyright (c) BTS ka OS Corporation. All rights reserved.
 * Static Character Loader
 *---------------------------------------------------------------------------------------*/

import inc.prettyhatemachin.e.Quality.*;
import inc.prettyhatemachin.e.Quality.FixedValue;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class Character {







        private final StringProperty name;
        private final IntegerProperty health;
        private final IntegerProperty constitution;
        private final IntegerProperty strength;
        private final ArrayList<StringProperty> items = new ArrayList<>();
        public FixedValue name_value;
        public ChangingValue health_value;
        public ChangingValue constitution_value;
        public ChangingValue strength_value;
        //Character Constructor
        public Character (String name, int health, int constitution, int strength, ArrayList<String> itemsin) {
            this.name = new SimpleStringProperty(name);
            this.health = new SimpleIntegerProperty(health);
            this.constitution = new SimpleIntegerProperty(constitution);
            this.strength = new SimpleIntegerProperty(strength);
            for(String item : itemsin){
                items.add(new SimpleStringProperty(item));
            }
        }
        //Getters
        public String getName() {
            return name.get();
        }

        public StringProperty nameProperty() {
            return name;
        }

        public int getHealth() {
            return health.get();
        }

        public IntegerProperty healthProperty() {
            return health;
        }

        public int getConstitution() {
            return constitution.get();
        }

        public IntegerProperty constitutionProperty() {
            return constitution;
        }

        public int getStrength() {
            return strength.get();
        }

        public IntegerProperty strengthProperty() {
            return strength;
        }

        public ArrayList<String> getItems() {
            ArrayList<String> result = new ArrayList<>();
            for (StringProperty itms : this.itemsProperty()){
                result.add(itms.toString());
            }
            return result;
        }

    public ArrayList<String> getItemsvalue() {
        ArrayList<String> result = new ArrayList<>();
        for (StringProperty itms : this.itemsProperty()){
            result.add(itms.getValue());
        }
        return result;
    }
    //Setters
    public ArrayList<StringProperty> itemsProperty() {
        return items;
    }
    public void setName(String newname) {
        name.set(newname);
    }
    public void setHealth(int newhealth){
        health.set(newhealth);
    }
    public void setConstitution(int newconst){
        constitution.set(newconst);
    }
    public void setStrength(int newstrength){
        strength.set(newstrength);
    }
    public void addItems(String newitems){
        items.add(new SimpleStringProperty(newitems));
    }


    //Save Method
    public static void saveCharacter(Character object, String filename) {
        String jsonString = new JSONObject()
                .put("name", object.getName())
                .put("health", object.getHealth())
                .put("constitution", object.getConstitution())
                .put("strength", object.getStrength())
                .put("items", object.getItemsvalue())
                        .toString();

            try (FileOutputStream fos = new FileOutputStream(filename);
            ) {
            fos.write(jsonString.getBytes());
        } catch (IOException e) {
                Alert could = new Alert(Alert.AlertType.ERROR);
                could.setContentText("Could not save File");
                could.showAndWait();
            throw new RuntimeException(e);
        }
    }
    //Load Method
    public static Character loadChar(String filename) {

        try {
            InputStream fis = Files.newInputStream(Path.of(filename));
            String jsoninstring = new String(fis.readAllBytes(), StandardCharsets.UTF_8);
            JSONObject json = new JSONObject(jsoninstring);

            ;
            ArrayList<String> itemlist = new ArrayList();
            JSONArray jarray = json.getJSONArray("items");
            jarray.length();
            for(int i=0;i < jarray.length();i++){
                itemlist.add(jarray.get(i).toString());
            }
            Character loaded = new Character(json.getString("name"), json.getInt("health"),json.getInt("constitution"),json.getInt("strength"),itemlist);
            return loaded;
        } catch (IOException e) {
            throw new RuntimeException(e);


        }


    }
    /*

List <> sachen
    Claudius von Vengaberg  Cool RPG
    Trevor Michael
    RPG for Bros
    -> Ideen für Sachen HP (int) XP ranged Value Name fixed String Background Story
    Character Bild
    Sachen:
    Morbit
    Character + Closebutton
    Flo
    Startseite JavaFX
    Hera
    Characterpage - JavaFX
    Ayden


*/


}

