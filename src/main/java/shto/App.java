package shto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


    private static Scene introScene, mainScene;
    private static Stage window;

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        introScene = new Scene(loadFXML("intro"), 500, 300);
        mainScene = new Scene(loadFXML("intro"), 700, 500);
        stage.setScene(introScene); // change to introScene when it's ready
        stage.show();
    }

    //static void setRoot(String fxml) throws IOException {
    //    introScene.setRoot(loadFXML(fxml));
    //}

    static void setRoot(String setscene, String fxml) throws IOException {
        if (setscene.equals("mainScene")) {
            window.setScene(mainScene);
            mainScene.setRoot(loadFXML(fxml));
        } else if (setscene.equals("introScene")) {
            window.setScene(introScene);
            introScene.setRoot(loadFXML(fxml));
        }
    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}