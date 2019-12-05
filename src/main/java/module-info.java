module shto {
    requires javafx.controls;
    requires javafx.fxml;


    opens shto to javafx.fxml;
    exports shto;
}