package shto;

import javafx.fxml.FXML;

import java.io.IOException;

public class introController {

    @FXML // so we can have private methods
    private void goToTheGame() throws IOException {
        App.setRoot("main");
    }

}
