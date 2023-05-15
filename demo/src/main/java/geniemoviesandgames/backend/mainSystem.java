package geniemoviesandgames.backend;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import geniemoviesandgames.model.DVD;
import geniemoviesandgames.model.Vip;
import geniemoviesandgames.model.account;
import geniemoviesandgames.model.game;
import geniemoviesandgames.model.guest;
import geniemoviesandgames.model.item;
import geniemoviesandgames.model.movies;
import geniemoviesandgames.model.regular;

public class mainSystem {
    private static ArrayList<item> listOfItems = new ArrayList<>();
    private static ArrayList<account> listOfAccounts = new ArrayList<>();
    private final static String itemFilePath = "../GenieMoviesAndGames/demo/src/main/resources/geniemoviesandgames/items.txt";
    private final static String accountFilePath = "../GenieMoviesAndGames/demo/src/main/resources/geniemoviesandgames/customers.txt";

    public static ArrayList<item> getListOfItems() {
        return listOfItems;
    }

    public static ArrayList<account> getListOfAccounts() {
        return listOfAccounts;
    }
    
    public static void addListOfItems(item itemIn){
        listOfItems.add(itemIn);
    }

    public static void addlistOfAccounts(account accin){
        listOfAccounts.add(accin);
    }

    public static item searchItemByID(String id) {
        for (item i : listOfItems) {
            if ((i.getItemID()).equals(id)) {
                return i;
            }
        }
        return null;
    }

    public static account searchAccountByID(String id) {
        for (account a : listOfAccounts) {
            if ((a.getCustomerID()).equals(id)) {
                return a;
            }
        }
        return null;
    }

    public static Boolean acountLogin(String username, String password) {
        for (account a : listOfAccounts) {
            if ((a.getCustomerUsername()).equals(username) && a.getCustomerPassWord().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void readItemsFromFile() {
        FileReader ItemFiles;
        BufferedReader br;
        try {
            ItemFiles = new FileReader(itemFilePath);
            br = new BufferedReader(ItemFiles);
            String line;
            Boolean Item2Day;
            String[] fields;
            String itemID, itemTitle, itemType, itemLoanType;
            double itemPrice;
            int itemCopies;
            while ((line = br.readLine()) != null) {

                fields = line.split(",");
                itemID = fields[0];
                itemTitle = fields[1];
                itemType = fields[2];
                itemLoanType = fields[3];
                itemCopies = Integer.parseInt(fields[4]);
                itemPrice = Double.parseDouble(fields[5]);

                if (itemLoanType == "1-week") {
                    Item2Day = false;
                } else {
                    Item2Day = true;
                }

                switch (itemType) {
                    case "Game":
                        game g1 = new game(itemID, itemTitle, Item2Day, itemCopies, itemPrice);
                        listOfItems.add(g1);
                        break;
                    case "Record":
                        String ItemGenre = fields[6];
                        movies m1 = new movies(itemID, itemTitle, Item2Day, itemCopies, itemPrice, ItemGenre);
                        listOfItems.add(m1);
                        break;
                    case "DVD":
                        ItemGenre = fields[6];
                        DVD d1 = new DVD(itemID, itemTitle, Item2Day, itemCopies, itemPrice, ItemGenre);
                        listOfItems.add(d1);
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readCustomersFromFile() {
        FileReader customerFile;
        BufferedReader br1;
        try {
            customerFile = new FileReader(accountFilePath);
            br1 = new BufferedReader(customerFile);
            String line;
            String[] fields;
            String id = null, name = null, address = null, username = null, password = null, customerType = null;
            int phone = 0;
            ArrayList<item> itemOwn = new ArrayList<>();

            while ((line = br1.readLine()) != null) {
                if (line.charAt(0) == 'C') {
                    fields = line.split(",");
                    id = fields[0];
                    name = fields[1];
                    address = fields[2];
                    phone = Integer.parseInt(fields[3]);
                    customerType = fields[5];
                    username = fields[6];
                    password = fields[7];
                    if(fields[4] =="0"){
                        itemOwn=null;
                    }
                } else {
                    itemOwn.add(searchItemByID(id));
                }
                switch (customerType) {
                    case "VIP":
                        Vip v1 = new Vip(id, name, address, phone, itemOwn, username, password);
                        listOfAccounts.add(v1);
                        break;
                    case "Guest":
                        guest g1 = new guest(id, name, address, phone, itemOwn, username, password);
                        listOfAccounts.add(g1);
                        break;
                    case "Regular":
                        regular r1 = new regular(id, name, address, phone, itemOwn, username, password);
                        listOfAccounts.add(r1);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addItemToTextFile(item itemIn) {
        String phrase;
        String LoanType;
        String itemType;
        if (itemIn.isItem2DayLoan() == true) {
            LoanType = "2-day";
        } else {
            LoanType = "1-week";
        }
        if (itemIn instanceof game) {
            itemType = "Game";
        } else if (itemIn instanceof DVD) {
            itemType = "DVD";
        } else {
            itemType = "Record";
        }

        phrase = itemIn.getItemID() + "," + itemIn.getItemTitle() + "," + itemType + "," + LoanType + ","
                + Integer.toString(itemIn.getItemCopies()) + "," + Double.toString(itemIn.getItemFees());
        try {
            FileWriter fw = new FileWriter(itemFilePath, true);
            fw.write("\n" + phrase);
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void addaccountToTextFile(account accIn) {
        String phrase;
        String accType = "Guest";
        String itemrentSize;
        String ItemList ="";
         if(accIn.getCustomerListofRentals()== null){
            itemrentSize="0";
        } else{
            itemrentSize=Integer.toString(accIn.getCustomerListofRentals().size());
            for(int i=0;i<accIn.getCustomerListofRentals().size();i++){
                ItemList = ItemList+"/n"+accIn.getCustomerListofRentals().get(i);
            }
        }
        if (accIn instanceof guest) {
            accType = "Guest";
        } else if (accIn instanceof regular) {
            accType = "Regular";
        } else if (accIn instanceof Vip) {
            accType = "VIP";
        }
        phrase = accIn.getCustomerID() + "," + accIn.getCustomerFullname() + "," + accIn.getCustomerAddress() + ","
                + Integer.toString(accIn.getCustomerPhone()) + "," + itemrentSize + ","
                + accType + "," + accIn.getCustomerUsername() + "," + accIn.getCustomerPassWord()+ItemList;
        try {
            FileWriter fw = new FileWriter(accountFilePath,true);
            fw.write("\n" +phrase);
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void editItemTextFile(String wordToReplace,String wordReplacing){
        try {
            File fileToEdit = new File(itemFilePath);
            BufferedReader reader = new BufferedReader(new FileReader(fileToEdit));

            String line = "", oldText = "";
            while((line = reader.readLine()) != null) {
                oldText += line + "\n";
            }
            reader.close();

            // replace old text with new text
            String newContent = oldText.replaceAll(wordToReplace, wordReplacing);

            // write new content to file
            FileWriter writer = new FileWriter(fileToEdit);
            writer.write(newContent);
            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    };

    public static void editAccountTextFile(String wordToReplace,String wordReplacing){
        try {
            File fileToEdit = new File(accountFilePath);
            BufferedReader reader = new BufferedReader(new FileReader(fileToEdit));

            String line = "", oldText = "";
            while((line = reader.readLine()) != null) {
                oldText += line + "\n";
            }
            reader.close();

            // replace old text with new text
            String newContent = oldText.replaceAll(wordToReplace, wordReplacing);

            // write new content to file
            FileWriter writer = new FileWriter(fileToEdit);
            writer.write(newContent);
            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
