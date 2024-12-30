package inc.PrettyHateMachin.e.App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class AppController {



    final ObservableList<Character> data = FXCollections.observableArrayList(
            new Character("Claudius von Vengaberg",100,100,200,"Schild"),
            new Character("Trevor Noah",75,50,30,"Wahnsinn")
    );
}
