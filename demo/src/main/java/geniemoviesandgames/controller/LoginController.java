package geniemoviesandgames.controller;

import java.io.IOException;

import geniemoviesandgames.Switchingscence;
import geniemoviesandgames.backend.mainSystem;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class LoginController extends Switchingscence {

    @FXML
    TextField usernameInputTextField;
    @FXML
    Text warningText;
    @FXML
    PasswordField passwordInput;

    @FXML
    private void loginProcedure() throws IOException {

        if (usernameInputTextField.getText().isEmpty() == true || passwordInput.getText().isEmpty() == true) {
            warningText.setText("Please enter username or password");
        }else if(usernameInputTextField.getText().equals("123") ==true && passwordInput.getText().equals("123") ==true){
            switchToAdmin();
        } else if(mainSystem.acountLogin(usernameInputTextField.getText(), passwordInput.getText()) == true){
            switchToMenu();
        }else{
            warningText.setText("You enter the wrong username or password");
        }

        // loop through all accounts and check username/pwd
    }

    

}
