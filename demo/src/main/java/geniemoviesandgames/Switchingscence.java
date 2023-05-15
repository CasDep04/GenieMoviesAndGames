package geniemoviesandgames;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Scene;

public class Switchingscence extends App {

    @FXML
    protected void switchToRegister() throws IOException {
        scene = new Scene(loadFXML("register"));
        oldStage.setScene(scene);
        oldStage.show();
    }

    @FXML
    protected void switchToMenu() throws IOException {
        scene = new Scene(loadFXML("menu"));
        oldStage.setScene(scene);
        oldStage.show();
    }

    @FXML
    protected void switchToLogin() throws IOException {
        scene = new Scene(loadFXML("login"));
        oldStage.setScene(scene);
        oldStage.show();
    }

    @FXML
    protected void switchToNewUser() throws IOException {
        scene = new Scene(loadFXML("newUser"));
        oldStage.setScene(scene);
        oldStage.show();
    }

    @FXML
    protected void switchToAdmin() throws IOException {    
        scene = new Scene(loadFXML("admin"));
        oldStage.setScene(scene);
        oldStage.show();
    }
}
