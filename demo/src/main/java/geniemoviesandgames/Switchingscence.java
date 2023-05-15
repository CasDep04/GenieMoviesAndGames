package geniemoviesandgames;

import java.io.IOException;

import javafx.fxml.FXML;

public class Switchingscence extends App {

    @FXML
    protected void switchToRegister() throws IOException {
        App.setRoot("register");
    }

    @FXML
    protected void switchToMenu() throws IOException {
        App.setRoot("menu");
    }

    @FXML
    protected void switchToLogin() throws IOException {
        App.setRoot("login");
    }

    @FXML
    protected void switchToNewUser() throws IOException {
        App.setRoot("newUser");
    }

    @FXML
    protected void switchToAdmin() throws IOException {
        App.setRoot("admin");
    }
}
