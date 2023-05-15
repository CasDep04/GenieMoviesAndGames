package geniemoviesandgames.controller;

import java.io.IOException;

import geniemoviesandgames.Switchingscence;
import geniemoviesandgames.backend.mainSystem;
import geniemoviesandgames.model.guest;
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
            String makeID = "C" + String.format("%03d", mainSystem.getListOfAccounts().size());
            guest g2 = new guest(makeID, nameTextfield.getText(), addressTextfield.getText(),
                    Integer.parseInt(phoneTextfield.getText()), null, registerController.getUsername(),
                    registerController.getPassword());
            mainSystem.addlistOfAccounts(g2);
            mainSystem.addaccountToTextFile(g2);
            switchToMenu();
        }
    }
}
