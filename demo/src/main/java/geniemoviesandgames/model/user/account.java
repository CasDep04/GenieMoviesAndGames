package geniemoviesandgames.model.user;

import java.time.LocalDate;
import java.util.ArrayList;

import geniemoviesandgames.model.product.item;

abstract public class account {

    public enum LevelOfServices {
        Guest, Regular, VIP
    }

    protected String ID;
    protected String fullname;
    protected String username;
    protected String password;
    protected String phone;
    protected String address;
    protected LevelOfServices levelOfServices;

    protected ArrayList<item> listOfRentals = new ArrayList<>();
    protected ArrayList<LocalDate> listOfDate = new ArrayList<>();

    /**
     * @return String return the accountID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setID(String accountID) {
        this.ID = accountID;
    }

    /**
     * @return String return the accountFullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param accountFullname the accountFullname to set
     */
    public void setFullname(String accountFullname) {
        this.fullname = accountFullname;
    }

    /**
     * @return String return the accountUsername
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param accountUsername the accountUsername to set
     */
    public void setUsername(String accountUsername) {
        this.username = accountUsername;
    }

    /**
     * @return String return the accountPassword
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param accountPassword the accountPassword to set
     */
    public void setPassword(String accountPassword) {
        this.password = accountPassword;
    }

    /**
     * @return int return the accountPhone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param accountPhone the accountPhone to set
     */
    public void setPhone(String accountPhone) {
        this.phone = accountPhone;
    }

    /**
     * @return String return the accountAddress
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param accountAddress the accountAddress to set
     */
    public void setAddress(String accountAddress) {
        this.address = accountAddress;
    }

    /**
     * @return item[] return the accountListOfRentals
     */
    public ArrayList<item> getListOfRentals() {
        return listOfRentals;
    }

    /**
     * @param listOfRentals the accountListOfRentals to set
     */
    public void setListOfRentals(ArrayList<item> rentList) {
        if (rentList != null) {
            listOfRentals.clear();
            listOfRentals.addAll(rentList);
        }
    }

    public ArrayList<LocalDate> getListOfDates(){
        return listOfDate;
    }

    public LocalDate getDate(item itemIn){
        if(listOfRentals.contains(itemIn)){
    
            return listOfDate.get(listOfRentals.indexOf(itemIn));
        }
        else{return null;}
    }

    public void setDate(item itemIn,LocalDate date){
        if(listOfRentals.contains(itemIn)){
            listOfDate.set(listOfRentals.indexOf(itemIn),date);
        }
    }

    public void setListOfDates(ArrayList<LocalDate> dateList){
        if (dateList != null) {
            listOfDate.clear();
            listOfDate.addAll(dateList);
        }
    }

    public LevelOfServices getLevelOfServices() {
        return this.levelOfServices;
    }

    public void setLevelOfServices(LevelOfServices services) {
        this.levelOfServices = services;
    }
    
    public account() {
    }

    public account(String ID, String name, String address, String phone, ArrayList<item> rentals,ArrayList<LocalDate> date, LevelOfServices services,
            String username, String password,int numReturned) {
        setAddress(address);
        setFullname(name);
        setID(ID);
        setPassword(password);
        setPhone(phone);
        setUsername(username);
        setLevelOfServices(services);
        setItemBorrow(rentals.size());
        setItemReturned(numReturned);
        if (rentals != null) {
            setListOfRentals(rentals);
        }
        if (date != null) {
            setListOfDates(date);
        }
    }

    /* service Setup */
    protected int itemBorrow = 0;
    protected int itemReturned = 0;

    /**
     * @return int itemBorrow return the
     */
    public int getItemBorrow() {
        return this.itemBorrow;
    }

    /**
     * @param the to set
     */
    public void setItemBorrow(int itemBorrow) {
        this.itemBorrow = itemBorrow;
    }

    /**
     * @return int return the itemReturned
     */
    public int getItemReturned() {
        return itemReturned;
    }

    /**
     * @param itemReturned the itemReturned to set
     */
    public void setItemReturned(int itemReturned) {
        this.itemReturned = itemReturned;
    }


    
    public void accBorrowItem(item itemIn){
        itemBorrow++;
        listOfRentals.add(itemIn);
        listOfDate.add(LocalDate.now());
        System.out.println("add successfully");
    }



    public void accBorrowItem(item itemIn,LocalDate date){
        listOfRentals.add(itemIn);
        listOfDate.add(date);
        itemBorrow++;
        System.out.println("add successfully");
    }

    public void accBorrowItem(ArrayList<item> listItemIn,ArrayList<LocalDate> listdates){

        listOfRentals.addAll(listItemIn);
        listOfDate.addAll(listdates);
        itemBorrow+=listItemIn.size();
        System.out.println("add successfully");
    }

    public void accReturnItem(item itemIn){
        if(listOfRentals.contains(itemIn)){

            listOfRentals.remove(itemIn);
            listOfDate.remove(listOfRentals.indexOf(itemIn)+1);
            itemReturned+=1;
        }
    }


}
