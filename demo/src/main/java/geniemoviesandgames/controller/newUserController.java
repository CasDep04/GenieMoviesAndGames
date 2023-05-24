package geniemoviesandgames.controller;

import java.io.IOException;

import geniemoviesandgames.Switchingscence;
import geniemoviesandgames.backend.mainSystem;
import geniemoviesandgames.model.user.guestAccount;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class newUserController extends Switchingscence {
    @FXML
    TextField nameTextfield;
    @FXML
    TextField phoneTextfield;
    @FXML
    TextField addressTextfield;
    @FXML
    Text warningText;

    @FXML
    private void newUserProcedure() throws IOException {
        if (nameTextfield.getText().isEmpty() == true || phoneTextfield.getText().isEmpty() == true
                || addressTextfield.getText().isEmpty() == true) {
            warningText.setText("Please enter the missing infomation!");
        } else {
            String makeID = "C" + String.format("%03d", mainSystem.getListOfAccounts().size()+1);
            guestAccount g2 = new guestAccount(makeID, nameTextfield.getText(), addressTextfield.getText(),
                    phoneTextfield.getText(),null, null, registerController.getUsername(),
                    registerController.getPassword(),0);
            mainSystem.addAccount(g2);
            menuController.setMainAcc(g2);
            switchToMenu();
        }
    }
}
