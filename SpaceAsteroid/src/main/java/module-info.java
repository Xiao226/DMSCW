module com.vexed.vexed {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    requires java.desktop;

    opens com.comp2059.app to javafx.fxml;
    exports com.comp2059.app;
}