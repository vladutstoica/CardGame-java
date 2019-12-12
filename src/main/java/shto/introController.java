package shto;

import javafx.scene.control.Button;

import java.io.IOException;

public class introController {
    public Button newGameBtn;

    public void goToTheGame() throws IOException {
        App.setRoot("mainScene", "main");
    }

    /*
    public TextField credit;
    public TextField infoBox;
    public Button newGameBtn;

    public void goToTheGame() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        loader.load();

        // Get controller of scene2
        mainController mainController = loader.getController();

        // Pass whatever data you want. You can have multiple method calls here
        if (credit.getText().trim().isEmpty() || !credit.getText().matches("[0-9]+")) {
            infoBox.setText("ENTER A NUMBER");
        } else {
            App.setRoot("mainScene", "main");
            newGameBtn.setOnAction(event -> mainController.mainCredit.setText("credit.getText()"));
            mainController.name = credit.getText();
        }
    }
    */

}
