package shto;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class mainController {

    // call cards class
    cards cards = new cards();
    // create instance of Random class
    Random random = new Random();

    public TextField credit;
    public TextField bet;
    public TextField info;
    public ImageView image;
    private boolean trigger = false; // it helps us leading the player and resolve some bugs

    public void redClick() {
        click("red");
    }

    public void blackClick() {
        click("black");
    }

    public void cashOutClick() {
    }

    private void click(String color) {

        // it checks if you insert CREDIT
        if (credit.getText().isEmpty() || credit.getText().equals("0") || !credit.getText().replaceAll("\\s", "").matches("[0-9]+")) {
            info.setText("Please insert coins first!");
        }
        // it checks if you insert BET
        else if (bet.getText().isEmpty() || bet.getText().equals("0") || !bet.getText().replaceAll("\\s", "").matches("[0-9]+")) {
            info.setText("Please bet first!");
        }
        // it checks if Bet is greater than CREDIT
        else if (Integer.parseInt(credit.getText().replaceAll("\\s", "")) < Integer.parseInt(bet.getText().replaceAll("\\s", "")) && !trigger) {
            info.setText("You don't have enough credit!");
        } else {
            //boolean chance = random.nextBoolean();
            boolean chance = true;
            takeCredit();
            try {
                flipCard(chance);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            checkWin(color, chance);

            info.setText(String.valueOf(chance));
        }
    }

    // take coins from CREDIT when you BET your first hand
    private void takeCredit() {
        if (!trigger) {
            credit.setText(String.valueOf(Integer.parseInt(credit.getText().replaceAll("\\s", "")) - Integer.parseInt(bet.getText().replaceAll("\\s", ""))));
        }
    }

    // change card according to the color
    private void flipCard(boolean chance) throws FileNotFoundException {

        int index = random.nextInt(26);

        if (chance) {
            FileInputStream input = new FileInputStream(App.class.getResource(cards.cardRedImg[index]).getFile());
            Image imageInput = new Image(input);
            image.setImage(imageInput);
        } else {
            FileInputStream input = new FileInputStream(App.class.getResource(cards.cardBlackImg[index]).getFile());
            Image imageInput = new Image(input);
            image.setImage(imageInput);
        }
    }

    // verify if you win or not
    private void checkWin(String color, boolean chance) {
        if ((color.equals("red") && chance) || (color.equals("black") && !chance)) {
            info.setText("You win!");
            trigger = true;
            bet.setText(String.valueOf(Integer.parseInt(bet.getText().replaceAll("\\s", "")) * 2));
            bet.setDisable(true);
        } else {
            info.setText("You lose!");
            trigger = false;
            bet.setText("");
            bet.setDisable(false);
        }

    }
}