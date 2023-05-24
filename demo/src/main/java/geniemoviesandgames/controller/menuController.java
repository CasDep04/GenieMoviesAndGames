package geniemoviesandgames.controller;

import java.io.IOException;
import java.util.ArrayList;

import geniemoviesandgames.Switchingscence;
import geniemoviesandgames.backend.borrowing;
import geniemoviesandgames.backend.display;
import geniemoviesandgames.backend.returning;
import geniemoviesandgames.backend.roleSpecial;
import geniemoviesandgames.model.returnCheck;
import geniemoviesandgames.model.product.item;
import geniemoviesandgames.model.user.VipAccount;
import geniemoviesandgames.model.user.account;
import geniemoviesandgames.model.user.guestAccount;
import geniemoviesandgames.model.user.regularAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class menuController extends Switchingscence {
    protected static account mainAcc;
    protected static double currentPrice =0.0;

    public static void setMainAcc(account acc) {
        mainAcc = acc;
    }
    public static account getMainAcc() {
        return mainAcc;
    }

    @FXML private Pane downPane;
    @FXML private Button payButton;
    @FXML private Button roleButton;
    @FXML private Text welcomeText;
    @FXML private Text priceText;
    @FXML private Text statusText;
    @FXML private Text BuyingStatusText;
    @FXML private Text roleText;
    @FXML private TableView<item> displayItemTable = new TableView<>();

    @FXML private TableView<item> displayRentTable = new TableView<>();
    @FXML private TableView<returnCheck> displayRentDateTable = new TableView<>();

    //display item table
    private TableColumn<item, String> idCol = new TableColumn<>("ID");
    private TableColumn<item, String> titleCol = new TableColumn<>("Title");
    private TableColumn<item, String> loanTypeCol = new TableColumn<>("Loan type");
    private TableColumn<item, Integer> stockCol = new TableColumn<>("In stock");
    private TableColumn<item, Double> feeCol = new TableColumn<>("Price");
    private TableColumn<item, String> genreCol = new TableColumn<>("Genre");
    //display borrow item
    private TableColumn<item, String> itemBorrowCol = new TableColumn<>("Item");
    private TableColumn<returnCheck, String> dateBorrowCol = new TableColumn<>("Date Borrow");
    private TableColumn<returnCheck, String> dateReturnCol = new TableColumn<>("Date Return");
    private TableColumn<returnCheck, String> dateStatusCol = new TableColumn<>("Status");
    //

    ObservableList<item> data = FXCollections.observableArrayList();

    ObservableList<item> itemRentData = FXCollections.observableArrayList(mainAcc.getListOfRentals());
    ObservableList<returnCheck> itemBorrowStatusData = FXCollections.observableArrayList();


    public void displayitem(ArrayList<item> listIn){

        data.clear();
        data.addAll(listIn);
        idCol.setCellValueFactory(new PropertyValueFactory<item, String>("ID"));
        titleCol.setCellValueFactory(new PropertyValueFactory<item, String>("title"));
        loanTypeCol.setCellValueFactory(new PropertyValueFactory<item, String>("loantype"));
        stockCol.setCellValueFactory(new PropertyValueFactory<item, Integer>("stock"));
        feeCol.setCellValueFactory(new PropertyValueFactory<item, Double>("fees"));
        genreCol.setCellValueFactory(new PropertyValueFactory<item, String>("genre")); 
        //
        displayItemTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        displayItemTable.getColumns().clear();
        displayItemTable.setItems(data);
        displayItemTable.getColumns().addAll(idCol,titleCol,loanTypeCol,stockCol,feeCol,genreCol);
    }

    public void displayRentItem(){
        
        itemRentData.clear();
        itemBorrowStatusData.clear();
        itemRentData.addAll(mainAcc.getListOfRentals());
        for (int i =0;i<mainAcc.getListOfRentals().size();i++){
            
            returnCheck rc1 = new returnCheck(mainAcc, mainAcc.getListOfRentals().get(i));
            
            itemBorrowStatusData.add(rc1);
        }
        itemBorrowCol.setCellValueFactory(new PropertyValueFactory<item, String>("title"));
        dateBorrowCol.setCellValueFactory(new PropertyValueFactory<returnCheck, String>("dateBorrow"));
        dateReturnCol.setCellValueFactory(new PropertyValueFactory<returnCheck, String>("dateReturn"));
        dateStatusCol.setCellValueFactory(new PropertyValueFactory<returnCheck, String>("userDeadline"));

        displayRentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        displayRentTable.getColumns().clear();
        displayRentTable.setItems(itemRentData);
        displayRentTable.getColumns().add(itemBorrowCol);
        displayRentDateTable.getColumns().clear();
        displayRentDateTable.setItems(itemBorrowStatusData);
        displayRentDateTable.getColumns().addAll(dateBorrowCol,dateReturnCol,dateStatusCol);
    }
    @FXML public void displayAllItem(){
        displayitem(display.allItem());
    }
    @FXML public void displayAllDVD(){
        displayitem(display.allDVD());
    }
    @FXML public void displayAllGame(){
        displayitem(display.allGame());
    }
    @FXML public void displayAllRecord(){
        displayitem(display.allRecord());
    }
    @FXML public void displayNocopies(){
        displayitem(display.allNocopies());
    }
    @FXML public void paying(){
        priceText.setText("= 0.0");
    }
    @FXML public void editProfileButton() throws IOException{
        yourProfileController.setMainAcc(mainAcc);
        switchToYourProfile();
    }
    @FXML public void borrowAction(){
        
        item i2 =  displayItemTable.getSelectionModel().getSelectedItem();
         if(i2!=null && i2.getStock()!=0){
            setMainAcc(borrowing.accBorrow(mainAcc, i2));
            updateMenu();
        }else{
            BuyingStatusText.setText("you cannot borrow that!");
        }
    }
    @FXML public void returnAction(){
        item i3 =  displayRentTable.getSelectionModel().getSelectedItem();
        if(mainAcc instanceof VipAccount){
            VipAccount v1 = (VipAccount) mainAcc;
            if(v1.getFreeRent()>0){
                v1.setFreeRent(v1.getFreeRent()-1);
                currentPrice+=0.0;
            }
        }else if(i3!=null && i3.getStock()!=0){
           setMainAcc(returning.accReturn(mainAcc, i3));
           currentPrice+=i3.getFees();
           updateMenu();
        }
        updateMenu();
        priceText.setText("="+Double.toString(currentPrice));
    }
    @FXML public void promoteAction(){
        roleButton.setDisable(true);
        setMainAcc(roleSpecial.promoteAcc(mainAcc));
        updateMenu();
    }

    public void updateMenu(){
        welcomeText.setText(mainAcc.getFullname());
        if(mainAcc instanceof VipAccount){
            VipAccount v1 = (VipAccount) mainAcc;
            roleText.setText(v1.getPoints()+"points /100 for free rent");
            if(v1.getPoints()>=100){
                roleButton.setDisable(false);
            }
            roleButton.setText("free rent");
            statusText.setText("VIP");
        }else if(mainAcc instanceof guestAccount){
            guestAccount g1 = (guestAccount) mainAcc;
            roleText.setText(g1.getItemReturned()+"return /3 for promotion");
            if(g1.getItemReturned()>=3){
                roleButton.setDisable(false);
            }
            roleButton.setText("promote");
            statusText.setText("Guest");
        }else{
            regularAccount r1 = (regularAccount) mainAcc;
            roleText.setText(r1.getItemReturned()+"return /5 for promotion");
            if(r1.getItemReturned()>=5){
                roleButton.setDisable(false);
            }
            roleButton.setText("promote");
            statusText.setText("Regular");
        }
        
        BuyingStatusText.setText("");
        displayitem(display.allItem());
        displayRentItem();
    }
    public void initialize() {

        // set collumn width
        idCol.setPrefWidth(70);
        titleCol.setPrefWidth(125);
        loanTypeCol.setPrefWidth(90);
        stockCol.setPrefWidth(70);
        feeCol.setPrefWidth(70);
        genreCol.setPrefWidth(90);
        //
        itemBorrowCol.setPrefWidth(100);
        dateBorrowCol.setPrefWidth(100);
        dateReturnCol.setPrefWidth(100);
        dateStatusCol.setPrefWidth(100);
        // set collumn data
        welcomeText.setText(mainAcc.getFullname());
        statusText.setText(mainAcc.getLevelOfServices().toString());
        updateMenu();
        //
        // display
    }

}
