package geniemoviesandgames.controller;

import java.io.IOException;

import geniemoviesandgames.Switchingscence;
import geniemoviesandgames.backend.mainSystem;
import geniemoviesandgames.model.user.VipAccount;
import geniemoviesandgames.model.user.account;
import geniemoviesandgames.model.user.guestAccount;
import geniemoviesandgames.model.user.regularAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class yourProfileController extends Switchingscence {

    protected static account mainAcc;
    public int clickTime = 0;

    public static void setMainAcc(account acc) {
        mainAcc = acc;
    }

    public static account getMainAcc() {
        return mainAcc;
    }

    @FXML
    private TextField nameTextfield;
    @FXML
    private TextField addTextfield;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField usernameTextfield;
    @FXML
    private TextField passwordTextfield;
    @FXML
    private Text warningText;
    @FXML
    private Button goBackButton;

    @FXML
    public void beginEdit() throws IOException{
        nameTextfield.setEditable(true);
        addTextfield.setEditable(true);
        phoneTextField.setEditable(true);
        usernameTextfield.setEditable(true);
        passwordTextfield.setEditable(true);
        editProcedure();
    }

    @FXML
    public void goBackAction() throws IOException {
        editProcedure();
        if(clickTime==0){
            switchToMenu();
        }
    }

    public void initialize() {
        nameTextfield.setText(mainAcc.getFullname());
        addTextfield.setText(mainAcc.getAddress());
        phoneTextField.setText(mainAcc.getPhone());
        usernameTextfield.setText(mainAcc.getUsername());
        passwordTextfield.setText(mainAcc.getPassword());
        warningText.setText("");
    }

    public Boolean editCheck(String fulName, String address, String phone, String username, String pass) {
        if (mainAcc.getFullname().equals(fulName) == false || mainAcc.getAddress().equals(address) == false
                || mainAcc.getPhone().equals(phone) == false || mainAcc.getUsername().equals(username) == false
                || mainAcc.getPassword().equals(pass) == false) {
            return false;
        }
        return true;
    }
    public void editProcedure() throws IOException{
        
        if (clickTime > 0) {

            switch (mainAcc.getLevelOfServices()) {
                case Guest:
                    account g1 = new guestAccount(mainAcc.getID(), nameTextfield.getText(), addTextfield.getText(),
                            phoneTextField.getText(), mainAcc.getListOfRentals(), mainAcc.getListOfDates(),
                            usernameTextfield.getText(), passwordTextfield.getText(),mainAcc.getItemReturned());
                    mainSystem.updateAccount(mainAcc, g1);
                    menuController.setMainAcc(g1);
                    switchToMenu();
                    break;
                case Regular:
                    account r1 = new regularAccount(mainAcc.getID(), nameTextfield.getText(), addTextfield.getText(),
                            phoneTextField.getText(), mainAcc.getListOfRentals(), mainAcc.getListOfDates(),
                            usernameTextfield.getText(), passwordTextfield.getText(),mainAcc.getItemReturned());
                    mainSystem.updateAccount(mainAcc, r1);
                    menuController.setMainAcc(r1);
                    switchToMenu();
                    break;
                case VIP:
                    account v1 = new VipAccount(mainAcc.getID(), nameTextfield.getText(), addTextfield.getText(),
                            phoneTextField.getText(), mainAcc.getListOfRentals(), mainAcc.getListOfDates(),
                            usernameTextfield.getText(), passwordTextfield.getText(),mainAcc.getItemReturned());
                    mainSystem.updateAccount(mainAcc, v1);
                    menuController.setMainAcc(v1);
                    switchToMenu();
                    break;
            }
            clickTime = 0;
        }
        if (editCheck(nameTextfield.getText(), addTextfield.getText(), phoneTextField.getText(),
                usernameTextfield.getText(), passwordTextfield.getText()) == false) {
            warningText.setText("Are You Sure");

            clickTime++;
        }
    }
}
