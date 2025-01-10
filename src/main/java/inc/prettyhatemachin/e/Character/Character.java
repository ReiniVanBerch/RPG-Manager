package inc.prettyhatemachin.e.Character;

import inc.prettyhatemachin.e.Quality.*;
import java.util.ArrayList;

/**
 * @author Morbit
 */


public class Character {
    /*
        Hey, des isch kle was i mit dynamic gmoant hab,
        mir hon des jetzt fuer eine Art von Character, aba ne universell.

        Miene Version
        private final StringProperty name;


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




    public Character(String name, ArrayList<Quality> properties) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {}

    ArrayList<Quality> qualities = new ArrayList<>();
    public ArrayList<?> getProperties() { return qualities; }

    public <T extends Quality> void addProperty(T property) {
        qualities.add(property);

    }



}
