module com.example.javafx_pacman {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.javafx_pacman to javafx.fxml;
    exports com.example.javafx_pacman;
}