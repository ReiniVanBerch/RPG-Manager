package inc.PrettyHateMachin.e.App;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Character {
    private final StringProperty name;
    private final IntegerProperty health;
    private final IntegerProperty constitution;
    private final IntegerProperty strenght;
    private final ArrayList<StringProperty> items = new ArrayList<>();

    public Character(String name, int health, int constitution, int strenght, ArrayList<String> itemsin) {
        this.name = new SimpleStringProperty(name);
        this.health = new SimpleIntegerProperty(health);
        this.constitution = new SimpleIntegerProperty(constitution);
        this.strenght = new SimpleIntegerProperty(strenght);
        for(String item : itemsin){
            items.add(new SimpleStringProperty(item));
        }
    }

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

    public int getStrenght() {
        return strenght.get();
    }

    public IntegerProperty strenghtProperty() {
        return strenght;
    }

    /*public ArrayList<String> getItems() {
        return items.i;
    }
    */
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
    public void setStrenght(int newstrength){
        strenght.set(newstrength);
    }
    public void addItems(String newitems){
        items.add(new SimpleStringProperty(newitems));
    }

/*List <> sachen
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
