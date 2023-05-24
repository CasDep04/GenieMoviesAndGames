package geniemoviesandgames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import geniemoviesandgames.backend.mainSystem;

/**
 * JavaFX App - update comments
 */
public class App extends Application {

    protected static Scene scene;
    protected static Stage oldStage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        oldStage = stage;
        stage.setScene(scene);
        stage.setTitle("genie movies and games");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    protected static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("screen_design/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    @Override
    public void stop() throws Exception {
        // Perform any necessary cleanup or save operations here
        mainSystem.saveItemsToFile();
        mainSystem.saveAccountsToFile();
        System.out.println("Application stopped");
    }

    public static void main(String[] args) {

        mainSystem.readItemsFromFile();
        mainSystem.readAccountsFromFile();

        Application.launch(args);
    }

}