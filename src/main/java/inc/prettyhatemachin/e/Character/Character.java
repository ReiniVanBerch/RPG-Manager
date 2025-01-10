package inc.prettyhatemachin.e.Character;

import inc.prettyhatemachin.e.Quality.*;
import java.util.ArrayList;

/**
 * @author Morbit
 * @version 0.1.3
 *
 * PURPOSE:
 * Handling of a character and its qualities.
 * We figured the sole thing a character definitely and surely has is a name.
 * Everything else, whether it's HP or XP, Constituion or Insanity, will be given him in an list.
 * This list contains "qualities" these define our characters.
 *
 * For the list of qualities see {@link inc.prettyhatemachin.e.Quality.Quality}
 * TODO:
 * -Include more Checks
 * -Comment things better
 */


public class Character {

    public Character(String name) {
        this.name = name.strip();
    }

    public Character(String name, ArrayList<Quality> qualities) {
        this(name);
        this.qualities = qualities;
    }

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name.strip();
    }

    ArrayList<Quality> qualities = new ArrayList<>();
    public ArrayList<Quality> getProperties() { return qualities; }

    public <T extends Quality> void addProperty(T property) {
        qualities.add(property);

    }



}
