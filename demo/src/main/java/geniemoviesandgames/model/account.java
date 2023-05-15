package geniemoviesandgames.model;

import java.util.ArrayList;

abstract public class account {
    public String customerID;
    public String customerFullname;
    public String customerUsername;
    public String customerPassWord;
    public int customerPhone;
    public String customerAddress;
    public ArrayList<item> customerListofRentals = new ArrayList<>();

    /**
     * @return String return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * @return String return the customerFullname
     */
    public String getCustomerFullname() {
        return customerFullname;
    }

    /**
     * @param customerFullname the customerFullname to set
     */
    public void setCustomerFullname(String customerFullname) {
        this.customerFullname = customerFullname;
    }

    /**
     * @return String return the customerUsername
     */
    public String getCustomerUsername() {
        return customerUsername;
    }

    /**
     * @param customerUsername the customerUsername to set
     */
    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    /**
     * @return String return the customerPassWord
     */
    public String getCustomerPassWord() {
        return customerPassWord;
    }

    /**
     * @param customerPassWord the customerPassWord to set
     */
    public void setCustomerPassWord(String customerPassWord) {
        this.customerPassWord = customerPassWord;
    }

    /**
     * @return int return the customerPhone
     */
    public int getCustomerPhone() {
        return customerPhone;
    }

    /**
     * @param customerPhone the customerPhone to set
     */
    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * @return String return the customerAddress
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * @param customerAddress the customerAddress to set
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * @return item[] return the customerListofRentals
     */
    public ArrayList<item> getCustomerListofRentals() {
        return customerListofRentals;
    }

    /**
     * @param customerListofRentals the customerListofRentals to set
     */
    public void setCustomerListofRentals(ArrayList<item> rentList) {
        if(rentList!=null){
            customerListofRentals.addAll(rentList);
        }
    }
    public account(){
        setCustomerAddress(null);
        setCustomerFullname(null);
        setCustomerID(null);
        setCustomerPassWord(null);
        setCustomerPhone(0);
        setCustomerUsername(null);
        setCustomerListofRentals(null);
    }

    public account(String ID,String name, String address,int phone,ArrayList<item> rentals,String username,String password){
        setCustomerAddress(address);
        setCustomerFullname(name);
        setCustomerID(ID);
        setCustomerPassWord(password);
        setCustomerPhone(phone);
        setCustomerUsername(username);
        if(rentals != null){
            setCustomerListofRentals(rentals);
        }
    }
}
