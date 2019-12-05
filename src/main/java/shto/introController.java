package shto;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class introController {

    public TextField credit;
    public TextField infoBox;

    @FXML // so we can have private methods
    private void goToTheGame() throws IOException {
        if (credit.getText().trim().isEmpty() || !credit.getText().matches("[0-9]+")) {
            infoBox.setText("ENTER A NUMBER");
        } else if (credit.getText().matches("[0-9]+")) {
            mainController.setName(credit.getText());
            App.setRoot("main");
        }
    }

}
