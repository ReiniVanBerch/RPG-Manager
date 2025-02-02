module inc.prettyhatemachin.e {

    //javaFX stuff
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;



    requires kotlin.stdlib;
    requires jdk.jsobject;
    requires org.json;
    requires jdk.jdi;
    requires java.desktop;
    requires java.sql;


    exports inc.prettyhatemachin.e.App;
    exports inc.prettyhatemachin.e.CharacterDynamic;
    exports inc.prettyhatemachin.e.Exception;
    exports inc.prettyhatemachin.e.TestingGrounds;
    exports inc.prettyhatemachin.e.Tools;
    exports inc.prettyhatemachin.e.Quality;
    exports inc.prettyhatemachin.e.Controller;

    opens inc.prettyhatemachin.e.Controller;
    opens inc.prettyhatemachin.e.App to javafx.fxml;
    exports inc.prettyhatemachin.e.FuneralPyre;

}
