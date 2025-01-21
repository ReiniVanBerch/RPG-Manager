package inc.prettyhatemachin.e.Tools;
import inc.prettyhatemachin.e.App.Character;


import java.util.ArrayList;

public class Testcharcreator {
    public static void main(String[] args){
        Character character2 = new Character("Trevor Noah",75,50,30,new ArrayList<String>(){{add("Wahnsinn"); add("Crystal Meth");}});
        Character character1 = new Character("Claudius von Vengaberg",100,100,200, new ArrayList<String>() {{add("Schild"); add("Schwert");}} );
        Character.saveCharacter(character1,"C:\\Users\\offsp\\IdeaProjects\\RPG-Manager\\src\\main\\resources\\sample.character\\char1static.json");
        Character.saveCharacter(character2, "C:\\Users\\offsp\\IdeaProjects\\RPG-Manager\\src\\main\\resources\\sample.character\\char2static.json");


    }
}
