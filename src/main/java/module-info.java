module inc.prettyhatemachin.e {

    //javaFX stuff
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

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

    exports inc.prettyhatemachin.e.App;
    exports inc.prettyhatemachin.e.Character;
    exports inc.prettyhatemachin.e.Exception;
    exports inc.prettyhatemachin.e.Main;
    exports inc.prettyhatemachin.e.Tools;
    exports inc.prettyhatemachin.e.Quality;





}
