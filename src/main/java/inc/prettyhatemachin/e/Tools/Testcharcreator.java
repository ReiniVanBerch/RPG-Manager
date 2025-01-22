package inc.prettyhatemachin.e.Tools;
import inc.prettyhatemachin.e.App.Character;


import java.util.ArrayList;

public class Testcharcreator {
    public static void main(String[] args){
        Character character2 = new Character("Trevor Noah",75,50,30,new ArrayList<String>(){{add("Wahnsinn"); add("Crystal Meth");}});
        Character character1 = new Character("Claudius von Vengaberg",100,100,20, new ArrayList<String>() {{add("Schild"); add("Schwert");}} );
        Character.saveCharacter(character1,"C:\\Users\\offsp\\IdeaProjects\\RPG-Manager\\src\\main\\resources\\sample.character\\char1static.json");
        Character.saveCharacter(character2, "C:\\Users\\offsp\\IdeaProjects\\RPG-Manager\\src\\main\\resources\\sample.character\\char2static.json");


        Character character3 = new Character("Vincent Vega",50,30,15,new ArrayList<String>(){{add("Uzi"); add("brauner Lederkoffer");}},"Drogenkosnum", 3);
        Character character4 = new Character("Marcellus Wallace",100,100,11, new ArrayList<String>() {{add("Pflaster"); add("Gimpsuit");add("Bündel Bargeld");}} ,"Tanzskill",0);
        Character.saveCharacter(character3,"C:\\Users\\offsp\\IdeaProjects\\RPG-Manager\\src\\main\\resources\\sample.character\\char3static.json");
        Character.saveCharacter(character4, "C:\\Users\\offsp\\IdeaProjects\\RPG-Manager\\src\\main\\resources\\sample.character\\char4static.json");

    }
}
