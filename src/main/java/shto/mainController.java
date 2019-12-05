package shto;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class mainController {

    @FXML
    private static TextField mainCredit;

    public static void setName(String name) {
        //mainCredit.setText(name);
        if (name != null) {
            //do something
            System.out.print("not null");
            mainCredit.setText(name);
        } else {
            //do something else
            System.out.print("null");
        }
    }
}