package shto;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class introController {

    public Button button;

    public void goToTheGame() throws IOException {
        //if (credit.getText().trim().isEmpty() || !credit.getText().matches("[0-9]+")) {
        //    infoBox.setText("ENTER A NUMBER");
        //} else {
        //    mainController.setName("test");
        //    App.setRoot("main");
        //}
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        loader.load();

        // Get controller of scene2
        mainController mainController = loader.getController();

        // Pass whatever data you want. You can have multiple method calls here

        App.setRoot("main");
        button.setOnAction(e -> mainController.setName("test"));
        //mainController.setName("test");

    }
}
